package rs.ac.ni.pmf.oop3.zad1;

public interface Encoder
{
	String encrypt(byte[] input, String password);
	byte[] decrypt(String encodedValue, String password);
}
