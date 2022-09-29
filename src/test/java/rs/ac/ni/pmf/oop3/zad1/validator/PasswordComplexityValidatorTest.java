package rs.ac.ni.pmf.oop3.zad1.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import rs.ac.ni.pmf.oop3.zad1.PasswordValidator;
import rs.ac.ni.pmf.oop3.zad1.validator.*;

class PasswordComplexityValidatorTest
{
	private final PasswordValidator _passwordValidator = new PasswordComplexityValidator();

	@Test
	public void shouldAcceptPassword() throws PasswordNotValidException
	{
		_passwordValidator.validate("Abc123");
	}

	@Test
	public void shouldNotAccepPasswords()
	{
		assertThatThrownBy(() -> _passwordValidator.validate(null)).isInstanceOf(NullPasswordException.class);
		assertThatThrownBy(() -> _passwordValidator.validate("ABC")).isInstanceOf(PasswordTooSimpleException.class);
		assertThatThrownBy(() -> _passwordValidator.validate("AbC")).isInstanceOf(PasswordTooSimpleException.class);
		assertThatThrownBy(() -> _passwordValidator.validate("AB1")).isInstanceOf(PasswordTooSimpleException.class);
		assertThatThrownBy(() -> _passwordValidator.validate("ab1")).isInstanceOf(PasswordTooSimpleException.class);
		assertThatThrownBy(() -> _passwordValidator.validate("123")).isInstanceOf(PasswordTooSimpleException.class);
		assertThatThrownBy(() -> _passwordValidator.validate("abc")).isInstanceOf(PasswordTooSimpleException.class);
	}
}
