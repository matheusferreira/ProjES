package dao;

import entidades.Cidade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entidades.Itinerario;
import entidades.Rota;
import entidades.RotaItinerario;
import util.BancoDados;

public class DaoItinerario {

    public int cadastrarItinerario(Itinerario itinerario) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            System.out.println("Origem: " + itinerario.getItinerario_cidadeOrigemId() + "\n Destino:" + itinerario.getItinerario_cidadeDestinoId());
            if (itinerario.getItinerario_cidadeOrigemId() != itinerario.getItinerario_cidadeDestinoId()) {
                String sql = "INSERT INTO Itinerario VALUES (0, " + itinerario.getItinerario_cidadeOrigemId() + ", " + itinerario.getItinerario_cidadeDestinoId() + ")";
                stmt.executeUpdate(sql);
            } else {
                return 1;
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

    public int alterarItinerario(Itinerario itinerario) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            System.out.println(itinerario.getItinerarioId());
            String sql = "SELECT * FROM RotaItinerario WHERE RotaItinerario_ItinerarioId = " + itinerario.getItinerarioId();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return 1;
            }
            if (itinerario.getItinerario_cidadeOrigemId() != itinerario.getItinerario_cidadeDestinoId()) {
                sql = "UPDATE Itinerario SET Itinerario_CidadeOrigem = " + itinerario.getItinerario_cidadeOrigemId() + ", Itinerario_CidadeDestino = " + itinerario.getItinerario_cidadeDestinoId() + " WHERE ItinerarioId = " + itinerario.getItinerarioId();
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

    public boolean removerItinerario(Itinerario itinerario) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM RotaItinerario WHERE RotaItinerario_ItinerarioId = " + itinerario.getItinerarioId();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return false;
            }
            sql = "DELETE FROM Itinerario WHERE ItinerarioId = " + itinerario.getItinerarioId();
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

    public Itinerario consultaItinerario(Itinerario itinerario) {
        Itinerario dadosRota = new Itinerario();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Itinerario WHERE ItinerarioId = " + itinerario.getItinerarioId() + "";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            dadosRota.setItinerario_cidadeOrigemId(rs.getInt("Itinerario_CidadeOrigem"));
            dadosRota.setItinerario_cidadeDestinoId(rs.getInt("Itinerario_CidadeDestino"));
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return dadosRota;
    }

