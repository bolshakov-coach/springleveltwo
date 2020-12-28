package pro.bolshakov.geekbrains.springleveltwo.shop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import pro.bolshakov.geekbrains.springleveltwo.shop.dao.ProductRepository;
import pro.bolshakov.geekbrains.springleveltwo.shop.domain.Product;
import pro.bolshakov.geekbrains.springleveltwo.shop.dto.ProductDto;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    private ProductService productService;

    @Mock
    private ProductRepository productRepository;
    @Mock
    private UserService userService;
    @Mock
    private BucketService bucketService;
    @Mock
    private SimpMessagingTemplate template;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository, userService, bucketService, template);
    }

    @Test
    void getById() {
        //have
        Product product = Product.builder()
                .id(10L)
                .title("Product")
                .price(10.5)
                .build();

        Mockito.when(productRepository.findById(Mockito.eq(10L))).thenReturn(Optional.of(product));
        //execute

        ProductDto productDto = productService.getById(10L);

        //check
        Assertions.assertNotNull(productDto);
        Assertions.assertEquals(product.getId(), productDto.getId());
        Assertions.assertEquals(product.getTitle(), productDto.getTitle());
        Assertions.assertEquals(product.getPrice(), productDto.getPrice());

    }
}