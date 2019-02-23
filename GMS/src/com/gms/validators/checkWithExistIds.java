package com.gms.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.Payload;

import org.springframework.beans.factory.annotation.Autowired;

import com.gms.user.dao.UserDao;

@Documented
@Constraint(validatedBy = ExistsLoginId.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface checkWithExistIds {
	String message() default "User Id Already Exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

class ExistsLoginId implements ConstraintValidator<checkWithExistIds, String> {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void initialize(checkWithExistIds obj) {
		// TODO Auto-generated method stub
		
	}
	public boolean isValid(String loginId, javax.validation.ConstraintValidatorContext arg1) {
		
		if(loginId != null && !"".equalsIgnoreCase(loginId))
			return userDao.checkForLoginId(loginId);
		return false;
	};
}