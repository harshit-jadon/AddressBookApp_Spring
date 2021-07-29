package com.spring.addressbookapp.model;

import com.spring.addressbookapp.dto.AddressBookDTO;

public class AddressBookData {
    private int id;
    private String name;
    private String address;


    public AddressBookData() { }

    public AddressBookData(int id, AddressBookDTO addressBookDTO) {
        this.id = id;
        this.name = addressBookDTO.getName();
        this.address = addressBookDTO.getAddress();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
