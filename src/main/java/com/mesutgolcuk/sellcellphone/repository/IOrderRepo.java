package com.mesutgolcuk.sellcellphone.repository;

import com.mesutgolcuk.sellcellphone.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo  extends JpaRepository<OrderEntity, Long> {
}
