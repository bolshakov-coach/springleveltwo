package pro.bolshakov.geekbrains.springleveltwo.shop.service;

import pro.bolshakov.geekbrains.springleveltwo.shop.domain.Bucket;
import pro.bolshakov.geekbrains.springleveltwo.shop.domain.User;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);

    void addProducts(Bucket bucket, List<Long> productIds);
}
