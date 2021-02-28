package ru.itis.javalab.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NamesValidator implements ConstraintValidator<ValidNames, Object> {

    private String namePropertyName;
    private String surnamePropertyName;

    @Override
    public void initialize(ValidNames constraintAnnotation) {
        this.namePropertyName = constraintAnnotation.name(); // название поля для name -> firstName
        this.surnamePropertyName = constraintAnnotation.surname(); // название поля для surname -> lastName

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object name = new BeanWrapperImpl(o).getPropertyValue(namePropertyName); //получили конкретные значения
        Object surname = new BeanWrapperImpl(o).getPropertyValue(surnamePropertyName);
        return name != null && !name.equals(surname);
    }
}

