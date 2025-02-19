package hello.effective_java.chap01.item02;

import lombok.Getter;
import lombok.Setter;


@Getter
public class Computer {

    private final String cpu;
    private final String ram;
    private final String gpu;

    private Computer(Builder builder){
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.gpu = builder.gpu;
    }

    public static class Builder{
        private final String cpu; //필수 필드
        private String ram = "" ;  // 선택 필드
        private String gpu = ""; // 선택 필드

        public Builder(String cpu) {
            if (cpu == null || cpu.isEmpty()) {
                throw new IllegalArgumentException("cpu empty");
            }
            this.cpu = cpu;
        }

        // 선택 필드 설정 메서드 (체이닝 지원)

        public Builder ram(String ram){
            this.ram = ram;
            return this;
        }
        public Builder gpu(String gpu){
            this.gpu = gpu;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }

        @Override
        public String toString() {
            return "Computer{" +
                    "cpu='" + cpu + '\'' +
                    ", ram='" + ram + '\'' +
                    ", gpu='" + gpu + '\'' +
                    '}';
        }




    }


}
