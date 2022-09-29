package rs.ac.ni.pmf.oop3.zad1.validator;

import rs.ac.ni.pmf.oop3.zad1.PasswordValidator;

public class PasswordComplexityValidator implements PasswordValidator
{
	@Override
	public void validate(final String password) throws PasswordNotValidException
	{
		boolean hasLowercase = false;
		boolean hasUppercase = false;
		boolean hasDigit = false;

		if (password == null)
		{
			throw new NullPasswordException();
		}

		for (char c : password.toCharArray())
		{
			if (Character.isDigit(c))
			{
				hasDigit = true;
			}

			if (Character.isLowerCase(c))
			{
				hasLowercase = true;
			}

			if (Character.isUpperCase(c))
			{
				hasUppercase = true;
			}
		}

		if (!hasDigit || !hasLowercase || !hasUppercase)
		{
			throw new PasswordTooSimpleException();
		}
	}
}
