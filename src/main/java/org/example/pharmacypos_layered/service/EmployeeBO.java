package org.example.pharmacypos_layered.service;

public interface EmployeeBO extends SuperBO{
    boolean checkValidation(String username, String password);
}
