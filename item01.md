# 생성자 대신 정적 팩토리 메서드를 고려하라

생성자 대신 사용하면 더 유연한 설계를 제공할 수 있습니다. 이 방식은 객체 생성 방식에 있어 여러 가지 장점을 제공합니다.

## 핵심 개념
**정적 팩토리 메서드를 사용하면 객체 생성 시 유연성과 확장성을 높일 수 있습니다.**

## 정적 팩토리 메서드란?
- 생성자처럼 객체를 반환하는 `static` 메서드입니다.
- 생성자 대신 객체를 생성하는 역할을 하며, 다양한 장점과 유용성을 제공합니다.

## 장점

### 1. **이름을 가질 수 있다**
- 생성자는 이름을 가질 수 없지만, 정적 팩토리 메서드는 이름을 가질 수 있습니다.
- 이름을 통해 메서드가 하는 일이나 반환되는 객체의 특성을 명확히 표현할 수 있습니다.

### 2. **반드시 새로운 객체를 만들 필요가 없다 (싱글톤 & 캐싱)**
- 불변(Immutable) 클래스이거나, 매번 새 인스턴스를 생성할 필요가 없는 경우에는 이미 생성된 인스턴스를 반환하거나 캐싱된 객체를 반환하여 성능과 메모리 사용을 최적화할 수 있습니다.

### 3. **반환 타입을 하위 타입(서브클래스) 인스턴스로 지정할 수 있다**
- 정적 팩토리 메서드는 반환 타입을 하위 타입(서브클래스)으로 지정할 수 있어 유연성을 높입니다.
- 객체 생성 방식을 숨기고, 클라이언트가 구체적인 클래스 이름을 알 필요 없이 객체를 생성할 수 있습니다.

### 4. **리턴하는 객체의 클래스가 입력 매개변수에 따라 달라질 수 있다**
- 정적 팩토리 메서드는 입력 매개변수에 따라 반환되는 객체의 클래스를 다르게 할 수 있습니다.
- 특정 조건에 따라 다른 클래스를 반환할 수 있기 때문에, 유연성과 확장성을 제공합니다.

### 5. **리턴할 객체의 클래스가 메서드 작성 시점에 반드시 정의되어 있어야 할 필요가 없다**
- 예를 들어, **JDBC**와 같은 경우, 팩토리 메서드에서 반환될 객체의 타입을 팩토리 메서드 내부에서 결정할 수 있습니다.
- 이로 인해, 팩토리 메서드를 작성할 때 반환 타입을 미리 알 필요가 없으며, 객체를 동적으로 생성하여 반환할 수 있습니다.

## 단점

### 1. **상속 불가**
- 정적 팩토리 메서드는 `public` 또는 `protected` 생성자 없이 제공됩니다. 따라서, 상속할 수 없습니다.
- 그러나 상속보다는 구성(컴포지션)을 권장하는 설계에서는 오히려 장점이 될 수 있습니다.

### 2. **찾기 어려운 메서드**
- 정적 팩토리 메서드는 Javadoc에서 자동으로 노출되지 않기 때문에, 문서에서 이를 명확히 설명하는 것이 중요합니다.
- 사용자가 정적 팩토리 메서드를 찾기 어려울 수 있으므로, 이를 명확히 안내하는 문서화가 필요합니다.

## 결론
정적 팩토리 메서드는 객체 생성 시 유연성과 확장성을 높이는 좋은 방법입니다. 다만, 상속이 불가능하고, 메서드를 찾기 어렵다는 단점이 있을 수 있으므로, 이 점을 고려하여 사용해야 합니다.
