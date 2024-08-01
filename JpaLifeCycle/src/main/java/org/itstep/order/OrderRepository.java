package org.itstep.order;

import org.itstep.table.TableRest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderRest, Long> {
} 