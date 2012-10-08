package entidades;

public class Horario implements Cloneable {

    private int horarioId;
    private int horarioDiaId;
    private int horario_rotaItinerarioId;
    private String horarioSaida;
    private String horarioChegada;
    private double horarioPreco; //DECIMAL NOT NULL,
    private int horario_motoristaId;
    private int horario_onibusId;
    private int horarioUsado;

    public int getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(int horarioId) {
        this.horarioId = horarioId;
    }

    public int getHorarioDiaId() {
        return horarioDiaId;
    }

    public void setHorarioDiaId(int horarioDiaId) {
        this.horarioDiaId = horarioDiaId;
    }

    public int getHorario_rotaItinerarioId() {
        return horario_rotaItinerarioId;
    }

    public void setHorario_rotaItinerarioId(int horario_rotaItinerarioId) {
        this.horario_rotaItinerarioId = horario_rotaItinerarioId;
    }

    public String getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public String getHorarioChegada() {
        return horarioChegada;
    }

    public void setHorarioChegada(String horarioChegada) {
        this.horarioChegada = horarioChegada;
    }

    public double getHorarioPreco() {
        return horarioPreco;
    }

    public void setHorarioPreco(double horarioPreco) {
        this.horarioPreco = horarioPreco;
    }

    public int getHorario_motoristaId() {
        return horario_motoristaId;
    }

    public void setHorario_motoristaId(int horario_motoristaId) {
        this.horario_motoristaId = horario_motoristaId;
    }

    public int getHorario_onibusId() {
        return horario_onibusId;
    }

    public void setHorario_onibusId(int horario_onibusId) {
        this.horario_onibusId = horario_onibusId;
    }

    public int getHorarioUsado() {
        return horarioUsado;
    }

    public void setHorarioUsado(int horarioUsado) {
        this.horarioUsado = horarioUsado;
    }

}
