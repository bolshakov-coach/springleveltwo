package pro.bolshakov.geekbrains.springleveltwo.shop.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pro.bolshakov.geekbrains.springleveltwo.shop.dto.UserDto;

public interface UserService extends UserDetailsService {
    boolean save(UserDto userDto);
}
