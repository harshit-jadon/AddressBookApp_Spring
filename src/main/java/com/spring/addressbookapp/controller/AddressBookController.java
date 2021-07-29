package com.spring.addressbookapp.controller;

import com.spring.addressbookapp.dto.AddressBookDTO;
import com.spring.addressbookapp.dto.ResponseDTO;
import com.spring.addressbookapp.model.AddressBookData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbookcontroller")
public class AddressBookController {

    @GetMapping(value={(""),("/"),("/home")})
    public ResponseEntity<ResponseDTO> getAddressBookHome(){
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(1,new AddressBookDTO("Harshit Jadon","Noida"));
        ResponseDTO responseDTO = new ResponseDTO("Get Address Book Home Successful ",addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/home/{id}")
    public ResponseEntity<ResponseDTO> getAddressBookById(@PathVariable int id){
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(id,new AddressBookDTO("Tanisha Jadon","Noida"));
        ResponseDTO responseDTO = new ResponseDTO("Get Address Book by Id: ",addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddressBook(@RequestBody AddressBookDTO addressBookDTO){
            AddressBookData addressBookData = null;
            addressBookData = new AddressBookData(3,addressBookDTO);
            ResponseDTO responseDTO = new ResponseDTO("Create Address Book: ",addressBookData);
            return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
        }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBook(@PathVariable int id,@RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(id,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Address Book: ",addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBook(@PathVariable("id") int id){
        ResponseDTO responseDTO = new ResponseDTO("Delete Address Book: ",id);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
