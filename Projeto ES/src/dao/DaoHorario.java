package dao;

import entidades.Horario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import util.BancoDados;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoHorario {

    public boolean cadastrarNovoHorario(Horario horario, int itinerarioId) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql2 = "select * from horario "
                    + "where HorarioDiaId IN (" + horario.getHorarioDiaId() + ") "
                    + "and HorarioSaida = '" + horario.getHorarioSaida() + "' "
                    + "and Horario_RotaItinerarioId IN "
                    + "(select RotaItinerarioId from rotaitinerario where RotaItinerario_ItinerarioId = " + itinerarioId + ")";
            ResultSet rs = stmt.executeQuery(sql2);
            if (rs.first()) {//Se existir first, ent�o j� existe no BD
                String sq13 = "update horario set HorarioPreco = " + horario.getHorarioPreco() + ""
                        + " , Horario_MotoristaId = " + horario.getHorario_motoristaId() + ""
                        + " , Horario_OnibusId = " + horario.getHorario_onibusId() + ""
                        + " , Horario_usado = 1"
                        + " where HorarioDiaId = " + horario.getHorarioDiaId() + ""
                        + " and HorarioSaida = '" + horario.getHorarioSaida() + "'"
                        + " and Horario_RotaItinerarioId = " + horario.getHorario_rotaItinerarioId() + "";
                stmt.executeUpdate(sq13);
            } else {
                System.out.println("INSERINDO HORARIO");
                String sql = "insert into Horario (HorarioDiaId, Horario_RotaItinerarioId, HorarioSaida, HorarioChegada, HorarioPreco,"
                        + " Horario_MotoristaId, Horario_OnibusId, Horario_usado)"
                        + " VALUES ( '" + horario.getHorarioDiaId() + "','" + horario.getHorario_rotaItinerarioId()
                        + "','" + horario.getHorarioSaida() + "','" + horario.getHorarioChegada() + "','" + horario.getHorarioPreco()
                        + "','" + horario.getHorario_motoristaId() + "','" + horario.getHorario_onibusId() + "', 1)";
                stmt.executeUpdate(sql);
            }
            rs.close();
            stmt.close();

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

    public boolean atualizarHorario(Horario horario, int idItinerario, String horarioSaida) {
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = new String();
            int horarioIdAux = horario.getHorarioId();
            System.out.println("idHorarioAux " + horarioIdAux);
            int destinoFinal = descobreCidadeDestinoFinal(idItinerario);
            int cidadeIntermediaria = descobreCidadeDestino(horario.getHorarioId());
            System.out.println("destino final " + destinoFinal);
            System.out.println("intermedi " + cidadeIntermediaria);
            if (cidadeIntermediaria == destinoFinal) {
                System.out.println("entrou no if");
                sql = "update horario set HorarioPreco = " + horario.getHorarioPreco() + ""
                    + " , Horario_MotoristaId = " + horario.getHorario_motoristaId() + ""
                    + " , Horario_OnibusId = " + horario.getHorario_onibusId() + ""
                    + " , Horario_usado = 0 "
                    + " where HorarioId = " + horarioIdAux;
                stmt.executeUpdate(sql);
            } else {
                while (cidadeIntermediaria != destinoFinal) {
                    sql = "update horario set HorarioPreco = " + horario.getHorarioPreco() + ""
                    + " , Horario_MotoristaId = " + horario.getHorario_motoristaId() + ""
                    + " , Horario_OnibusId = " + horario.getHorario_onibusId() + ""
                    + " , Horario_usado = 0"
                    + " where HorarioId = " + horarioIdAux;
                    stmt.executeUpdate(sql);
                    horarioIdAux++;
                    System.out.println("horarioAux++ " + horarioIdAux);
                    cidadeIntermediaria = descobreCidadeDestino(horarioIdAux);
                }
                sql = "update horario set HorarioPreco = " + horario.getHorarioPreco() + ""
                    + " , Horario_MotoristaId = " + horario.getHorario_motoristaId() + ""
                    + " , Horario_OnibusId = " + horario.getHorario_onibusId() + ""
                    + " , Horario_usado = 0"
                    + " where HorarioId = " + horarioIdAux;
                stmt.executeUpdate(sql);                
            }
            stmt.close();
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

    public ArrayList<ArrayList<String>> consultarTodosHorarios(int idRI, int dia) {
        ArrayList<ArrayList<String>> matriz = new ArrayList<ArrayList<String>>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT origem.cidadeNome, destino.cidadeNome, HorarioPreco, HorarioSaida, HorarioChegada "
                    + "FROM Horario "
                    + "INNER JOIN RotaItinerario ON (Horario_RotaItinerarioId = rotaItinerario_rotaId) "
                    + "INNER JOIN Rota ON (rotaId = RotaItinerario_RotaId) "
                    + "INNER JOIN Cidade origem ON (origem.cidadeId = Rota_CidadeOrigem) "
                    + "INNER JOIN Cidade destino ON (destino.cidadeId = Rota_CidadeDestino) "
                    + "WHERE RotaItinerario_ItinerarioId = " + idRI + " AND HorarioDiaId = " + dia + " "
                    + "ORDER BY HorariodiaId, HorarioSaida;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ArrayList<String> array = new ArrayList<String>();
                array.add(rs.getString("origem.cidadeNome"));
                array.add(rs.getString("destino.cidadeNome"));
                array.add(rs.getString("HorarioPreco"));
                array.add(rs.getString("HorarioSaida"));
                array.add(rs.getString("HorarioChegada"));
                matriz.add(array);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();

        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();

        }
        return matriz;
    }

    public ArrayList<Horario> consultarTodosHorariosItinerario(int id, String horaSaida) {
        ArrayList<Horario> arrayHorario = new ArrayList<Horario>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT horario_RotaItinerarioId, horarioId, horarioDiaId, horarioSaida, horarioChegada, horarioPreco, horario_MotoristaId, horario_OnibusId, horario_usado "
                    + "FROM Horario H, RotaItinerario Ri, Itinerario I "
                    + "WHERE H.Horario_RotaItinerarioId = Ri.RotaItinerarioId "
                    + "AND Ri.RotaItinerario_ItinerarioId = I.ItinerarioId "
                    + "AND I.ItinerarioId = " + id + " AND H.horarioSaida = '" + horaSaida + "' AND H.horario_usado = 1 "
                    + "ORDER BY Ri.RotaItinerarioOrdem";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Horario horario = new Horario();
                horario.setHorario_rotaItinerarioId(Integer.parseInt(rs.getString("horario_RotaItinerarioId")));
                horario.setHorarioId(Integer.parseInt(rs.getString("horarioId")));
                horario.setHorarioDiaId(Integer.parseInt(rs.getString("horarioDiaId")));
                horario.setHorarioSaida(rs.getString("horarioSaida"));
                horario.setHorarioChegada(rs.getString("horarioChegada"));
                horario.setHorarioPreco(Double.parseDouble(rs.getString("horarioPreco")));
                horario.setHorario_motoristaId(Integer.parseInt(rs.getString("horario_MotoristaId")));
                horario.setHorario_onibusId(Integer.parseInt(rs.getString("horario_OnibusId")));
                horario.setHorarioUsado(Integer.parseInt(rs.getString("horario_usado")));
                arrayHorario.add(horario);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();

        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();

        }
        return arrayHorario;
    }

    public ArrayList<Horario> verificaHorarioItinerario(int idItinerario, int horarioUsado, String dias, String horarioSaida) {
        ArrayList<Horario> arrayHorario = new ArrayList<Horario>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select * from horario where HorarioDiaId IN (" + dias + ") "
                    + "and HorarioSaida = '" + horarioSaida + "' "
                    + "and Horario_RotaItinerarioId = (select RotaItinerarioId "
                    + "from rotaitinerario "
                    + "where RotaItinerario_ItinerarioId = " + idItinerario + " "
                    + "and RotaItinerarioOrdem = 1) "
                    + "and Horario_usado = " + horarioUsado + "";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Horario horario = new Horario();
                horario.setHorarioId(Integer.parseInt(rs.getString("horarioId")));
                horario.setHorarioDiaId(Integer.parseInt(rs.getString("horarioDiaId")));
                horario.setHorario_rotaItinerarioId(Integer.parseInt(rs.getString("horario_RotaItinerarioId")));
                horario.setHorarioSaida(rs.getString("horarioSaida"));
                horario.setHorarioChegada(rs.getString("horarioChegada"));
                horario.setHorarioPreco(Double.parseDouble(rs.getString("horarioPreco")));
                horario.setHorario_motoristaId(Integer.parseInt(rs.getString("horario_MotoristaId")));
                horario.setHorario_onibusId(Integer.parseInt(rs.getString("horario_OnibusId")));
                horario.setHorarioUsado(Integer.parseInt(rs.getString("horario_usado")));
                arrayHorario.add(horario);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();

        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();

        }
        return arrayHorario;
    }

    public ArrayList<Horario> consultaHorariosRotas(int idItinerario, String horarioSaida) {
        ArrayList<Horario> arraylist = new ArrayList<Horario>();
        BancoDados banco = new BancoDados();
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT horarioId FROM Horario INNER JOIN RotaItinerario ON (Horario_RotaItinerarioId = RotaItinerarioId) INNER JOIN Itinerario ON (RotaItinerario_ItinerarioId = ItinerarioId) WHERE ItinerarioId=" + idItinerario + " AND horarioSaida = '" + horarioSaida + "'";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int idHorario = rs.getInt("horarioId");
            System.out.println("idHorario " + idHorario);
            int horarioIdAux = idHorario;
            System.out.println("idHorarioAux " + horarioIdAux);
            int destinoFinal = descobreCidadeDestinoFinal(idItinerario);
            int cidadeIntermediaria = descobreCidadeDestino(idHorario);
            System.out.println("destino final " + destinoFinal);
            System.out.println("intermediario " + cidadeIntermediaria);
            if (cidadeIntermediaria == destinoFinal) {
                System.out.println("entrou no if");
                sql = "SELECT * FROM Horario WHERE HorarioId = " + horarioIdAux;
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Horario horario = new Horario();
                    horario.setHorario_rotaItinerarioId(Integer.parseInt(rs.getString("horario_RotaItinerarioId")));
                    horario.setHorarioId(Integer.parseInt(rs.getString("horarioId")));
                    horario.setHorarioDiaId(Integer.parseInt(rs.getString("horarioDiaId")));
                    horario.setHorarioSaida(rs.getString("horarioSaida"));
                    horario.setHorarioChegada(rs.getString("horarioChegada"));
                    horario.setHorarioPreco(Double.parseDouble(rs.getString("horarioPreco")));
                    horario.setHorario_motoristaId(Integer.parseInt(rs.getString("horario_MotoristaId")));
                    horario.setHorario_onibusId(Integer.parseInt(rs.getString("horario_OnibusId")));
                    horario.setHorarioUsado(Integer.parseInt(rs.getString("horario_usado")));
                    horario.setHorarioPreco(rs.getDouble("horarioPreco"));
                    horario.setHorarioSaida(rs.getString("horarioSaida"));
                    arraylist.add(horario);
                }
            } else {
                while (cidadeIntermediaria != destinoFinal) {
                    sql = "SELECT * FROM Horario WHERE HorarioId = " + horarioIdAux;
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        Horario horario = new Horario();
                        horario.setHorario_rotaItinerarioId(Integer.parseInt(rs.getString("horario_RotaItinerarioId")));
                        horario.setHorarioId(Integer.parseInt(rs.getString("horarioId")));
                        horario.setHorarioDiaId(Integer.parseInt(rs.getString("horarioDiaId")));
                        horario.setHorarioSaida(rs.getString("horarioSaida"));
                        horario.setHorarioChegada(rs.getString("horarioChegada"));
                        horario.setHorarioPreco(Double.parseDouble(rs.getString("horarioPreco")));
                        horario.setHorario_motoristaId(Integer.parseInt(rs.getString("horario_MotoristaId")));
                        horario.setHorario_onibusId(Integer.parseInt(rs.getString("horario_OnibusId")));
                        horario.setHorarioUsado(Integer.parseInt(rs.getString("horario_usado")));
                        horario.setHorarioPreco(rs.getDouble("horarioPreco"));
                        horario.setHorarioSaida(rs.getString("horarioSaida"));
                        arraylist.add(horario);
                    }
                    horarioIdAux++;
                    System.out.println("horarioAux++ " + horarioIdAux);
                    cidadeIntermediaria = descobreCidadeDestino(horarioIdAux);
                }
                sql = "SELECT * FROM Horario WHERE HorarioId = " + horarioIdAux;
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Horario horario = new Horario();
                    horario.setHorario_rotaItinerarioId(Integer.parseInt(rs.getString("horario_RotaItinerarioId")));
                    horario.setHorarioId(Integer.parseInt(rs.getString("horarioId")));
                    horario.setHorarioDiaId(Integer.parseInt(rs.getString("horarioDiaId")));
                    horario.setHorarioSaida(rs.getString("horarioSaida"));
                    horario.setHorarioChegada(rs.getString("horarioChegada"));
                    horario.setHorarioPreco(Double.parseDouble(rs.getString("horarioPreco")));
                    horario.setHorario_motoristaId(Integer.parseInt(rs.getString("horario_MotoristaId")));
                    horario.setHorario_onibusId(Integer.parseInt(rs.getString("horario_OnibusId")));
                    horario.setHorarioUsado(Integer.parseInt(rs.getString("horario_usado")));
                    horario.setHorarioPreco(rs.getDouble("horarioPreco"));
                    horario.setHorarioSaida(rs.getString("horarioSaida"));
                    arraylist.add(horario);
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Nao foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return arraylist;
    }

    public int calculaTotalCidadesItinerario(int id) {
        BancoDados banco = new BancoDados();
        int resultado = 0;
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT MAX(RotaItinerarioOrdem) from RotaItinerario where RotaItinerario_ItinerarioId = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            resultado = rs.getInt("MAX(RotaItinerarioOrdem)");
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return resultado;
    }

    public int descobreCidadeDestino(int horarioId) {
        BancoDados banco = new BancoDados();
        int cidadeDestino = 0;
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "SELECT Rota_CidadeDestino FROM Rota, RotaItinerario, Horario WHERE RotaId = RotaItinerario_RotaId AND RotaItinerarioId = Horario_RotaItinerarioId AND HorarioId = " + horarioId + "";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                cidadeDestino = rs.getInt("Rota_CidadeDestino");
                System.out.println("Destino: " + cidadeDestino);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Nao foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return cidadeDestino;
    }

    public int descobreCidadeDestinoFinal(int id) {
        BancoDados banco = new BancoDados();
        int cidadeDestino = 0;
        try {
            Class.forName(banco.getDriver());
            Connection conn = DriverManager.getConnection(banco.getStr_conn(), banco.getUsuario(), banco.getSenha());
            Statement stmt = conn.createStatement();
            String sql = "select cidadeId from Cidade INNER JOIN Itinerario ON (cidadeId = itinerario_cidadeDestino) where itinerarioId = " + id + "";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                cidadeDestino = rs.getInt("cidadeId");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Nao foi possivel carregar o driver.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problema com SQL.");
            ex.printStackTrace();
        }
        return cidadeDestino;
    }
}
