package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import exception.InputException;
import model.Car;

// 컨트롤러 : 사용자의 요청을 처리한다.
public class InputController {

    private final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_GAME_NUM_MESSAGE = "시도활 회수는 몇 회인가요?";
    private final String ALPHABET_REGEX = "^[a-zA-Z]*$";
    private final String NUMERIC_REGEX = "^[0-9]*$";

    private List<Car> carArrayList = new ArrayList<>();
    private Integer gameNum = 0;


    public List<Car> getCarArrayList() {
        return this.carArrayList;
    }

    public Integer getGameNum() {
        return this.gameNum;
    }

    Scanner sc = new Scanner(System.in);

    public void input() {
        String inputCarNames = inputCarNames();
        validateCarNames(inputCarNames);

        String inputGameNum = inputGameNum();
        validateGameNum(inputGameNum);
    }

    String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return sc.nextLine();
    }

    String inputGameNum() {
        System.out.println(INPUT_GAME_NUM_MESSAGE);
        return sc.nextLine();
    }

    void validateCarNames(String inputCarNames) {
        String[] carNameArr = inputCarNames.split(",");
        for(String carName : carNameArr) {
            if (carName.trim().matches(ALPHABET_REGEX)) {
                carArrayList.add(new Car(carName));
            } else {
                throw new InputException("자동차 이름은 영어로 입력해야 합니다.");
            }
        }
    }

    void validateGameNum(String gameNum) {
        if (gameNum.matches(NUMERIC_REGEX)) {
            this.gameNum = Integer.valueOf(gameNum);
        } else {
            throw new InputException("게임 횟수는 양의 정수의 값으로 입력해야 합니다.");
        }
    }
}
