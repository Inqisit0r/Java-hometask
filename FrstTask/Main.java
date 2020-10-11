package com.company;

public class Main
{
    public static void main(String[] args)
    {
        Calc a = new Calc (50005L, 3);
        Calc b = new Calc (30000L, 3);
        a.razn (b);

        MyFloat c = new MyFloat(567000675L, 4);
        MyFloat d = new MyFloat(30005L, 3);
        c.sum (d);
    }
}