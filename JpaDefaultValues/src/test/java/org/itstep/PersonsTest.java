package org.itstep;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PersonsTest {
    @Autowired
    private CustomerRepository customerRepository;
    private SupplierRepository supplierRepository;

    @Test
    public void createCustomer() {
        Customer customer = new Customer();
        customer = customerRepository.save(customer);
        System.out.println(customer.toString());
        assertEquals(customer.getFirstName(), "John");
        assertNull(customer.getPhoneNumber());
    }

    @Test
    public void createSupplier() {
        Supplier supplier = new Supplier();
        supplier = supplierRepository.save(supplier);
        assertEquals(supplier.getFirstName(), "Jane");
        assertNull(supplier.getPhoneNumber());
    }
}

