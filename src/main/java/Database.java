import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    Connection connection;
    Statement statement;


    public Database(Connection connection, Statement statement) {
        this.connection = connection;
        this.statement = statement;
    }

    public int addToDatabase(String productName, String productCategory) {
        try {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS PRODUCT (name String, category String)");
            statement.executeUpdate(
                    String.format("INSERT INTO PRODUCT VALUES('%s', '%s')", productName, productCategory));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
