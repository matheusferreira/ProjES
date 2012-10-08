package entidades;

public class Onibus {
   
    private int onibusId;
    private String onibusPlaca;
    private String onibusModelo;
    private String onibusMarca;
    private int onibusAno;
    private int onibusQtdeAssentos;
    
    public int getOnibusAno() {
        return onibusAno;
    }

    public void setOnibusAno(int ano) {
        this.onibusAno = ano;
    }

    public int getOnibusId() {
        return onibusId;
    }

    public void setOnibusId(int id) {
        this.onibusId = id;
    }

    public String getOnibusMarca() {
        return onibusMarca;
    }

    public void setOnibusMarca(String marca) {
        this.onibusMarca = marca;
    }

    public String getOnibusModelo() {
        return onibusModelo;
    }

    public void setOnibusModelo(String modelo) {
        this.onibusModelo = modelo;
    }

    public String getOnibusPlaca() {
        return onibusPlaca;
    }

    public void setOnibusPlaca(String placa) {
        this.onibusPlaca = placa;
    }

    public int getOnibusQtdeAssentos() {
        return onibusQtdeAssentos;
    }

    public void setOnibusQtdeAssentos(int qtdeAssentos) {
        this.onibusQtdeAssentos = qtdeAssentos;
    }
    
}
