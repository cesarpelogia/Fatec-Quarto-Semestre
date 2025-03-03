package edu.fatec.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // Constantes para a URL, usuário e senha do banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/singleton";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Instância única da classe Conexao (Singleton)
    private static Conexao instancia;

    // Objeto Connection para gerenciar a conexão com o banco de dados
    private Connection conectar;

    // Construtor privado para impedir a criação de novas instâncias
    private Conexao(){
        this.conectar = criarConexao();
    }

    // Método estático para obter a instância única da classe Conexao
    public static Conexao getInstance(){
        if(instancia == null){
            instancia = new Conexao();
        }
        return instancia;
    }

    // Método privado para criar a conexão com o banco de dados
    private Connection criarConexao(){
        try {
            conectar = DriverManager.getConnection(URL, USER, PASSWORD);
            if (conectar != null) {
                System.out.println("Conexão realizada com sucesso!");
            } else {
                System.out.println("Conexão falhou!");
            }
        } catch (SQLException e) {
            System.out.printf("Erro na conexão: %s\n%s", e.getLocalizedMessage(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
        return conectar;
    }

    // Método para fechar a conexão com o banco de dados
    public void fecharConexao(){
        try {
            conectar.close();
        } catch (SQLException e) {
            System.out.printf("Erro ao fechar a conexão: %s\n%s", e.getLocalizedMessage(), e.getMessage());
        }
    }

    // Método para obter o objeto Connection
    public Connection getConectar() {
        return conectar;
    }
}