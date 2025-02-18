package hello.effective_java.chap01.item01;

import lombok.Getter;

@Getter
public class Member {

    private String name;
    private int age;

    private final static Member DEFAULT_MEMBER= new Member();

    private Member(){}
    private Member(String name, int age){
        this.name = name;
        this.age = age;
    }

    public static Member of(String name, int age){
        return new Member(name , age);
    }

    private Member(String name){
        this.name = name;
    }

    public static Member ofName(String name){
        return new Member(name);
    }


    public static Member ofAge(int age){
        Member member = new Member();
        member.age = age;
        return member;
    }

    public static Member getMember(){
        return DEFAULT_MEMBER;
    }


    public static void main(String[] args) {
        Member member1 = Member.of("Tom", 18);

        Member member2 = Member.ofName("John");

        Member member3 = Member.ofAge(20);

        //불변 객체로 반복적으로 DEFAULT_MEMBER 반환
        Member member4 = Member.getMember();

        System.out.println("Member 1: " + member1.name + ", " + member1.age);
        System.out.println("Member 2: " + member2.name + ", " + member2.age);
        System.out.println("Member 3: " + member3.name + ", " + member3.age);
        System.out.println("Member 4: " + member3.name + ", " + member3.age);

    }
}
