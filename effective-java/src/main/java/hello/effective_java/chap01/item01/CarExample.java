package hello.effective_java.chap01.item01;

import java.awt.*;


class Hyundai implements Car{
    @Override
    public void brand() {
        System.out.println("sonata");
    }
}

class Kia implements Car{
    @Override
    public void brand() {
        System.out.println("sportage");
    }
}

class CarFactory{

    public static Car createCar(String brand){
        if (brand.equalsIgnoreCase("Hyundai")) {
            return new Hyundai(); // 인터페이스의 하위 타입 반환
        } else if (brand.equalsIgnoreCase("Kia")) {
            return new Kia(); // 인터페이스의 하위 타입 반환
        }else {
            throw new IllegalArgumentException("Unknown");
        }
    }

}

public class CarExample {
    public static void main(String[] args) {
        Car car1 = CarFactory.createCar("Hyundai");
        Car car2 = CarFactory.createCar("Kia");

        car1.brand();
        car2.brand();

        System.out.println(car1.getClass().getSimpleName()); // "Hyundai"
        System.out.println(car2.getClass().getSimpleName()); // "Kia"
    }
}
