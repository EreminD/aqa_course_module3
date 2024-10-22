package ru.inno.selenium;

public class MySuperTool {
    private String message;

    private MySuperTool(String message) {
        this.message = message;
    }

    public static MySuperTool choochoo(){
        return new MySuperTool("Choo-choo!");
    }

    public static MySuperTool piupiu(){
        return new MySuperTool("Piu-piu!");
    }

    public void printMessage(){
        System.out.println(message);
    }
}
