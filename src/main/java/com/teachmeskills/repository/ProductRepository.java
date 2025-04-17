package com.teachmeskills.repository;

import com.teachmeskills.model.Smartphone;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Smartphone, Long> {

//    @Transactional(rollbackOn = Exception.class)
//    @Modifying
//    @Query(value = "INSERT INTO l_user_products (user_id, product_id) VALUES (:userId, :productId)", nativeQuery = true)
//    int addProductToUser(Smartphone smartphone);

}
