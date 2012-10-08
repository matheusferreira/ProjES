package dao;

import util.BancoDados;
import java.sql.*;
import java.util.ArrayList;

import entidades.Cidade;

public class DaoCidade {

    public boolean cadastrarCidade(Cidade cidade) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Cidade";
            ResultSet rsV = stmt.executeQuery(sql);
            while (rsV.next()) {
                if (rsV.getString("cidadeNome").equals(cidade.getCidadeNome()) && rsV.getString("cidade_EstadoId").equals(cidade.getCidade_estadoId())) {
                    return false;
                }
            }
            sql = "INSERT INTO Cidade VALUES (0, '" + cidade.getCidadeNome() + "', '" + cidade.getCidade_estadoId() + "')";
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

    public boolean alterarCidade(Cidade cidade) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Cidade";
            ResultSet rsV = stmt.executeQuery(sql);
            while (rsV.next()) {
                if (rsV.getString("cidadeNome").equals(cidade.getCidadeNome()) && rsV.getString("cidade_EstadoId").equals(cidade.getCidade_estadoId()) && rsV.getInt("cidadeId") != cidade.getCidadeId()) {
                    return false;
                }
            }
            sql = "UPDATE Cidade set cidadeNome = '" + cidade.getCidadeNome() + "', cidade_EstadoId = '" + cidade.getCidade_estadoId() + "' where cidadeId = " + cidade.getCidadeId();
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

    public boolean removerCidade(Cidade cidade) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Rota where rota_cidadeOrigem in (Select cidadeId from Cidade where cidadeId = "+cidade.getCidadeId()+") OR rota_cidadeDestino in (Select cidadeId from Cidade where cidadeId = "+cidade.getCidadeId()+")";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                return false;
            }
            sql = "select * from Itinerario where itinerario_cidadeOrigem in (Select cidadeId from Cidade where cidadeId = "+cidade.getCidadeId()+") OR itinerario_cidadeDestino in (Select cidadeId from Cidade where cidadeId = "+cidade.getCidadeId()+")";
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                return false;
            }
            sql = "DELETE FROM Cidade where cidadeId = " + cidade.getCidadeId();
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

    public Cidade consultaCidade(Cidade cidade) {
        Cidade dadosCidade = new Cidade();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select C.cidadeNome, E.estadoId from Cidade C, Estado E where cidadeId = " + cidade.getCidadeId() + " and E.estadoId = C.cidade_EstadoId";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            dadosCidade.setCidadeNome(rs.getString("cidadeNome"));
            dadosCidade.setCidade_estadoId(rs.getInt("estadoId"));
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return dadosCidade;
    }

    public ArrayList<Cidade> consultarTodasCidades() {
        ArrayList<Cidade> arrayList = new ArrayList<Cidade>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select c.cidadeNome, c.cidadeId, e.estadoUF from cidade c, estado e where c.cidade_EstadoId = e.estadoId order by cidadeNome asc";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setCidadeId(rs.getInt("cidadeId"));
                cidade.setCidadeNome(rs.getString("cidadeNome") + " - " + rs.getString("estadoUF"));
                arrayList.add(cidade);
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
