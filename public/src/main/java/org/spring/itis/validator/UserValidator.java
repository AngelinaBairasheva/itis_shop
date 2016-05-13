package org.spring.itis.validator;


import org.itis.hib.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "field.required", "Required field");

        if (!errors.hasFieldErrors("age")) {
            if (user.getAge() <= 0) {
                errors.rejectValue("age", "not_negitive_and_zero", "Wrong age");
            }
        }
    }
}

