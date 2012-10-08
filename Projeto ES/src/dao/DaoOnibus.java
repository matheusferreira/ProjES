package dao;

import util.BancoDados;
import java.sql.*;
import java.util.ArrayList;

import entidades.Onibus;

public class DaoOnibus {
    
    public boolean cadastrarOnibus(Onibus onibus){
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Onibus";
            ResultSet rsV = stmt.executeQuery(sql);
            while(rsV.next()){
                if(rsV.getString("onibusPlaca").equals(onibus.getOnibusPlaca())){
                    return false;
                }
            }
            sql = "INSERT INTO Onibus VALUES (0, '"+onibus.getOnibusPlaca()+"', '"+onibus.getOnibusModelo()+"', '"+onibus.getOnibusMarca()+"', "+onibus.getOnibusAno()+", "+onibus.getOnibusQtdeAssentos()+")";
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
    
    public boolean alterarOnibus(Onibus onibus){
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Onibus";
            ResultSet rsV = stmt.executeQuery(sql);
            while(rsV.next()){
                if(rsV.getString("onibusPlaca").equals(onibus.getOnibusPlaca()) && rsV.getInt("onibusId") != onibus.getOnibusId()){
                    return false;
                }
            }
            sql = "UPDATE Onibus set onibusPlaca = '"+onibus.getOnibusPlaca()+"', "
                    + "onibusMarca = '"+onibus.getOnibusMarca()+"', onibusModelo = '"+onibus.getOnibusModelo()+"', onibusAno = '"+onibus.getOnibusAno()+"',"
                    + "onibusQtdeAssentos = '"+onibus.getOnibusQtdeAssentos()+"' where onibusId = "+onibus.getOnibusId();
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
    
    public boolean removerOnibus(Onibus onibus){
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Horario where horario_onibusId in (Select onibusId from Onibus where onibusId = "+onibus.getOnibusId()+")";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                return false;
            }
            sql = "DELETE FROM Onibus where onibusId = "+ onibus.getOnibusId();
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
    
    public Onibus consultaOnibus(Onibus onibus){
        Onibus dadosOnibus = new Onibus();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Onibus where OnibusId = " + onibus.getOnibusId();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            dadosOnibus.setOnibusPlaca(rs.getString("OnibusPlaca"));
            dadosOnibus.setOnibusModelo(rs.getString("OnibusModelo"));
            dadosOnibus.setOnibusMarca(rs.getString("OnibusMarca"));
            dadosOnibus.setOnibusAno(rs.getInt("OnibusAno"));
            dadosOnibus.setOnibusQtdeAssentos(rs.getInt("OnibusQtdeAssentos"));
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        } 
        return dadosOnibus;
    }
    
    public ArrayList<Onibus> consultarTodosOnibus(){
        ArrayList<Onibus> arrayList = new ArrayList<Onibus>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Onibus order by onibusPlaca asc";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Onibus onibus = new Onibus();
                onibus.setOnibusId(rs.getInt("onibusId"));
                onibus.setOnibusPlaca(rs.getString("onibusPlaca"));
                arrayList.add(onibus);
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
    
    public ArrayList<Onibus> consultarOnibusLivres(String horarioSaida, String horarioChegada, String dias){
        ArrayList<Onibus> arrayList = new ArrayList<Onibus>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select onibus.* from onibus" +
            		" where NOT EXISTS (select 1 from horario where onibus.OnibusId = horario.Horario_OnibusId and HorarioDiaId IN ("+dias+")" +
            		" and (('"+horarioSaida+"' between horario.HorarioSaida and horario.HorarioChegada)" +
            		" or ('"+horarioChegada+"' between horario.HorarioSaida and horario.HorarioChegada))" +
            		" and Horario_usado = 1)";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Onibus onibus = new Onibus();
                onibus.setOnibusId(rs.getInt("onibusId"));
                onibus.setOnibusPlaca(rs.getString("onibusPlaca"));
                arrayList.add(onibus);
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
