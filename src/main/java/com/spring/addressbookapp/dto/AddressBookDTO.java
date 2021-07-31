package com.spring.addressbookapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public @ToString class AddressBookDTO {

    @NotEmpty(message="Name cannot be Empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Name is Invalid")
    public String name;

    @NotEmpty(message="Address cannot be Empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Address is Invalid")
    public String address;

    @Min(value=1000 ,message="Min Wage should be more than 1000")
    public long salary;

    @Pattern(regexp = "Male|Female",message = "Gender need to be Male or Female")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "start date should not be Empty")
    @PastOrPresent(message = "startDate should be past or today's date")
    public LocalDate startDate;

    @NotBlank(message="Note cannot be empty")
    public String note;

    @NotNull(message="Profile Pic cannot be Empty")
    public String profilePic;

    @NotNull(message="department should not be Empty")
    public List<String> departments;
}
