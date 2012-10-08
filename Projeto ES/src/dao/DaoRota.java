package dao;

import entidades.Cidade;
import entidades.Rota;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.BancoDados;

public class DaoRota {

    public ArrayList<Rota> carregaRotas(int id) {
        ArrayList<Rota> arrayList = new ArrayList<Rota>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Rota where rota_cidadeOrigem = " + id + "";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) { // criando arrayList de itinerario
                Rota rota = new Rota();
                rota.setRotaId(rs.getInt("rotaId"));
                rota.setRota_cidadeOrigemId(rs.getInt("rota_cidadeOrigem"));
                rota.setRota_cidadeDestinoId(rs.getInt("rota_cidadeDestino"));
                DaoCidade daoCidade = new DaoCidade();
                Cidade cidade = new Cidade();
                cidade.setCidadeId(rs.getInt("rota_cidadeOrigem"));
                cidade = daoCidade.consultaCidade(cidade);
                rota.setRota_cidadeOrigem(cidade.getCidadeNome());
                cidade.setCidadeId(rs.getInt("rota_cidadeDestino"));
                cidade = daoCidade.consultaCidade(cidade);
                rota.setRota_cidadeDestino(cidade.getCidadeNome());
                arrayList.add(rota);
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

    public int cadastrarRota(Rota rota) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Rota WHERE Rota_CidadeOrigem = " + rota.getRota_cidadeOrigemId() + " AND Rota_CidadeDestino = " + rota.getRota_cidadeDestinoId();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return 1;
            }
            if (rota.getRota_cidadeOrigemId() != rota.getRota_cidadeDestinoId()) {
                sql = "INSERT INTO Rota VALUES (0, " + rota.getRota_cidadeOrigemId() + ", " + rota.getRota_cidadeDestinoId() + ", '" + rota.getRotaDuracao() + "')";
                stmt.executeUpdate(sql);
            } else {
                return 2;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return 0;
    }

    public int alterarRota(Rota rota) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Rota WHERE Rota_CidadeOrigem = " + rota.getRota_cidadeOrigemId() + " AND Rota_CidadeDestino = " + rota.getRota_cidadeDestinoId() + " AND RotaDuracao = '" + rota.getRotaDuracao() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return 1;
            }
            sql = "SELECT * FROM RotaItinerario WHERE RotaItinerario_RotaId = " + rota.getRotaId();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return 2;
            }
            if (rota.getRota_cidadeOrigemId() != rota.getRota_cidadeDestinoId()) {
                sql = "UPDATE Rota SET Rota_CidadeOrigem = " + rota.getRota_cidadeOrigemId() + ", Rota_CidadeDestino = " + rota.getRota_cidadeDestinoId() + ", RotaDuracao = '" + rota.getRotaDuracao() + "' WHERE RotaId = " + rota.getRotaId();
                stmt.executeUpdate(sql);
            } else {
                return 3;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return 0;
    }

    public boolean removerRota(Rota rota) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM RotaItinerario WHERE RotaItinerario_RotaId = " + rota.getRotaId();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return false;
            }
            sql = "DELETE FROM Rota WHERE RotaId = " + rota.getRotaId();
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

    public Rota consultaRota(Rota rota) {
        Rota dadosRota = new Rota();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Rota WHERE RotaId = " + rota.getRotaId() + "";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            dadosRota.setRota_cidadeOrigemId(rs.getInt("Rota_CidadeOrigem"));
            dadosRota.setRota_cidadeDestinoId(rs.getInt("Rota_CidadeDestino"));
            dadosRota.setRotaDuracao(rs.getString("RotaDuracao"));
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return dadosRota;
    }

    public ArrayList<Rota> consultarTodasRotas() {
        ArrayList<Rota> arrayList = new ArrayList<Rota>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT RotaId, origem.CidadeNome, origem.CidadeId, destino.CidadeNome, destino.CidadeId, RotaDuracao "
                    + "FROM Rota "
                    + "INNER JOIN Cidade AS origem ON (Rota_CidadeOrigem = origem.CidadeId) "
                    + "INNER JOIN Cidade AS destino ON(destino.CidadeId = Rota_CidadeDestino) order by origem.CidadeNome, destino.CidadeNome";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Rota rota = new Rota();
                rota.setRotaId(rs.getInt("RotaId"));
                rota.setRota_cidadeOrigemId(rs.getInt("origem.CidadeId"));
                rota.setRota_cidadeDestinoId(rs.getInt("destino.CidadeId"));
                rota.setRota_cidadeOrigem(rs.getString("origem.CidadeNome"));
                rota.setRota_cidadeDestino(rs.getString("destino.CidadeNome"));
                rota.setRotaDuracao(rs.getString("RotaDuracao"));
                arrayList.add(rota);
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
