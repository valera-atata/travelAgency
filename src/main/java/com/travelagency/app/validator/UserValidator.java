package com.travelagency.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.travelagency.app.entity.AgentEntity;
import com.travelagency.app.service.abstracts.UserService;


@Component
public class UserValidator implements Validator {

	@Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return AgentEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	AgentEntity user = (AgentEntity) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Required");
        if (user.getLogin().length() < 8 || user.getLogin().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }

        if (userService.findByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }
    }
}