package com.company;

public class Calc
{
	private long mantissa;
	private long exponent;

	public Calc (long mantissa, long exponent)
	{
		this.mantissa = mantissa;
		this.exponent = exponent;
	}

	public void razn (Calc b)
	{
		String strNull = "0";
		String strInt;
		String strFrac;
		int numbInt = 0;
		int numbFrac = 0;
		int number = 0;
		long resultInteger;
		long resultFraction;
		long resultExp = this.exponent;
		long bmantissa = b.getMantissa();
		if (resultExp < b.getExponent())
		{
			this.mantissa *= (long)(Math.pow(10, b.getExponent() - this.mantissa));
			resultExp += this.exponent - b.getExponent();
		}
		else if (resultExp >= b.getExponent())
		{
			bmantissa *= (long)(Math.pow(10, resultExp - b.getExponent()));
		}
		this.mantissa -= bmantissa;
		if (this.mantissa >= 0)
		{
			resultInteger = (long)(this.mantissa / Math.pow(10, resultExp));
			resultFraction = (long)(this.mantissa % Math.pow(10, resultExp));
		}
		else
		{
			resultInteger = (long)(this.mantissa / Math.pow(10, resultExp));
			resultFraction = (-1) * (long)(this.mantissa % Math.pow(10, resultExp));
		}
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

	public long getExponent()
	{
		return exponent;
	}

	public long getMantissa()
	{
		return mantissa;
	}
}