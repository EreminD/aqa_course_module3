package ru.inno.selenium.actions;

public class ShortCondition {

    public static void main(String[] args) {

        boolean isActive = false;

        int i = 0;
        if (isActive){
            i = 1;
        } else {
            i = 2;
        }

        System.out.println("i = " + i);

        int j = isActive ? 1 : 2;

        System.out.println("j = " + j);

    }
}
