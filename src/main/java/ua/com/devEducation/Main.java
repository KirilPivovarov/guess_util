package ua.com.devEducation;

import ua.com.devEducation.controllers.Controller;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }
}
