package entidades;

public class Passagem {

	private int passagemId;
	private String passagemData;
	private String passagemClienteCpf;
	private String passagemClienteNome;
	private int passagemNumAssentoComprado;
	private int passagem_horarioId;
        private int passagem_horarioDiaId;
	
	public int getPassagemId() {
		return passagemId;
	}
	
        public void setPassagemId(int id) {
		this.passagemId = id;
	}
        
        public int getPassagem_horarioDiaId() {
		return passagem_horarioDiaId;
	}
	
        public void setPassagem_horarioDiaId(int diaId) {
		this.passagem_horarioDiaId = diaId;
	}
	
        public String getPassagemData() {
		return passagemData;
	}
	
        public void setPassagemData(String data) {
		this.passagemData = data;
	}
	
        public String getPassagemClienteCpf() {
		return passagemClienteCpf;
	}
	
        public void setPassagemClienteCpf(String clienteCpf) {
		this.passagemClienteCpf = clienteCpf;
	}
	
        public String getPassagemClienteNome() {
		return passagemClienteNome;
	}
	
        public void setPassagemClienteNome(String clienteNome) {
		this.passagemClienteNome = clienteNome;
	}
	
        public int getPassagemNumAssentoComprado() {
		return passagemNumAssentoComprado;
	}
	
        public void setPassagemNumAssentoComprado(int assentoComprado) {
		this.passagemNumAssentoComprado = assentoComprado;
	}
	
        public int getPassagem_horarioId() {
		return passagem_horarioId;
	}
	
        public void setPassagem_horarioId(int horario) {
		this.passagem_horarioId = horario;
	}
	
}
