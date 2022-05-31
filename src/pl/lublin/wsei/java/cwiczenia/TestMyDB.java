package pl.lublin.wsei.java.cwiczenia;
import pl.lublin.wsei.java.cwiczenia.MyDB;

import java.sql.Connection;

public class TestMyDB {

    public static void main(String[] args) {
        MyDB db = new MyDB("localhost", "mydb", 3306);
        db.setUser("root");
        db.setPassword("root");
        Connection conn = db.getConnection();
        if (conn != null)
            System.out.println("Połączenie z bazą danych nawiązane");
    }
}
