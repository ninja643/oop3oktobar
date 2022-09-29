package rs.ac.ni.pmf.oop3.zad1.encoder;

import java.nio.charset.StandardCharsets;
import rs.ac.ni.pmf.oop3.zad1.Encoder;

public class ByteEncoder implements Encoder
{
	@Override
	public String encrypt(final byte[] input, final String password)
	{
		final byte[] outputBytes = new byte[input.length];

		for (int i = 0; i < input.length; i++)
		{
			outputBytes[i] = (byte)(127 - input[i]);
		}

		return new String(outputBytes, StandardCharsets.UTF_8);
	}

	@Override
	public byte[] decrypt(final String encodedValue, final String password)
	{
		final byte[] encodedBytes = encodedValue.getBytes(StandardCharsets.UTF_8);

		final byte[] outputBytes = new byte[encodedBytes.length];

		for (int i = 0; i < encodedBytes.length; i++)
		{
			outputBytes[i] = (byte)(127 - encodedBytes[i]);
		}

		return outputBytes;
	}
}
