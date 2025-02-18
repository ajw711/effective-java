package hello.effective_java.chap01.item01;

import hello.effective_java.chap01.item01.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("이름을 가질 수 있다.")
class MemberTest {

    @Test
    void testMemberOf(){
        // Given (입력값 준비)
        String name = "Tom";
        int age = 18;

        // When (메서드 실행)
        Member member = Member.of(name, age);

        // Then (결과 검증)
        assertThat(member.getName()).isEqualTo(name);
        assertThat(member.getAge()).isEqualTo(age);
    }

    @Test
    void testMemberOfName() {
        // Given
        String name = "John";

        // When
        Member member = Member.ofName(name);

        // Then
        assertThat(member.getName()).isEqualTo(name);
        assertThat(member.getAge()).isEqualTo(0); // 기본값 0
    }

    @Test
    void testMemberOfAge() {
        // Given
        int age = 20;

        // When
        Member member = Member.ofAge(age);

        // Then
        assertThat(member.getName()).isEqualTo(null); // 기본값 "Unknown"
        assertThat(member.getAge()).isEqualTo(age);
    }

    @Test
    void testMemberGet(){

        // Given

        // When
        Member member = Member.getMember();

        // Then
        assertThat(member.getName()).isEqualTo(null);
        assertThat(member.getAge()).isEqualTo(0);
    }
}