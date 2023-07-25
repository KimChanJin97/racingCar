package view;


// 뷰 : 컨트롤러 명령에 따라 로직을 수행하고 모델에 담아 템플릿에 넘긴다.

import controller.InputController;
import model.Car;

import java.util.*;


public class CarView {

    public void game(InputController inputController) {
        List<Car> carArrList = inputController.getCarArrayList();
        int gameNum = inputController.getGameNum();

        for (int i=0; i<gameNum; i++) {
            for(Car car : carArrList) {
                car.proceed(makeRandomNum());
                System.out.println(car);
            }
            System.out.println();
        }
    }

    public void yieldWinner(InputController inputController) {
        List<Car> carArrList = inputController.getCarArrayList();

        Collections.sort(carArrList, new CarLocationComparator()); // car 객체 location 내림차순 정렬

        int firstWinnerLocation = carArrList.get(0).getLocation().length();
        carArrList.removeIf(car -> car.getLocation().length() != firstWinnerLocation);

        System.out.print("우승자 : ");
        carArrList.forEach(car -> System.out.print(car.getName() + " "));


    }

    private int makeRandomNum() {
        double randomDouble = Math.random() * 10;
        return (int)Math.floor(randomDouble);
    }
}

class CarLocationComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return car2.getLocation().length() - car1.getLocation().length();
    }
}