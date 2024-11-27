package app;

import app.controller.Controller;

public class App {
    Controller controller = new Controller();
    public static void main(String[] args) {
        App app = new App();
        app.controller.iniciarApp();
    }
}
