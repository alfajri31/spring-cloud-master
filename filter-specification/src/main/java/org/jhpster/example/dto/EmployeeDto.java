package org.jhpster.example.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class EmployeeDto {
    public String firstName;
    public String lastName;
    public int age;
    public Address address;
    public ArrayList<PhoneNumber> phoneNumbers;
}
