package org.example.pharmacypos_layered.service;

import org.example.pharmacypos_layered.service.impl.EmployeeBOImpl;

// Using Factory Design Pattern
public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getInstance() {
        if (boFactory==null) {
            return new BOFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BOType boType) {
        switch (boType) {
            case EMPLOYEE -> {
                return new EmployeeBOImpl();
            }
            default -> {
                return null;
            }
        }
    }
}
