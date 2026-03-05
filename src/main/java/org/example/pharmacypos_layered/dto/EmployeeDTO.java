package org.example.pharmacypos_layered.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class EmployeeDTO {
    private int employeeId;
    private String userName;
    private String name;
    private String password;
    private String role;
}
