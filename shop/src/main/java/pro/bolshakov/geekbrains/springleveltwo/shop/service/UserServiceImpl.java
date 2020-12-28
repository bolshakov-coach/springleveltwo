package pro.bolshakov.geekbrains.springleveltwo.shop.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pro.bolshakov.geekbrains.springleveltwo.shop.dao.UserRepository;
import pro.bolshakov.geekbrains.springleveltwo.shop.domain.Role;
import pro.bolshakov.geekbrains.springleveltwo.shop.domain.User;
import pro.bolshakov.geekbrains.springleveltwo.shop.dto.UserDto;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final MailSenderService mailSenderService;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           MailSenderService mailSenderService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailSenderService = mailSenderService;
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean save(UserDto userDto) {
        if(!Objects.equals(userDto.getPassword(), userDto.getMatchingPassword())){
            throw new RuntimeException("Password is not equal");
        }
        User user = User.builder()
                .name(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .email(userDto.getEmail())
                .role(Role.CLIENT)
                .activeCode(UUID.randomUUID().toString())
                .build();
        this.save(user);
        return true;
    }

    @Override
    public User findByName(String name) {
        return userRepository.findFirstByName(name);
    }

    @Override
    @Transactional
    public void updateProfile(UserDto dto) {
        User savedUser = userRepository.findFirstByName(dto.getUsername());
        if(savedUser == null){
            throw new RuntimeException("User not found by name " + dto.getUsername());
        }

        boolean changed = false;
        if(dto.getPassword() != null && !dto.getPassword().isEmpty()){
            savedUser.setPassword(passwordEncoder.encode(dto.getPassword()));
            changed = true;
        }
        if(!Objects.equals(dto.getEmail(), savedUser.getEmail())){
            savedUser.setEmail(dto.getEmail());
            changed = true;
        }
        if(changed){
            userRepository.save(savedUser);
        }
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
        if(user.getActiveCode() != null && !user.getActiveCode().isEmpty()){
            mailSenderService.sendActivateCode(user);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findFirstByName(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found with name: " + username);
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                roles);
    }

    @Override
    @Transactional
    public boolean activateUser(String activateCode) {
        if(activateCode == null || activateCode.isEmpty()){
            return false;
        }
        User user = userRepository.findFirstByActiveCode(activateCode);
        if(user == null){
            return false;
        }

        user.setActiveCode(null);
        userRepository.save(user);

        return true;
    }

    private UserDto toDto(User user){
        return UserDto.builder()
                .username(user.getName())
                .email(user.getEmail())
                .activated(user.getActiveCode() == null)
                .build();
    }
}
