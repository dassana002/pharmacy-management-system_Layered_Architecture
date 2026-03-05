package org.example.pharmacypos_layered.service.impl;

import org.example.pharmacypos_layered.dao.DAOFactory;
import org.example.pharmacypos_layered.dao.DAOType;
import org.example.pharmacypos_layered.dao.EmployeeDAO;
import org.example.pharmacypos_layered.entity.Employee;
import org.example.pharmacypos_layered.service.EmployeeBO;
import org.mindrot.jbcrypt.BCrypt;

public class EmployeeBOImpl implements EmployeeBO {

    // Property Injection
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOType.EMPLOYEE);

    @Override
    public boolean checkValidation(String username, String password) {
        try {
            // Get Employee by username
            Employee employee = employeeDAO.getEmployee(username);

            if (employee!=null) {
                // Check password for user
                return BCrypt.checkpw(password, employee.getPassword());
            }
            return false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
