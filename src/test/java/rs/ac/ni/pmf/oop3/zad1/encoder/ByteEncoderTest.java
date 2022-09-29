package rs.ac.ni.pmf.oop3.zad1.encoder;

import static org.assertj.core.api.Assertions.assertThat;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import rs.ac.ni.pmf.oop3.zad1.Encoder;
import rs.ac.ni.pmf.oop3.zad1.encoder.ByteEncoder;

class ByteEncoderTest
{
	private final String _text = "ABC";

	private final byte[] _encryptedBytes = { (byte)(127 - 'A'), (byte)(127 - 'B'), (byte)(127 - 'C') };
	final String _encryptedString = new String(_encryptedBytes, StandardCharsets.US_ASCII);

	private final Encoder _encoder = new ByteEncoder();

	@Test
	public void shouldEncrypt()
	{
		assertThat(_encoder.encrypt(_text.getBytes(StandardCharsets.US_ASCII), "pass"))
			.isEqualTo(_encryptedString);
	}

	@Test
	public void shouldDecrypt()
	{
		assertThat(_encoder.decrypt(_encryptedString, "pass")).isEqualTo(_text.getBytes(StandardCharsets.US_ASCII));
	}
}
