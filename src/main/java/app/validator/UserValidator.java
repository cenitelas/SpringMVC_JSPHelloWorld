package app.validator;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import app.entities.UserEntity;

@Component
@ComponentScan({ "app" })
@PropertySource(value = { "classpath:vEror.properties" })
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserEntity.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "label.validate.Empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "label.validate.Empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "label.validate.Empty");
    }

}