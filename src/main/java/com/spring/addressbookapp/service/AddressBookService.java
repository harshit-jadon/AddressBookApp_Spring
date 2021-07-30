package com.spring.addressbookapp.service;

import com.spring.addressbookapp.dto.AddressBookDTO;
import com.spring.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Override
    public List<AddressBookData> getAddressBookHome() {
        List<AddressBookData> addressBookDataList = new ArrayList<>();
        addressBookDataList.add(new AddressBookData(1,new AddressBookDTO("Harshit Jadon","Greater Noida")));
        return addressBookDataList;
    }

    @Override
    public AddressBookData getAddressBookById(int id) {
        return new AddressBookData(id,new AddressBookDTO("Ankur Thakur","Noida"));
    }

    @Override
    public AddressBookData createAddressBook(AddressBookDTO addressBookDTO) {
        return new AddressBookData(3,addressBookDTO);
    }

    @Override
    public AddressBookData updateAddressBook(int id, AddressBookDTO addressBookDTO) {
        return new AddressBookData(id,addressBookDTO);
    }

    @Override
    public void deleteAddressBook(int id) {

    }
}
