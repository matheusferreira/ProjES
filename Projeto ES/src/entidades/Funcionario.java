package entidades;

public class Funcionario {

    private int funcionarioId;
    private String funcionarioNome;
    private String funcionarioCpf;
    private String funcionarioSenha;
    private String funcionarioEmail;
    private int funcionarioAcesso; //0 funcionario normal, 1 funcionario adm

    public int getFuncionarioAcesso() {
        return funcionarioAcesso;
    }

    public void setFuncionarioAcesso(int acesso) {
        this.funcionarioAcesso = acesso;
    }

    public String getFuncionarioCpf() {
        return funcionarioCpf;
    }

    public void setFuncionarioCpf(String cpf) {
        this.funcionarioCpf = cpf;
    }

    public String getFuncionarioEmail() {
        return funcionarioEmail;
    }

    public void setFuncionarioEmail(String email) {
        this.funcionarioEmail = email;
    }

    public String getFuncionarioSenha() {
        return funcionarioSenha;
    }

    public void setFuncionarioSenha(String senha) {
        this.funcionarioSenha = senha;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int id) {
        this.funcionarioId = id;
    }

    public String getFuncionarioNome() {
        return funcionarioNome;
    }

    public void setFuncionarioNome(String nome) {
        this.funcionarioNome = nome;
    }
    
}

