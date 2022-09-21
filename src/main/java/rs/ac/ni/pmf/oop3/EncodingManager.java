package rs.ac.ni.pmf.oop3;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class EncodingManager
{
	private final Encoder encoder;
	private final List<PasswordValidator> passwordValidators;

	private String encryptedData;

	void showEncryptProcess(final String dataLocation, final String password)
	{
		// TODO: Show the encryption process. Store the encrypted data in encryptedData variable
	}

	void showDecryptProcess(final String password)
	{
		// TODO: Show the process of decrypting the stored encrypted data
	}

	protected abstract byte[] getDataAsBytes(final String dataLocation);
}
