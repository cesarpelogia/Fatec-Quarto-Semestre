package edu.fatec;

import edu.fatec.Conexao.Conexao;
import java.sql.Connection;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Obtendo usuário para conexão;
        System.out.println("Insira o usuário para fazer a conexão:");
        String usuario = scanner.nextLine();

        // Obtendo senha para conexão;
        System.out.println("Insira a senha para fazer a conexão:");
        String senha = scanner.nextLine();

        // Obtendo nome do banco de dados;
        System.out.println("Insira o nome do banco de dados:");
        String nomeBanco = scanner.nextLine();

        // Criando instância da classe Conexao
        Conexao conexao = new Conexao(nomeBanco, usuario, senha);

        // Tentando estabelecer a conexão
        Connection connection = conexao.criarConexao();

        // Fechando o scanner
        scanner.close();

        // Fechando a conexão se foi estabelecida
        if (connection != null) {
            conexao.fecharConexao(connection);
        }
    }
}