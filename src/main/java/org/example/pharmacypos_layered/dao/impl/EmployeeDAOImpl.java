package org.example.pharmacypos_layered.dao.impl;

import org.example.pharmacypos_layered.dao.EmployeeDAO;
import org.example.pharmacypos_layered.entity.Employee;
import org.example.pharmacypos_layered.utility.CrudUtil;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public Employee getEmployee(String username) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM employee WHERE user_name = ?";
        ResultSet rs = CrudUtil.execute(query, username);

        Employee employee = null;
        if (rs.next()) {
            employee = new Employee(
                    rs.getInt("employee_id"),
                    rs.getString("user_name"),
                    rs.getString("name"),
                    rs.getString("password_hash"),
                    rs.getString("role")
            );
        }
        return employee;
    }
}
