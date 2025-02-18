package hello.effective_java.chap01.item01;

import java.sql.*;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

public class UserFactory {
    // 팩토리 메서드에서 객체를 동적으로 생성
    public static User createUserFromDatabase(String userId) {
        String query = "SELECT name, age FROM Users WHERE id = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                return new User(name, age);  // 런타임에 반환될 객체의 타입이 결정됨
            } else {
                throw new IllegalArgumentException("User not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        User user = createUserFromDatabase("123");
        System.out.println(user);
    }
}