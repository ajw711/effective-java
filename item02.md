# 생성자에 매개변수가 많다면 빌더를 고려하라
생성자는 객체를 만들 때 필요한 모든 필드를 매개변수로 받아야 하기 때문에 선택적 매개변수가 많을 때 사용하기 어려워집니다.

### 해결책 1: 점층정 생성자 패턴
- **장점**: 코드가 간단하고 객체를 직접 생성할 수 있습니다.
- **단점**:
  - 생성자에서 모든 필드를 초기화해야 한다면, 일부 필드는 초기화하지 않으려는 의도가 있더라도 모든 필드를 전달해야 합니다.
  - 작성하기 어렵고 읽기도 어렵습니다.

### 해결책 2: 자바빈즈 패턴
- **장점**: 각 필드를 설정하는 메서드를 호출하여 객체를 설정할 수 있습니다.
- **단점**:
  - 객체 하나를 만들려면 메서드를 계속해서 호출해야 합니다.
  - 일관성을 유지하기 어렵거나 객체가 불변(immutable)이 되지 않을 수 있습니다.

~~~java
public class Computer{
    private String cpu;
    private String ram;
    private String gpu;

    public Computer(){}

    public Computer(String cpu, String ram, String gpu) {
        this.cpu = cpu;
        this.ram = ram;
        this.gpu = gpu;
    }

    public static void main(String[] args) {

        // 점층정 생성자 패턴
        Computer computer1 = new Computer("intel", "samsung", "nvidia");

        // 자바빈즈 패턴
        Computer computer2 = new Computer();
        computer2.setCpu("intel");
        computer2.setRam("samsung");
        computer2.setGpu("nvidia");
    }
}
~~~
---
### 해결책 3: 빌더 패턴
- 점층정 생성자 패턴과 자바빈즈 패턴의 대안으로 사용됩니다.
- **장점**:
  - 불안전한 상태가 되지 않도록 보장합니다.
  - 가독성이 향상됩니다.
- **구현 방식**:
  - 객체를 직접 생성하지 않고, 먼저 빌더(정적 팩토리) 객체를 생성한 후 필요한 필드를 설정한 뒤, 마지막으로 `build()` 메서드를 호출하여 객체를 생성합니다.
  - 하위클래스가 상위타입의 메서드를 재정의하면 하위타입이 그 메서드를 사용할 때 하위타입이 반환한 것을 반환하게된다.(공변 반환 타입)
---
##  공변 반환 타입 (Covariant Return Type)

### 공변 반환 타입이란?
- 하위 클래스에서 상위 클래스의 메서드를 재정의할 때, 그 메서드의 반환 타입을 **하위 클래스 타입**으로 변경할 수 있게 해주는 기능입니다.
- 이를 통해 메서드 체이닝 방식으로 코드를 작성하면서도 하위 클래스의 구체적인 타입에 맞는 반환값을 얻을 수 있습니다.

### 공변 반환 타입을 활용한 예:
```java
public abstract class Trip {

    public enum Item {
        Wallet, Phone, Bag, Hat, Map, Book
    }

    final Set<Item> items;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Item> items = EnumSet.noneOf(Item.class);

        public T addItem(Item item) {
            items.add(Objects.requireNonNull(item));
            return self();
        }

        abstract Trip build();

        protected abstract T self();
    }

    Trip(Builder<?> builder) {
        items = builder.items.clone();
    }
}

public class Busan extends Trip {
    private final Destination destination;

    private Busan(Builder builder) {
        super(builder);
        destination = builder.destination;
    }

    public static class Builder extends Trip.Builder<Builder> {
        private final Destination destination;

        public Builder(Destination destination) {
            this.destination = Objects.requireNonNull(destination);
        }

        @Override
        public Busan build() {
            return new Busan(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
```

```java
       Busan busan = new Busan.Builder(Mountain)
                .addItem(Trip.Item.Wallet)
                .addItem(Trip.Item.Bag)
                .addItem(Trip.Item.Phone)
                .build();
```
-  클라이언트 코드는 Trip의 구체적인 구현체가 무엇인지 신경 쓰지 않고, 메서드 체이닝을 통해 객체를 구성할 수 있습니다.

### 단점
- 매개변수가 너무 적으면 굳이 빌더 패턴을 사용해야 하는지 판단할 수 있다.
- 생성자를 사용하는 것보다 코드 비용이 더 발생할 수 있다.
- 매개변수가 4개 이상일 때 사용을 권장한다.
