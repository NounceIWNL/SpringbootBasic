package org.itstep.order;

import org.itstep.table.TableRest;
import org.itstep.table.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<OrderRest> getOrders() {
        var orders = (List<OrderRest>) orderService.findAll();
        return orders;
    }
}