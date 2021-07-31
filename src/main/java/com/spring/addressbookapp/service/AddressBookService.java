package com.spring.addressbookapp.service;

import com.spring.addressbookapp.dto.AddressBookDTO;
import com.spring.addressbookapp.exceptions.AddressBookException;
import com.spring.addressbookapp.model.AddressBookData;
import com.spring.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    public List<AddressBookData> addressBookDataList = new ArrayList<>();

    @Override
    public List<AddressBookData> getAddressBookHome() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBookData getAddressBookById(int id) {
        return addressBookRepository
                .findById(id)
                .orElseThrow(() -> new AddressBookException("Employee Not Found" + id + "does not exist"));
    }

    @Override
    public AddressBookData createAddressBook(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        log.debug("Address Book Data: "+ addressBookData.toString());
        addressBookDataList.add(addressBookData);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public AddressBookData updateAddressBook(int id, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookById(id);
        addressBookData.updateAddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public void deleteAddressBook(int id) {
        AddressBookData addressBookData =this.getAddressBookById(id);
        addressBookRepository.delete(addressBookData);
    }
}
