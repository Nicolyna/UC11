import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConectaDAO {
    // Altere para:
    private static final String URL = "jdbc:mysql://localhost:3307/leilao"; // Nome do BD: leilao
    private static final String USER = "root"; 
    private static final String PASSWORD = "brenokeke"; // Coloque sua senha real aqui

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "✅ Conexão bem-sucedida com o banco de dados!");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "❌ Driver do MySQL não encontrado!\n" + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Erro ao conectar ao banco de dados:\n" + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conexao = getConnection();
        if (conexao == null) {
            System.out.println("Falha ao conectar ao banco de dados.");
        }
    }
}

