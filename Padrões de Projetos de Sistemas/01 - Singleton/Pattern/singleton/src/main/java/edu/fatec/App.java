package edu.fatec;

import edu.fatec.Conexao.Conexao;

public class App
{
    public static void main( String[] args )
    {
        Conexao conexao = Conexao.getInstance();
        System.out.println(conexao.getConectar());
        conexao.fecharConexao();
    }
}
