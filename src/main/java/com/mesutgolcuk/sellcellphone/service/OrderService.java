package com.mesutgolcuk.sellcellphone.service;

import com.mesutgolcuk.sellcellphone.entity.CustomerEntity;
import com.mesutgolcuk.sellcellphone.entity.OrderEntity;
import com.mesutgolcuk.sellcellphone.exception.NoContentFoundException;
import com.mesutgolcuk.sellcellphone.repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;

    public void saveOrder(OrderEntity order) {
        orderRepo.save(order);
    }
}
