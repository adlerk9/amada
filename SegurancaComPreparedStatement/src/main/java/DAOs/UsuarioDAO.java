package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection connection;
    public UsuarioDAO() {
        this.connection = connection;
    }

    public UsuarioDAO(String login, String senha) {
    }

    public boolean loginExiste(String login) throws SQLException {
        String sql = "SELECT 1 FROM usuarios WHERE login = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, login);
        ResultSet rs = stmt.executeQuery();
        boolean existe = rs.next();
        rs.close();
        stmt.close();
        return existe;
    }
    public boolean cadastrar(String login, String senha) throws SQLException {
        if (loginExiste(login)) {
            return false;
        }
        String sql = "INSERT INTO usuarios (login, senha) VALUES (?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, login);
        stmt.setString(2, senha);
        int linhas = stmt.executeUpdate();
        stmt.close();
        return linhas > 0;
    }
    public boolean atualizar(String login, String novaSenha) throws SQLException {
        if (!loginExiste(login)) {
            return false;
        }
        String sql = "UPDATE usuarios SET senha = ? WHERE login = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, novaSenha);
        stmt.setString(2, login);
        int linhas = stmt.executeUpdate();
        stmt.close();
        return linhas>0;
}
}