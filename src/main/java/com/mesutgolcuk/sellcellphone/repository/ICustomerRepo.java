package com.mesutgolcuk.sellcellphone.repository;

import com.mesutgolcuk.sellcellphone.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends JpaRepository<CustomerEntity, Long> {

}