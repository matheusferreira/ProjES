package entidades;

public class Rota {
    
	private int rotaId;
	private int rota_cidadeOrigemId;
	private int rota_cidadeDestinoId;
	private String rota_cidadeOrigem;
	private String rota_cidadeDestino;
	private String rotaDuracao;	
	
	public int getRotaId() {
		return rotaId;
	}
	
        public void setRotaId(int id) {
		this.rotaId = id;
	}
	
        public int getRota_cidadeOrigemId() {
		return rota_cidadeOrigemId;
	}
	
        public void setRota_cidadeOrigemId(int rota_cidadeOrigemId) {
		this.rota_cidadeOrigemId = rota_cidadeOrigemId;
	}
	
        public int getRota_cidadeDestinoId() {
		return rota_cidadeDestinoId;
	}
	
        public void setRota_cidadeDestinoId(int rota_cidadeDestinoId) {
		this.rota_cidadeDestinoId = rota_cidadeDestinoId;
	}
	
        public String getRota_cidadeOrigem() {
		return rota_cidadeOrigem;
	}
	
        public void setRota_cidadeOrigem(String rota_cidadeOrigem) {
		this.rota_cidadeOrigem = rota_cidadeOrigem;
	}
	
        public String getRota_cidadeDestino() {
		return rota_cidadeDestino;
	}
	
        public void setRota_cidadeDestino(String rota_cidadeDestino) {
		this.rota_cidadeDestino = rota_cidadeDestino;
	}
	
        public String getRotaDuracao() {
		return rotaDuracao;
	}
	
        public void setRotaDuracao(String rotaDuracao) {
		this.rotaDuracao = rotaDuracao;
	}
	
}
