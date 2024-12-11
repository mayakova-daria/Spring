package com.example;

package com.example;

import com.example.config.AppConfig;
import com.example.dao.CustomerDao;
import com.example.model.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerDao customerDao = context.getBean(CustomerDao.class);

        Customer customer = new Customer(0, "John Doe", "john.doe@example.com", "123-45-6789");
        customerDao.addCustomer(customer);

        Customer fetchedCustomer = customerDao.getCustomerById(1);
        System.out.println(fetchedCustomer.getFullName());

        fetchedCustomer.setFullName("Jane Doe");
        customerDao.updateCustomer(fetchedCustomer);

        customerDao.deleteCustomer(1);

        List<Customer> customers = customerDao.getAllCustomers();
        customers.forEach(c -> System.out.println(c.getFullName()));

        context.close();
    }
}

