package Prova01;

public class Chute {
	
	private int id, forca, quadrante, posicaoX, posicaoY;
	private String local;
	
	/* MÉTODO CONSTRUTORES - RECEBER TODOS ATRIBUTOS DO CHUTE*/
	
	public Chute(int id, int forca, int quadrante, int posicaoX, int posicaoY) {
		
		this.id = id;
		this.forca = forca;
		this.quadrante = quadrante;
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		local = null;
		
	}
	
	public Chute(Chute ch) {
		
		this.id = ch.getID();
		this.forca = ch.getForca();
		this.quadrante = ch.getQuadrante();
		this.posicaoX = ch.getPosicaoX();
		this.posicaoY = ch.getPosicaoY();
		local = null;
		
	}
	
	/* MÉTODO AUXILIAR - MAPEAR POSIÇÕES DA IMAGEM */
	
	public void mapearPosicoes() {
		
		String status = "G";
		
		for (int i = 0; i <= 8; i++) {
			if (posicaoX == i && posicaoY == 0) {
				status = "F";
			}
			if (posicaoX == i && posicaoY == 15) {
				status = "F";
			}
		}
		
		for (int i = 0; i <= 15; i++) {
			if (posicaoX == 0 && posicaoY == i) {
				status = "F";
			}
		}
		
		for (int i = 1; i <= 8; i++) {
			if (posicaoX == i && posicaoY == 1) {
				status = "T";
			}
			if (posicaoX == i && posicaoY == 14) {
				status = "T";
			}
		}
		
		for (int i = 1; i <= 14; i++) {
			if (posicaoX == 1 && posicaoY == i) {
				status = "T";
			}
		}
		
		if (status.equals("GG")) {
			if (posicaoX == 2 && posicaoY == 2) {
				status = "A";
			}
			if (posicaoX == 2 && posicaoY == 13) {
				status = "A";
			}
		}
		
		this.local = status;
		
	}

	/* METODOS COMUNS - SET E GET */

	public int getID(){
		return id;
	}
	
	public int getForca(){
		return forca;
	}
	
	public int getQuadrante(){
		return quadrante;
	}
	
	public int getPosicaoX(){
		return this.posicaoX;
	}
	
	public int getPosicaoY(){
		return this.posicaoY;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal (String local) {
		this.local = local;
	}
}
