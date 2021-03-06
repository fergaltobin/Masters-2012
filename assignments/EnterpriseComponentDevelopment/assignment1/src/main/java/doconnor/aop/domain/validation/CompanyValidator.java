package doconnor.aop.domain.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import doconnor.aop.domain.Company;
@Component
public class CompanyValidator implements Validator{

	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "errorCode");
	}

	@SuppressWarnings("unchecked")
	public boolean supports(final Class clazz) {
		return clazz.isAssignableFrom(Company.class);
	}

}
