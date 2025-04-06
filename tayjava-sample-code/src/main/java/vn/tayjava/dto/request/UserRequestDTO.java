package vn.tayjava.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import vn.tayjava.util.PhoneNumber;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserRequestDTO implements Serializable {
    @NotBlank(message = "firstName must be not blank")
    private String firstName;
    @NotNull(message = "lastName must be not null")
    private String lastName;
    @Email(message = "email invalid format")
    private String email;

    //@Pattern(regexp = "^\\d{10}$", message = "phone invalid format")
    @PhoneNumber
    private String phone;

    @NotNull(message = "dateOfBirth must not be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date dateOfBirth;

    @NotEmpty
    private List<String> permission;

    public UserRequestDTO(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }





    public void setFirstName(@NotBlank(message = "firstName must be not blank") String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(@NotNull(message = "lastName must be not null") String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(@Email(message = "email invalid format") String email) {
        this.email = email;
    }

    public @NotNull(message = "dateOfBirth must not be null") Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull(message = "dateOfBirth must not be null") Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhone(@Pattern(regexp = "^\\d{10}$", message = "phone invalid format") String phone) {
        this.phone = phone;
    }

    public @NotEmpty List<String> getPermission() {
        return permission;
    }

    public void setPermission(@NotEmpty List<String> permission) {
        this.permission = permission;
    }
}
