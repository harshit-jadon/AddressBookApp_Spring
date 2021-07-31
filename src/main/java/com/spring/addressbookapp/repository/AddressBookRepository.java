package com.spring.addressbookapp.repository;

import com.spring.addressbookapp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBookData,Integer> {

    @Query(value="select * from address_book, ab_department where ab_id = id and department=:department",nativeQuery=true)
    List<AddressBookData> findAddressBookDataByDepartments(String department);
}
