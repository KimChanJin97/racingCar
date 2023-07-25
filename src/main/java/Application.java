import controller.InputController;
import view.CarView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        InputController inputController = new InputController();
        inputController.input();

        CarView carView = new CarView();
        carView.game(inputController);
        carView.yieldWinner(inputController);
    }
}
