package dao;

import entidades.RotaItinerario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import util.BancoDados;
import entidades.Itinerario;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoRotaItinerario {

    public boolean cadastrarNovoRotaItinerario(RotaItinerario rotaItinerario) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "insert into RotaItinerario (RotaItinerarioId, Rotaitinerario_rotaId, Rotaitinerario_itinerarioId, RotaitinerarioOrdem)"
                    + " VALUES ( '" + rotaItinerario.getRotaItinerarioId() + "','" + rotaItinerario.getRotaitinerario_rotaId()
                    + "','" + rotaItinerario.getRotaitinerario_itinerarioId() + "','" + rotaItinerario.getRotaitinerarioOrdem() + "')";
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

    public ArrayList<Itinerario> consultarItinerariosCadastrados() {
        ArrayList<Itinerario> arrayList = new ArrayList<Itinerario>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT ItinerarioId, RotaItinerarioId, origem.CidadeNome, origem.CidadeId, destino.CidadeNome, destino.CidadeId "
                    + "FROM RotaItinerario "
                    + "INNER JOIN Itinerario ON(ItinerarioId = RotaItinerario_ItinerarioId) "
                    + "INNER JOIN Cidade AS origem ON (Itinerario_CidadeOrigem = origem.CidadeId) "
                    + "INNER JOIN Cidade AS destino ON(destino.CidadeId = Itinerario_CidadeDestino) "
                    + "GROUP BY origem.CidadeNome, destino.CidadeNome "
                    + "ORDER BY origem.CidadeNome, destino.CidadeNome";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Itinerario Itinerario = new Itinerario();
                Itinerario.setItinerarioId(rs.getInt("ItinerarioId"));
                Itinerario.setItinerario_cidadeOrigemId(rs.getInt("origem.CidadeId"));
                Itinerario.setItinerario_cidadeDestinoId(rs.getInt("destino.CidadeId"));
                Itinerario.setItinerario_cidadeOrigem(rs.getString("origem.CidadeNome"));
                Itinerario.setItinerario_cidadeDestino(rs.getString("destino.CidadeNome"));
                arrayList.add(Itinerario);
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
    
    public boolean removerRotaItinerario(Itinerario itinerario) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Horario WHERE Horario_RotaItinerarioId IN (SELECT RotaItinerarioId FROM RotaItinerario WHERE RotaItinerario_ItinerarioId =" + itinerario.getItinerarioId() + ")";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return false;
            }
            sql = "DELETE FROM RotaItinerario WHERE RotaItinerario_ItinerarioId =" + itinerario.getItinerarioId();
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
}
