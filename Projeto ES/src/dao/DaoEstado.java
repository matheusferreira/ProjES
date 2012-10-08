package dao;

import util.BancoDados;
import java.sql.*;
import java.util.ArrayList;

import entidades.Estado;

public class DaoEstado {
    
    public boolean cadastrarEstado(Estado estado){
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Estado";
            ResultSet rsV = stmt.executeQuery(sql);
            if(rsV.next()){
                if(rsV.getString("estadoUF").equals(estado.getEstadoUf())){
                    return false;
                }
            }
            sql = "INSERT INTO Estado VALUES (0, '"+estado.getEstadoUf()+"')";
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
            return false;
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean alterarEstado(Estado estado){
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Estado";
            ResultSet rsV = stmt.executeQuery(sql);
            while(rsV.next()){
                if(rsV.getString("estadoUF").equals(estado.getEstadoUf()) && rsV.getInt("estadoId") != estado.getEstadoId()){
                    return false;
                }
            }
            sql = "UPDATE Estado set estadoUF = '"+estado.getEstadoUf()+"' where estadoId = "+estado.getEstadoId();
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
            return false;
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean removerEstado(Estado estado){
                BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Cidade where cidade_EstadoId in (Select estadoId from Estado where estadoUF = '"+estado.getEstadoUf()+"')";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                return false;
            }
            sql = "DELETE FROM Estado where estadoId = " + estado.getEstadoId();
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
            return false;
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public ArrayList<Estado> ConsultarTodosEstados(){
        ArrayList<Estado> arrayList = new ArrayList<Estado>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Estado order by estadoUF asc";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setEstadoId(rs.getInt("estadoId"));
                estado.setEstadoUf(rs.getString("estadoUF"));
                arrayList.add(estado);
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
    
    public int selecionaEstadoId(String uf){
        int estadoId = 0;
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select estadoId from Estado where estadoUF = '" + uf + "'";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            estadoId = rs.getInt("estadoId");
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        } 
        return estadoId;
    }
    
    public String selecionaEstadoUF(int id){
        String estadoUF = new String();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select estadoUF from Estado where estadoId = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            estadoUF = rs.getString("estadoUF");
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        } 
        return estadoUF;
    }
}
