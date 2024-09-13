package util;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Connected to the todoit database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
