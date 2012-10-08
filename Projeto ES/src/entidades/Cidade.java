package entidades;

public class Cidade {

    private int cidadeId;
    private String cidadeNome;
    private int cidade_estadoId;
    
    public int getCidade_estadoId() {
        return cidade_estadoId;
    }

    public void setCidade_estadoId(int estado) {
        this.cidade_estadoId = estado;
    }

    public int getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(int id) {
        this.cidadeId = id;
    }

    public String getCidadeNome() {
        return cidadeNome;
    }

    public void setCidadeNome(String nome) {
        this.cidadeNome = nome;
    }
    
}
