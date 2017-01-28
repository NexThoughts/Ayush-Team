package com.nexthoughts.hackathon.ayush.team.services.validator;

import com.nexthoughts.hackathon.ayush.team.command.UserCommand;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PasswordValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return UserCommand.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        UserCommand userCommand = (UserCommand) target;
        String password = userCommand.getPassword();
        String confPassword = userCommand.getConfirmPassword();

        //Business validation
        if(!password.equals(confPassword)){
            errors.rejectValue("password","customer.password.missMatch");
        }

    }

}
