package org.example;

import DAOs.UsuarioDAO;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);


        System.out.println("escolha uma opçao " +
                "\n" +
                "1 - Fazer login\n" +
                "2 - Cadastrar novo usuário\n" +
                "3 - Alterar senha");
        String opcao = sc.nextLine();

        if (Objects.equals(opcao, "1")) {
            System.out.println("Login: ");
            String login = sc.nextLine();

            System.out.println("Senha: ");
            String senha = sc.nextLine();
            Usuario usuario = new Usuario(login, senha);

            boolean resultado = LoginSeguro.autenticar(usuario);

            if (resultado) {
                System.out.println("Login bem sucedido!");
            } else {
                System.out.println("Usuario ou senha invalida");
            }
        }
        else if (Objects.equals(opcao, "2")) {
            System.out.println("Login: ");
            String login = sc.nextLine();

            System.out.println("Senha: ");
            String senha = sc.nextLine();

            UsuarioDAO usuarioDAO = new UsuarioDAO(login, senha);
            usuarioDAO.cadastrar(login, senha);

        } else if (Objects.equals(opcao, "3")) {
            System.out.println("Login: ");
            String vr = sc.nextLine();

            System.out.println("Senha: ");
            String as = sc.nextLine();

            System.out.println("NOVO Login: ");
            String login = sc.nextLine();

            System.out.println("NOVA Senha: ");
            String senha = sc.nextLine();

            if(Objects.equals(login, "")){
                System.out.println("Nao aceita loguin vazio");
            } else if (Objects.equals(senha, "")) {
                System.out.println("Nao aceita senha vazia");
            }else {
                System.out.println("Atualizado com sucesso");
            }
        } else if (Objects.equals(opcao, "")){
            //UsuarioDAO usuarioDAO = new UsuarioDAO(login, senha);
        }

    }
}