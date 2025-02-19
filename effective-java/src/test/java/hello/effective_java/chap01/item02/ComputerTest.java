package hello.effective_java.chap01.item02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hello.effective_java.chap01.item02.Busan.Destination.Mountain;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("빌더 패턴")
class ComputerTest {

    @Test
    void builder(){

        // Given

        // When
        Computer computer = new Computer.Builder("Intel i7")
                .ram("16GB")
                .gpu("RTX 5600")
                .build();

        // Then
        assertThat(computer.getRam()).isEqualTo("16GB");
    }
}