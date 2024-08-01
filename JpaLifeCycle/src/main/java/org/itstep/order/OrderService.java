package org.itstep.order;

import org.itstep.table.TableRepository;
import org.itstep.table.TableRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderRest> findAll() {
        return (List<OrderRest>) orderRepository.findAll();
    }
}