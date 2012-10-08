package dao;

import util.BancoDados;
import java.sql.*;
import java.util.ArrayList;

import entidades.Funcionario;

public class DaoFuncionario {

    public boolean cadastrarFuncionario(Funcionario funcionario) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Funcionario";
            ResultSet rsV = stmt.executeQuery(sql);
            while (rsV.next()) {
                if (rsV.getString("funcionarioCpf").equals(funcionario.getFuncionarioCpf())) {
                    return false;
                }
            }
            sql = "INSERT INTO Funcionario VALUES (0, '" + funcionario.getFuncionarioNome() + "', '" + funcionario.getFuncionarioCpf() + "', '" + funcionario.getFuncionarioEmail() + "', '" + funcionario.getFuncionarioSenha() + "', " + funcionario.getFuncionarioAcesso() + ")";
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return true;
    }

    public boolean alterarFuncionario(Funcionario funcionario) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Funcionario";
            ResultSet rsV = stmt.executeQuery(sql);
            while (rsV.next()) {
                if (rsV.getString("funcionarioCpf").equals(funcionario.getFuncionarioCpf()) && rsV.getInt("funcionarioId") != funcionario.getFuncionarioId()) {
                    return false;
                }
            }
            sql = "UPDATE Funcionario set funcionarioNome = '" + funcionario.getFuncionarioNome() + "', "
                    + "funcionarioCpf = '" + funcionario.getFuncionarioCpf() + "', funcionarioSenha = '" + funcionario.getFuncionarioSenha() + "',"
                    + "funcionarioEmail = '" + funcionario.getFuncionarioEmail() + "' ,"
                    + "funcionarioAcesso = " + funcionario.getFuncionarioAcesso() + " where funcionarioId = " + funcionario.getFuncionarioId();
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return true;
    }

    public boolean removerFuncionario(Funcionario funcionario) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM Funcionario where funcionarioId = " + funcionario.getFuncionarioId();
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
            return false;
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            //ex.printStackTrace();
            return false;
        }
        return true;
    }

    public Funcionario consultarFuncionario(Funcionario funcionario) {
        Funcionario dadosFuncionario = new Funcionario();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Funcionario where funcionarioId = " + funcionario.getFuncionarioId();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            dadosFuncionario.setFuncionarioCpf(rs.getString("funcionarioCpf"));
            dadosFuncionario.setFuncionarioSenha(rs.getString("funcionarioSenha"));
            dadosFuncionario.setFuncionarioEmail(rs.getString("funcionarioEmail"));
            dadosFuncionario.setFuncionarioNome(rs.getString("funcionarioNome"));
            dadosFuncionario.setFuncionarioAcesso(rs.getInt("funcionarioAcesso"));
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return dadosFuncionario;
    }

    public ArrayList<Funcionario> consultarTodosFuncionarios() {
        ArrayList<Funcionario> arrayList = new ArrayList<Funcionario>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Funcionario order by funcionarioNome asc";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setFuncionarioId(rs.getInt("funcionarioId"));
                funcionario.setFuncionarioNome(rs.getString("funcionarioNome") + " - " + rs.getString("funcionarioCpf"));
                arrayList.add(funcionario);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return arrayList;
    }
}
