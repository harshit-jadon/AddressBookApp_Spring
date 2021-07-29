package com.spring.addressbookapp.dto;

public class AddressBookDTO {
    private String name;
    private long salary;

    public AddressBookDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
