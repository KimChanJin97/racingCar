package model;

// 모델 : 데이터를 저장한다.
public class Car {

    private String name = "";
    private String location = "";

    public void proceed(int randomNum) {
        if (4 <= randomNum) {
            move();
        } else {
            stop();
        }
    }
    public void move() {
        location += "-";
    }
    public void stop() {
        return;
    }

    public Car(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name + " : " + this.location;
    }
}
