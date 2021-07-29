package com.spring.addressbookapp.controller;

import com.spring.addressbookapp.dto.AddressBookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbookcontroller")
public class AddressBookController {

    @GetMapping(value={(""),("/"),("/home")})
    public ResponseEntity<String> getAddressBookHome(){
        return new ResponseEntity<String>("Get Address Book Home Successful", HttpStatus.OK);
    }

    @GetMapping("/home/{id}")
    public ResponseEntity<String> getAddressBookById(@PathVariable int id){
        return new ResponseEntity<String>("Get Address Book by Id: ",HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAddressBook(@RequestBody AddressBookDTO addressBookDTO){
        return new ResponseEntity<String>("Create Address Book: "+ addressBookDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAddressBook(@PathVariable int id,@RequestBody AddressBookDTO addressBookDTO){
        return new ResponseEntity<String>("Update Address Book: "+ addressBookDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressBook(@PathVariable("id") int id){
        return new ResponseEntity<String>("Delete Address Book: "+ id,HttpStatus.OK);
    }
}
