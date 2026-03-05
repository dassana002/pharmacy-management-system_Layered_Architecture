package org.example.pharmacypos_layered.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class Employee {
    private int employeeId;
    private String userName;
    private String name;
    private String password;
    private String role;
}
