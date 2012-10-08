package dao;

import util.BancoDados;
import java.sql.*;
import java.util.ArrayList;

import entidades.Motorista;

public class DaoMotorista {

    public int cadastrarMotorista(Motorista motorista) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Motorista";
            ResultSet rsV = stmt.executeQuery(sql);
            while (rsV.next()) {
                if (rsV.getString("motoristaRg").equals(motorista.getMotoristaRg())) {
                    return 1;
                } else if (rsV.getString("motoristaCpf").equals(motorista.getMotoristaCpf())) {
                    return 2;
                }
            }
            sql = "INSERT INTO Motorista VALUES (0, '" + motorista.getMotoristaNome() + "', '" + motorista.getMotoristaRg() + "', '" + motorista.getMotoristaCpf() + "', '" + motorista.getMotoristaEnd() + "', '" + motorista.getMotoristaTel() + "', '" + motorista.getMotoristaEmail() + "')";
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return 0;
    }

    public int alterarMotorista(Motorista motorista) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Motorista";
            ResultSet rsV = stmt.executeQuery(sql);
            while (rsV.next()) {
                if (rsV.getString("motoristaRg").equals(motorista.getMotoristaRg()) && rsV.getInt("motoristaId") != motorista.getMotoristaId()) {
                    return 1;
                } else if (rsV.getString("motoristaCpf").equals(motorista.getMotoristaCpf()) && rsV.getInt("motoristaId") != motorista.getMotoristaId()) {
                    return 2;
                }
            }
            sql = "UPDATE Motorista set motoristaNome = '" + motorista.getMotoristaNome() + "', motoristaRg = '" + motorista.getMotoristaRg() + "', "
                    + "motoristaCpf = '" + motorista.getMotoristaCpf() + "', motoristaTel = '" + motorista.getMotoristaTel() + "', motoristaEnd = '" + motorista.getMotoristaEnd() + "',"
                    + "motoristaEmail = '" + motorista.getMotoristaEmail() + "' where motoristaId = " + motorista.getMotoristaId();
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return 0;
    }

    public boolean removerMotorista(Motorista motorista) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Horario where horario_motoristaId in (Select motoristaId from Motorista where motoristaId = "+motorista.getMotoristaId()+")";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                return false;
            }
            sql = "DELETE FROM Motorista where motoristaId = " + motorista.getMotoristaId();
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

    public Motorista consultarMotorista(Motorista motorista) {
        Motorista dadosMotorista = new Motorista();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Motorista where motoristaId = " + motorista.getMotoristaId();
            System.out.println("ID motorista: "+motorista.getMotoristaId());
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            dadosMotorista.setMotoristaRg(rs.getString("motoristaRg"));
            dadosMotorista.setMotoristaCpf(rs.getString("motoristaCpf"));
            dadosMotorista.setMotoristaTel(rs.getString("motoristaTel"));
            dadosMotorista.setMotoristaEnd(rs.getString("motoristaEnd"));
            dadosMotorista.setMotoristaEmail(rs.getString("motoristaEmail"));
            dadosMotorista.setMotoristaNome(rs.getString("motoristaNome"));
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return dadosMotorista;
    }

    public ArrayList<Motorista> consultarTodosMotoristas() {
        ArrayList<Motorista> arrayList = new ArrayList<Motorista>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from Motorista order by motoristaNome asc";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Motorista motorista = new Motorista();
                motorista.setMotoristaId(rs.getInt("motoristaId"));
                motorista.setMotoristaNome(rs.getString("motoristaNome") + " - " + rs.getString("motoristaCpf"));
                arrayList.add(motorista);
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
    
    public ArrayList<Motorista> consultarMotoristasLivres(String horarioSaida, String horarioChegada, String dias) {
        ArrayList<Motorista> arrayList = new ArrayList<Motorista>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select motorista.* from motorista where NOT EXISTS (select 1 from horario where motorista.MotoristaId = horario.Horario_MotoristaId and HorarioDiaId IN ("+dias+") and (('"+horarioSaida+"' between horario.HorarioSaida and horario.HorarioChegada) or ('"+horarioChegada+"' between horario.HorarioSaida and horario.HorarioChegada)) and Horario_usado = 1)";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Motorista motorista = new Motorista();
                motorista.setMotoristaId(rs.getInt("motoristaId"));
                motorista.setMotoristaNome(rs.getString("motoristaNome") + " - " + rs.getString("motoristaCpf"));
                arrayList.add(motorista);
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
