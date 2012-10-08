package entidades;

public class Itinerario {

    private int itinerarioId;
    private int itinerario_cidadeOrigemId;
    private int itinerario_cidadeDestinoId;
    private String itinerario_cidadeOrigem;
    private String itinerario_cidadeDestino;

    public int getItinerarioId() {
        return itinerarioId;
    }

    public void setItinerarioId(int itinerarioId) {
        this.itinerarioId = itinerarioId;
    }

    public int getItinerario_cidadeOrigemId() {
        return itinerario_cidadeOrigemId;
    }

    public void setItinerario_cidadeOrigemId(int itinerario_cidadeOrigemId) {
        this.itinerario_cidadeOrigemId = itinerario_cidadeOrigemId;
    }

    public int getItinerario_cidadeDestinoId() {
        return itinerario_cidadeDestinoId;
    }

    public void setItinerario_cidadeDestinoId(int itinerario_cidadeDestinoId) {
        this.itinerario_cidadeDestinoId = itinerario_cidadeDestinoId;
    }

    public String getItinerario_cidadeOrigem() {
        return itinerario_cidadeOrigem;
    }

    public void setItinerario_cidadeOrigem(String itinerario_cidadeOrigem) {
        this.itinerario_cidadeOrigem = itinerario_cidadeOrigem;
    }

    public String getItinerario_cidadeDestino() {
        return itinerario_cidadeDestino;
    }

    public void setItinerario_cidadeDestino(String itinerario_cidadeDestino) {
        this.itinerario_cidadeDestino = itinerario_cidadeDestino;
    }
}