    public ArrayList<Itinerario> consultarTodosItinerariosSemRotas() {
        ArrayList<Itinerario> arrayList = new ArrayList<Itinerario>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Itinerario where itinerarioId"
                    + " not in (select distinct rotaitinerario_itinerarioid from RotaItinerario)";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) { // criando arrayList de itinerario
                Itinerario itinerario = new Itinerario();
                itinerario.setItinerarioId(rs.getInt("itinerarioId"));
                itinerario.setItinerario_cidadeOrigemId(rs.getInt("itinerario_cidadeOrigem"));
                itinerario.setItinerario_cidadeDestinoId(rs.getInt("itinerario_cidadeDestino"));
                DaoCidade daoCidade = new DaoCidade();
                Cidade cidade = new Cidade();
                cidade.setCidadeId(rs.getInt("itinerario_cidadeOrigem"));
                cidade = daoCidade.consultaCidade(cidade);
                itinerario.setItinerario_cidadeOrigem(cidade.getCidadeNome());
                cidade.setCidadeId(rs.getInt("itinerario_cidadeDestino"));
                cidade = daoCidade.consultaCidade(cidade);
                itinerario.setItinerario_cidadeDestino(cidade.getCidadeNome());
                arrayList.add(itinerario);
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

    public ArrayList<Itinerario> consultarTodosItinerarios() {
        ArrayList<Itinerario> arrayList = new ArrayList<Itinerario>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT ItinerarioId, origem.CidadeNome, origem.CidadeId, destino.CidadeNome, destino.CidadeId "
                    + "FROM Itinerario "
                    + "INNER JOIN Cidade AS origem ON (Itinerario_CidadeOrigem = origem.CidadeId)"
                    + "INNER JOIN Cidade AS destino ON(destino.CidadeId = Itinerario_CidadeDestino) order by origem.CidadeNome, destino.CidadeNome";
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

    public ArrayList<Rota> consultarRotasdoItinerario(Itinerario itinerario) {
        ArrayList<Rota> arrayList = new ArrayList<Rota>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT origem.cidadeNome, destino.cidadeNome, rota.rotaDuracao, rota.rotaId FROM RotaItinerario"
                    + " INNER JOIN Rota rota ON (rotaId = RotaItinerario_RotaId)"
                    + " INNER JOIN Cidade origem ON (origem.cidadeId = Rota_CidadeOrigem)"
                    + " INNER JOIN Cidade destino ON (destino.cidadeId = Rota_CidadeDestino) WHERE RotaItinerario_ItinerarioId =" + itinerario.getItinerarioId()
                    + " GROUP BY origem.CidadeNome,destino.CidadeNome ORDER BY RotaItinerarioOrdem;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Rota rota = new Rota();
                rota.setRota_cidadeOrigem(rs.getString("origem.CidadeNome"));
                rota.setRota_cidadeDestino(rs.getString("destino.CidadeNome"));
                rota.setRotaDuracao(rs.getString("rota.rotaDuracao"));
                rota.setRotaId(Integer.parseInt(rs.getString("rota.rotaId")));

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

    public ArrayList<RotaItinerario> consultarRotaItinerariodoItinerario(Itinerario itinerario) {
        ArrayList<RotaItinerario> arrayList = new ArrayList<RotaItinerario>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT rota.rotaId, rotaItinerarioId, rotaItinerarioOrdem, rotaItinerario_ItinerarioId FROM RotaItinerario"
                    + " INNER JOIN Rota rota ON (rotaId = RotaItinerario_RotaId)"
                    + " INNER JOIN Cidade origem ON (origem.cidadeId = Rota_CidadeOrigem)"
                    + " INNER JOIN Cidade destino ON (destino.cidadeId = Rota_CidadeDestino) WHERE RotaItinerario_ItinerarioId =" + itinerario.getItinerarioId()
                    + " GROUP BY origem.CidadeNome,destino.CidadeNome ORDER BY RotaItinerarioOrdem;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                RotaItinerario rotaItinerario = new RotaItinerario();
                rotaItinerario.setRotaitinerario_rotaId(Integer.parseInt(rs.getString("rota.rotaId")));
                rotaItinerario.setRotaItinerarioId(Integer.parseInt(rs.getString("rotaItinerarioId")));
                rotaItinerario.setRotaitinerarioOrdem(Integer.parseInt(rs.getString("rotaItinerarioOrdem")));
                rotaItinerario.setRotaitinerario_itinerarioId(Integer.parseInt(rs.getString("rotaItinerario_ItinerarioId")));
                arrayList.add(rotaItinerario);
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

    public ArrayList<Itinerario> consultarTodosItinerariosComHorarios() {
        ArrayList<Itinerario> arrayList = new ArrayList<Itinerario>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT I.ItinerarioId, I.Itinerario_CidadeOrigem, I.Itinerario_CidadeDestino"
                    + " FROM Itinerario I, Horario H, RotaItinerario Ri"
                    + " WHERE H.Horario_RotaItinerarioId = Ri.RotaItinerarioId"
                    + " AND Ri.RotaItinerario_ItinerarioId = I.ItinerarioId"
                    + " GROUP BY I.ItinerarioId";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) { // criando arrayList de itinerario
                Itinerario itinerario = new Itinerario();
                itinerario.setItinerarioId(rs.getInt("itinerarioId"));
                itinerario.setItinerario_cidadeOrigemId(rs.getInt("itinerario_cidadeOrigem"));
                itinerario.setItinerario_cidadeDestinoId(rs.getInt("itinerario_cidadeDestino"));
                DaoCidade daoCidade = new DaoCidade();
                Cidade cidade = new Cidade();
                cidade.setCidadeId(rs.getInt("itinerario_cidadeOrigem"));
                cidade = daoCidade.consultaCidade(cidade);
                itinerario.setItinerario_cidadeOrigem(cidade.getCidadeNome());
                cidade.setCidadeId(rs.getInt("itinerario_cidadeDestino"));
                cidade = daoCidade.consultaCidade(cidade);
                itinerario.setItinerario_cidadeDestino(cidade.getCidadeNome());
                arrayList.add(itinerario);
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
