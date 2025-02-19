package hello.effective_java.chap01.item02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hello.effective_java.chap01.item02.Busan.Destination.Mountain;
import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("클래스 계층 구조를 활용한 빌더 패턴")
class TripTest {

    @Test
    void testTrip(){

        // Given

        // When
        Busan busan = new Busan.Builder(Mountain)
                .addItem(Trip.Item.Wallet)
                .addItem(Trip.Item.Bag)
                .addItem(Trip.Item.Phone)
                .build();

        Transportation transportation = new Transportation.Builder(Transportation.Vehicle.Car)
                .addItem(Trip.Item.Wallet)
                .addItem(Trip.Item.Hat)
                .addItem(Trip.Item.Phone)
                .build();

        // Then
        assertThat(busan.getDestination()).isEqualTo(Mountain);
        assertThat(transportation.getVehicle()).isEqualTo(Transportation.Vehicle.Car);
    }

}