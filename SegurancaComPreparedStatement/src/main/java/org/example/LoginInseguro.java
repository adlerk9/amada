package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginInseguro {

    public static boolean autenticar(Usuario usuario) throws Exception{

        Connection conn = Conexao.conectar();
        String sql = "SELECT * FROM usuarios WHERE login = '" + usuario.getLogin() + "'and senhar = '" + usuario.getSenha() +
                "'";
        System.out.println("Sql gerada = " + sql);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        return rs.next();

    }
}
