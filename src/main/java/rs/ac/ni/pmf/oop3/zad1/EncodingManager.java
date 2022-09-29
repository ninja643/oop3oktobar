package rs.ac.ni.pmf.oop3.zad1;

import java.nio.charset.StandardCharsets;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import rs.ac.ni.pmf.oop3.zad1.manager.EncodingManagerException;
import rs.ac.ni.pmf.oop3.zad1.validator.PasswordNotValidException;

@Slf4j
@RequiredArgsConstructor
public abstract class EncodingManager
{
	private final Encoder _encoder;
	private final List<PasswordValidator> _passwordValidators;

	private String _encryptedData;

	public void showEncryptProcess(final String dataLocation, final String password)
	{
		if (passwordInvalid(password))
		{
			return;
		}

		log.info("Getting the data");
		final byte[] bytes;
		try
		{
			bytes = getDataAsBytes(dataLocation);
		}
		catch (final EncodingManagerException e)
		{
			log.error("Failed to retrieve the data");
			return;
		}

		log.info("Encrypting the data");
		_encryptedData = _encoder.encrypt(bytes, password);
		log.info("Encrypted data: {}", _encryptedData);

		log.info("Encryption done!");
	}

	public void showDecryptProcess(final String password)
	{
		if (passwordInvalid(password))
		{
			return;
		}

		log.info("Decrypting the data");

		final String value = new String(_encoder.decrypt(_encryptedData, password), StandardCharsets.UTF_8);

		log.info("Decrypted value: {}", value);
	}

	protected abstract byte[] getDataAsBytes(final String dataLocation) throws EncodingManagerException;

	private boolean passwordInvalid(final String password)
	{
		log.info("Validating password");

		for (final PasswordValidator passwordValidator : _passwordValidators)
		{
			try
			{
				passwordValidator.validate(password);
			}
			catch (final PasswordNotValidException e)
			{
				log.error("Password validation failed!", e);
				return true;
			}
		}
		return false;
	}
}
