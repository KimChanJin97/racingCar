package view;


// 뷰 : 컨트롤러 명령에 따라 로직을 수행하고 모델에 담아 템플릿에 넘긴다.

import controller.InputController;
import model.Car;

import java.util.List;

public class CarView {

    InputController inputController = new InputController();

    public void game() {
        int gameNum = inputController.getGameNum();
        List<Car> carArrList = inputController.getCarArrayList();

        for (int i=0; i<gameNum; i++) {
            for(Car car : carArrList) {
                car.proceed(makeRandomNum());
            }
        }

        for(Car car : carArrList) {
            System.out.println(car);
        }
    }

    private int makeRandomNum() {
        double randomDouble = Math.random() * 10;
        return (int)Math.floor(randomDouble);
    }
}
