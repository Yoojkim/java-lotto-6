package lotto;


import lotto.controller.FrontController;

public class Application {
    public static void main(String[] args) {
        FrontController frontController = FrontController.getInstance();
        frontController.gameStart();
    }
}
