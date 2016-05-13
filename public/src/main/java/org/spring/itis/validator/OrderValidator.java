package org.spring.itis.validator;


import org.itis.hib.domain.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class OrderValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return Order.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        Order order = (Order) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required", "Required field");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "field.required", "Required field");


        if (!errors.hasFieldErrors("price")) {
            if (order.getPrice() <= 0) {
                errors.rejectValue("price", "not_negitive_and_zero", "Wrong price");
            }
        }
    }
}


