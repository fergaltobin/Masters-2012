package doconnor.aop.domain.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import doconnor.aop.domain.Division;
@Component
public class DivisionValidator implements Validator {

	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"rejectIfEmptyOrWhitespace");
	}

	@SuppressWarnings("unchecked")
	public boolean supports(final Class clazz) {
		return clazz.isAssignableFrom(Division.class);
	}

}
