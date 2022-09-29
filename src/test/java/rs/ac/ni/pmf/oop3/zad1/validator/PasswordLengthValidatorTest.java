package rs.ac.ni.pmf.oop3.zad1.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import rs.ac.ni.pmf.oop3.zad1.PasswordValidator;
import rs.ac.ni.pmf.oop3.zad1.validator.*;

class PasswordLengthValidatorTest
{
	@Test
	public void shouldTestPasswordLength() throws PasswordNotValidException
	{
		final PasswordValidator passwordValidator = new PasswordLengthValidator(4);

		assertThatThrownBy(() -> passwordValidator.validate(null)).isInstanceOf(NullPasswordException.class);
		assertThatThrownBy(() -> passwordValidator.validate("abc")).isInstanceOf(PasswordTooShortException.class);

		passwordValidator.validate("ab124");
	}
}
