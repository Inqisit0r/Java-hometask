package com.company;

public class MyFloat {
	private long mantissa;
	private long exponent;

	public MyFloat (long mantissa, long exponent) {
		this.mantissa = mantissa;
		this.exponent = exponent;
	}

	public long getExponent()
	{
		return exponent;
	}

	public long getMantissa()
	{
		return mantissa;
	}

	public void sum (MyFloat d) {
		int numbInt =0;
		int numbFrac = 0;
		int number = 0;
		String strInt;
		String strFrac;
		String strNull = "0";
		long dmantissa = d.getMantissa();
		long resultExp = this.exponent;
		if (resultExp < d.getExponent())
		{
			this.mantissa *= (long)(Math.pow(10, d.getExponent() - this.mantissa));
			resultExp += this.exponent - d.getExponent();
		}
		else if (resultExp >= d.getExponent())
		{
			dmantissa *= (long)(Math.pow(10, resultExp - d.getExponent()));
		}
		this.mantissa += dmantissa;

		long resultInteger = (long)(this.mantissa / Math.pow(10, resultExp));
		long resultFraction = (long)(this.mantissa % Math.pow(10, resultExp));
		long copyInt = resultInteger;
		while (copyInt > 0) {
			copyInt = copyInt / 10;
			numbInt ++;
		}
		long copyFrac = resultFraction;
		while (copyFrac > 0) {
			copyFrac = copyFrac / 10;
			numbFrac ++;
		}
		long a = this.mantissa;
		while (a > 0) {
			a = a / 10;
			number ++;
		}
		if ((numbFrac + numbInt) == number) {
			System.out.println(resultInteger + "," + resultFraction);
		}
		else {
			strInt = Long.toString(resultInteger);
			strFrac = Long.toString(resultFraction);
			do {
				strFrac = strNull.concat(strFrac);
				numbFrac ++;
			} while (numbFrac + numbInt != number);
			System.out.println(strInt + "," + strFrac);
		}
	}
}