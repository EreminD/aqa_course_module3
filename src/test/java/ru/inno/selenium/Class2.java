package ru.inno.selenium;

public class Class2 {

    public static void main(String[] args) {
        Class0 c0 = new Class0();

        c0.prop1 = new Class1();

        String text = c0.prop1.getText();
        System.out.println(text);
    }

}
