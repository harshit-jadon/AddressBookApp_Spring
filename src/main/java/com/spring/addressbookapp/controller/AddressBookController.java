package com.spring.addressbookapp.controller;

import com.spring.addressbookapp.dto.AddressBookDTO;
import com.spring.addressbookapp.dto.ResponseDTO;
import com.spring.addressbookapp.model.AddressBookData;
import com.spring.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbookcontroller")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping(value={(""),("/"),("/home")})
    public ResponseEntity<ResponseDTO> getAddressBookHome(){
        List<AddressBookData> addressBookDataList = addressBookService.getAddressBookHome();
        ResponseDTO responseDTO = new ResponseDTO("Get Address Book Home Successful ",addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/home/{id}")
    public ResponseEntity<ResponseDTO> getAddressBookById(@PathVariable int id){
       AddressBookData addressBookData = addressBookService.getAddressBookById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get Address Book by Id: ",addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddressBook(@RequestBody AddressBookDTO addressBookDTO){
            AddressBookData addressBookData = addressBookService.createAddressBook(addressBookDTO);
            ResponseDTO responseDTO = new ResponseDTO("Create Address Book: ",addressBookData);
            return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
        }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBook(@PathVariable int id,@RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = addressBookService.updateAddressBook(id,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Address Book: ",addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBook(@PathVariable("id") int id){
        addressBookService.deleteAddressBook(id);
        ResponseDTO responseDTO = new ResponseDTO("Delete Address Book: ",id);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
