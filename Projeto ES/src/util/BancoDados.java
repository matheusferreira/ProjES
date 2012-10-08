package util;

public class BancoDados {

    private String driver = "com.mysql.jdbc.Driver";
    private String banco = "projES";
    private String host = "localhost";
    private String str_conn = "jdbc:mysql://" + host + ":3306/" + banco; //3311
    private String usuario = "root";
    private String senha = "root";

    public String getBanco() {
        return banco;
    }

    public String getDriver() {
        return driver;
    }

    public String getHost() {
        return host;
    }

    public String getSenha() {
        return senha;
    }

    public String getStr_conn() {
        return str_conn;
    }

    public String getUsuario() {
        return usuario;
    }
}
