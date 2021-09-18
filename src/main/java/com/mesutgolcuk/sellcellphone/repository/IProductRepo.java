package com.mesutgolcuk.sellcellphone.repository;

import com.mesutgolcuk.sellcellphone.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends JpaRepository<ProductEntity, Long> {
}
