package com.example;

package com.example.dao;

import com.example.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CustomerDao {
    private final JdbcTemplate jdbcTemplate;

    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (fullName, email, socialSecurityNumber) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, customer.getFullName(), customer.getEmail(), customer.getSocialSecurityNumber());
    }

    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM Customer WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), id);
    }

    public void updateCustomer(Customer customer) {
        String sql = "UPDATE Customer SET fullName = ?, email = ?, socialSecurityNumber = ? WHERE id = ?";
        jdbcTemplate.update(sql, customer.getFullName(), customer.getEmail(), customer.getSocialSecurityNumber(), customer.getId());
    }

    public void deleteCustomer(int id) {
        String sql = "DELETE FROM Customer WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM Customer";
        return jdbcTemplate.query(sql, new CustomerRowMapper());
    }
}
