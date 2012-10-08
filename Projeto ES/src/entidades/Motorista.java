package entidades;

public class Motorista {
    
    private int motoristaId;
    private String motoristaNome;
    private String motoristaRg;
    private String motoristaCpf;
    private String motoristaEnd;
    private String motoristaTel;
    private String motoristaEmail;

    public String getMotoristaCpf() {
        return motoristaCpf;
    }

    public void setMotoristaCpf(String cpf) {
        this.motoristaCpf = cpf;
    }

    public String getMotoristaEmail() {
        return motoristaEmail;
    }

    public void setMotoristaEmail(String email) {
        this.motoristaEmail = email;
    }

    public String getMotoristaEnd() {
        return motoristaEnd;
    }

    public void setMotoristaEnd(String endereco) {
        this.motoristaEnd = endereco;
    }

    public int getMotoristaId() {
        return motoristaId;
    }

    public void setMotoristaId(int id) {
        this.motoristaId = id;
    }

    public String getMotoristaNome() {
        return motoristaNome;
    }

    public void setMotoristaNome(String nome) {
        this.motoristaNome = nome;
    }

    public String getMotoristaRg() {
        return motoristaRg;
    }

    public void setMotoristaRg(String rg) {
        this.motoristaRg = rg;
    }

    public String getMotoristaTel() {
        return motoristaTel;
    }

    public void setMotoristaTel(String telefone) {
        this.motoristaTel = telefone;
    }
    
}
