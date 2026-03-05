package org.example.pharmacypos_layered.dao;

import org.example.pharmacypos_layered.entity.Employee;

import java.sql.SQLException;

public interface EmployeeDAO extends SuperDAO{
    Employee getEmployee(String username) throws SQLException, ClassNotFoundException;
}
