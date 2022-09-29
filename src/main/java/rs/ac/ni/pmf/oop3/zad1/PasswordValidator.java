package rs.ac.ni.pmf.oop3.zad1;

import rs.ac.ni.pmf.oop3.zad1.validator.PasswordNotValidException;

public interface PasswordValidator
{
	void validate(String password) throws PasswordNotValidException;
}
