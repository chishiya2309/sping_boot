package vn.tayjava.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class PhoneValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String phoneNo, ConstraintValidatorContext cxt) {
        if(phoneNo == null)
        {
            return false;
        }
        //validate phone numbers of format
        if(phoneNo.matches("\\d{10}")) return true;
        //validate phone number with -, . or spaces: 090-234-4567
        else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
        //validate phone number with extension length from 3 to 5
        else //return false if nothing matches the input
            if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
            else return phoneNo.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    @Override
    public void initialize(PhoneNumber phoneNumberNo) {

    }
}
