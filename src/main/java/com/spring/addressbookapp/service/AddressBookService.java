package com.spring.addressbookapp.service;

import com.spring.addressbookapp.dto.AddressBookDTO;
import com.spring.addressbookapp.exceptions.AddressBookException;
import com.spring.addressbookapp.model.AddressBookData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

    List<AddressBookData> addressBookDataList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBookHome() {
        return addressBookDataList;
    }

    @Override
    public AddressBookData getAddressBookById(int id) {
        return addressBookDataList.stream()
                .filter(employeePayrollData -> employeePayrollData.getId() == id)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Employee Not Found"));
    }

    @Override
    public AddressBookData createAddressBook(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDataList.size()+1,addressBookDTO);
        addressBookDataList.add(addressBookData);
        return addressBookData;
    }

    @Override
    public AddressBookData updateAddressBook(int id, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookById(id);
        addressBookData.setName(addressBookDTO.name);
        addressBookData.setAddress(addressBookDTO.address);
        addressBookDataList.set(id-1,addressBookData);
        return addressBookData;
    }

    @Override
    public void deleteAddressBook(int id) {
    addressBookDataList.remove(id-1);
    }
}
