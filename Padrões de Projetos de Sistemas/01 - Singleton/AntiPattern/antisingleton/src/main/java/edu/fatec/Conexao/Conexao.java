package edu.fatec.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private String endereco = "jdbc:mysql://localhost:3306/";
    private String nomeBanco;
    private String usuario;
    private String senha;

    public Conexao(String nomeBanco, String usuario, String senha) {
        this.nomeBanco = nomeBanco;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Connection criarConexao() {
        try {
            Connection conectar = DriverManager.getConnection(endereco + nomeBanco, usuario, senha);
            if (conectar != null) {
                System.out.println("Conexão realizada com sucesso!");
            } else {
                System.out.println("Falha ao conectar!");
            }
        } catch (Exception e) {
            System.out.println("Falha ao conectar!");
        }
        return null;
    }

    public void fecharConexao(Connection conexao) {
        try {
            conexao.close();
            System.out.println("Conexão fechada com sucesso!");
        } catch (Exception e) {
            System.out.println("Falha ao fechar conexão!");
        }
    }
}
