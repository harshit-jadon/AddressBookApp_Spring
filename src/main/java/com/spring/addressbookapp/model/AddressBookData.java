package com.spring.addressbookapp.model;

import com.spring.addressbookapp.dto.AddressBookDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public @Data class AddressBookData {
    private int id;
    private String name;
    private String address;
    public long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> departments;

    public AddressBookData(int id, AddressBookDTO addressBookDTO) {
        this.id = id;
        this.name = addressBookDTO.name;
        this.address = addressBookDTO.address;
        this.salary = addressBookDTO.salary;
        this.gender = addressBookDTO.gender;
        this.startDate = addressBookDTO.startDate;
        this.note = addressBookDTO.note;
        this.profilePic = addressBookDTO.profilePic;
        this.departments = addressBookDTO.departments;
    }
}
