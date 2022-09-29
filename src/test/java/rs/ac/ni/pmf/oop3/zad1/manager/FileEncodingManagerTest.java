package rs.ac.ni.pmf.oop3.zad1.manager;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import rs.ac.ni.pmf.oop3.zad1.*;
import rs.ac.ni.pmf.oop3.zad1.encoder.ByteEncoder;
import rs.ac.ni.pmf.oop3.zad1.manager.FileEncodingManager;
import rs.ac.ni.pmf.oop3.zad1.validator.PasswordComplexityValidator;
import rs.ac.ni.pmf.oop3.zad1.validator.PasswordLengthValidator;

class FileEncodingManagerTest
{
	private final Encoder _encoder = new ByteEncoder();
	private final List<PasswordValidator> _passwordValidators = Arrays.asList(
		new PasswordLengthValidator(4),
		new PasswordComplexityValidator()
	);
	private final EncodingManager _encodingManager = new FileEncodingManager(_encoder, _passwordValidators);

	@Test
	public void shouldLoadDataFromResources()
	{
		_encodingManager.showEncryptProcess("/test_resource.txt", "Abc123");
		_encodingManager.showDecryptProcess("Abc123");
	}

	@Test
	public void shouldLoadDataFromFile()
	{
		_encodingManager.showEncryptProcess("test.txt", "Abc123");
		_encodingManager.showDecryptProcess("Abc123");
	}
}
