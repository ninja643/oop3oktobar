package rs.ac.ni.pmf.oop3.zad1.validator;

import lombok.RequiredArgsConstructor;
import rs.ac.ni.pmf.oop3.zad1.PasswordValidator;

@RequiredArgsConstructor
public class PasswordLengthValidator implements PasswordValidator
{
	private final int _minPasswordLength;

	@Override
	public void validate(final String password) throws PasswordNotValidException
	{
		if (password == null)
		{
			throw new NullPasswordException();
		}

		if (password.length() < _minPasswordLength)
		{
			throw new PasswordTooShortException();
		}
	}
}
