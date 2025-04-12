package org.example;


import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection conectar() throws Exception {
       String url = "jdbc:postgresql://localhost:5432/seguranca_db";
       String usuario = "postgres";
       String senha = "123";
       return DriverManager.getConnection(url,usuario,senha);
    }
}

