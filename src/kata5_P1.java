/**
 * @author -_R.S.C_-
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Kata5P1 {

    public static void main(String[] args) {
        String fichero = "email.txt";
        List<String> lista = new MailListReader().read(fichero);

        String url = "jdbc:sqlite:Kata5.db";
        String sql= "INSERT INTO EMAIL(Mail) VALUES(?)";
        try (Connection conn = DriverManager.getConnection(url) ;
            PreparedStatement pstmt= conn.prepareStatement(sql)) {
            for (String list: lista) {
                pstmt.setString(1, list);
                pstmt.executeUpdate();
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}