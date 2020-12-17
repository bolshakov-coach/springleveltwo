package pro.bolshakov.geekbrains.springleveltwo.shop.service;

import org.springframework.stereotype.Service;
import pro.bolshakov.geekbrains.springleveltwo.shop.dao.OrderRepository;
import pro.bolshakov.geekbrains.springleveltwo.shop.domain.Order;

import javax.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
