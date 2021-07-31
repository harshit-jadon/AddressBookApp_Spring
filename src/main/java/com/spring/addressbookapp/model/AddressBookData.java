package com.spring.addressbookapp.model;

import com.spring.addressbookapp.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="address_book")
public @Data class AddressBookData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ab_id")
    private int id;

    @Column(name="name")
    private String name;

    private String address;
    public long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;

    @ElementCollection
    @CollectionTable(name="ab_department",joinColumns = @JoinColumn(name="id"))
    @Column(name="department")
    public List<String> departments;

    public AddressBookData() {}

    public AddressBookData(AddressBookDTO addressBookDTO) {
        this.updateAddressBookData(addressBookDTO);

    }
  public void updateAddressBookData(AddressBookDTO addressBookDTO){
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
