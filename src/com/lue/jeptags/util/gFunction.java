package com.lue.jeptags.util;
public class gFunction {
	/**
	 */
	private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5',
		'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	/**
	 */
	private static final char[] DIGITS_UPPER = { '0', '1', '2', '3', '4', '5',
		'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	/**
	 *
	 * @param data
	 *            byte[]
	 * @return char[]
	 */
	public static char[] encodeHex(byte[] data) {
		return encodeHex(data, true);
	}

	public static char[] encodeHex(byte[] data ,int dataLen) {
		return encodeHex(data, dataLen,true);
	}

	/**
	 *
	 * @param data
	 *            byte[]
	 * @param toLowerCase
	 *            <code>true</code>  <code>false</code> 
	 * @return char[]
	 */
	public static char[] encodeHex(byte[] data, boolean toLowerCase) {
		return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
	}

	public static char[] encodeHex(byte[] data,int dataLen, boolean toLowerCase) {
		return encodeHex(data, dataLen,toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
	}

	/**
	 *
	 * @param data
	 *            byte[]
	 * @param toDigits
	 *            char[]
	 * @return char[]
	 */
	protected static char[] encodeHex(byte[] data, char[] toDigits) {
		int len = data.length;
		char[] out = new char[len << 1];
		// two characters form the hex value.
		for (int i = 0, j = 0; i < len; i++) {
			out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
			out[j++] = toDigits[0x0F & data[i]];
		}
		return out;
	}

	protected static char[] encodeHex(byte[] data, int dataLen,char[] toDigits) {
		int len = dataLen;//dataLen;//data.length;
		char[] out = new char[len << 1];
		for (int i = 0, j = 0; i < len; i++) {
			out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
			out[j++] = toDigits[0x0F & data[i]];
		}
		return out;
	}

	/**
	 *
	 * @param data
	 *            byte[]
	 * @return String
	 */
	public static String encodeHexStr(byte[] data) {
		return encodeHexStr(data, false);
	}

	public static String encodeHexStr(byte[] data,int dataLen) {
		return encodeHexStr(data,dataLen,false);
	}

	/**
	 *
	 * @param data
	 *            byte[]
	 * @param toLowerCase
	 *            <code>true</code> <code>false</code> 
	 * @return String
	 */
	public static String encodeHexStr(byte[] data, boolean toLowerCase) {
		return encodeHexStr(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
	}

	public static String encodeHexStr(byte[] data,int dataLen,boolean toLowerCase) {
		return encodeHexStr(data,dataLen, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
	}

	/**
	 *
	 * @param data
	 *            byte[]
	 * @param toDigits
	 *            char[]
	 * @return String
	 */
	protected static String encodeHexStr(byte[] data, char[] toDigits) {
		return new String(encodeHex(data, toDigits));
	}

	protected static String encodeHexStr(byte[] data,int dataLen,char[] toDigits) {
		return new String(encodeHex(data,dataLen,toDigits));
	}
	/**
	 *
	 * @param data
	 *           char[]
	 * @return byte[]
	 * @throws RuntimeException
	 */
	public static byte[] decodeHex(char[] data) {
		int len = data.length;
		if ((len & 0x01) != 0) {
			throw new RuntimeException("Odd number of characters.");
		}
		byte[] out = new byte[len >> 1];
		// two characters form the hex value.
		for (int i = 0, j = 0; j < len; i++) {
			int f = toDigit(data[j], j) << 4;
			j++;
			f = f | toDigit(data[j], j);
			j++;
			out[i] = (byte) (f & 0xFF);
		}
		return out;
	}

	public static byte[] decodeHex(char[] data,int dataLen) {
		int len = dataLen;
		if ((len & 0x01) != 0) {
			throw new RuntimeException("Odd number of characters.");
		}
		byte[] out = new byte[len >> 1];
		// two characters form the hex value.
		for (int i = 0, j = 0; j < len; i++) {
			int f = toDigit(data[j], j) << 4;
			j++;
			f = f | toDigit(data[j], j);
			j++;
			out[i] = (byte) (f & 0xFF);
		}
		return out;
	}


	public static byte[] decodeHex(String sData) {
		char[]data = sData.toCharArray();
		int len = data.length;
		if ((len & 0x01) != 0) {
			throw new RuntimeException("Odd number of characters.");
		}
		byte[] out = new byte[len >> 1];
		// two characters form the hex value.
		for (int i = 0, j = 0; j < len; i++) {
			int f = toDigit(data[j], j) << 4;
			j++;
			f = f | toDigit(data[j], j);
			j++;
			out[i] = (byte) (f & 0xFF);
		}
		return out;
	}

	/**
	 *
	 * @param ch
	 *           char
	 * @param index
	 *            
	 * @return һ
	 * @throws RuntimeException
	 */
	protected static int toDigit(char ch, int index) {
		int digit = Character.digit(ch, 16);
		if (digit == -1) {
			throw new RuntimeException("Illegal hexadecimal character " + ch
					+ " at index " + index);
		}
		return digit;
	}
}
