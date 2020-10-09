package com.company;

public class Main {

	public static void main(String[] args) {
		List a = new List();
		a.add(12);
		a.add(36);
		a.add(14);
		a.add(35);
		a.add(124);
		a.add(35);
		a.add(6);
		a.add(17);
		a.add(2);
		System.out.println(a.toString());
		a.swap(0, 1);
		System.out.println(a.toString());
		a.sort();
		System.out.println(a.toString());
	}
}