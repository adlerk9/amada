package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginSeguro {
    public static boolean autenticar(Usuario usuario) throws Exception{

        Connection conn = Conexao.conectar();
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senhar = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, usuario.getLogin());
        stmt.setString(2, usuario.getSenha());


        ResultSet rs = stmt.executeQuery();

        return rs.next();

    }
}
