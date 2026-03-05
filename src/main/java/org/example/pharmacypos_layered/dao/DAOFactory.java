package org.example.pharmacypos_layered.dao;

import org.example.pharmacypos_layered.dao.impl.EmployeeDAOImpl;

// Using Factory Design Pattern
public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        if (daoFactory==null) {
            return new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOType type) {
        switch (type) {
            case EMPLOYEE -> {
                return new EmployeeDAOImpl();
            }
            default -> {
                return null;
            }
        }
    }
}
