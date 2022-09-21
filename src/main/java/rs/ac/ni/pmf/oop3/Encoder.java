package rs.ac.ni.pmf.oop3;

public interface Encoder
{
	String encrypt(byte[] input, String password);
	byte[] decrypt(String encodedValue, String password);
}
