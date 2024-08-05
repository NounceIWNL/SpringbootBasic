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
    private EmployeeRepository employeeRepository;


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

    @Test
    public void createEmployee(){
        Employee employee = new Employee();
        System.out.println(employee);
        employee.setEmail("d@gmail.com");
        employee = employeeRepository.save(employee);
        System.out.println(employee);

        assertEquals(employee.getFirstName(),"David");
        assertNull(employee.getPhoneNumber());
    }
}

