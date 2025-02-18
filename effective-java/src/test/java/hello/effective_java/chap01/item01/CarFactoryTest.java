package hello.effective_java.chap01.item01;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("반환 타입을 하위 타입(서브클래스) 인스턴스로 지정할 수도 있다.")
class CarFactoryTest {

    @Test
    void testCreateCar(){

        // Given
        String s1 = "Hyundai";
        String s2 = "Kia";

        // When
        Car car1 = CarFactory.createCar(s1);
        Car car2 = CarFactory.createCar(s2);

        // Then
        assertThat(car1.getClass().getSimpleName()).isEqualTo("Hyundai");
        assertThat(car2.getClass().getSimpleName()).isEqualTo("Kia");


    }



}