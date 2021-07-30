package com.spring.addressbookapp.service;

import com.spring.addressbookapp.dto.AddressBookDTO;
import com.spring.addressbookapp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAddressBookHome();

    AddressBookData getAddressBookById(int id);

    AddressBookData createAddressBook(AddressBookDTO addressBookDTO);

    AddressBookData updateAddressBook(int id, AddressBookDTO addressBookDTO);

    void deleteAddressBook(int id);

}
