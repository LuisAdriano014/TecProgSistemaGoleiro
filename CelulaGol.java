package Prova01;

public class CelulaGol {
	
	private int posicaoX, posicaoY;
	private int quadrante;
	private String local;
	
	//MÉTODOS CALCULATIVOS  - MAPEAR AS POSIÇÃO DA IMAGEM E VERIFICAR O QUADRANTE DO CHUTE E DEFESA
	
	public void mapearPosicoes() {
		
		String status = "G"; //GOL
		
		for (int i = 0; i <= 8; i++) {
			if (posicaoX == i && posicaoY == 0) {
				status = "F"; //FORA ESQUERDA
			}
			if (posicaoX == i && posicaoY == 15) {
				status = "F"; //FORA DIREITA
			}
		}
		
		for (int i = 0; i <= 15; i++) {
			if (posicaoX == 0 && posicaoY == i) {
				status = "F"; //FORA CIMA
			}
		}
		
		for (int i = 1; i <= 8; i++) {
			if (posicaoX == i && posicaoY == 1) {
				status = "T"; //TRAVE ESQUERDO
			}
			if (posicaoX == i && posicaoY == 14) {
				status = "T"; //TRAVE DIREITA
			}
		}
		
		for (int i = 1; i <= 14; i++) {
			if (posicaoX == 1 && posicaoY == i) {
				status = "T"; //TRAVE CENTRAL
			}
		}
		
		if (status.equals("G")) {
			if (posicaoX == 2 && posicaoY == 2) {
				status = "A"; //ANGULO ESQUERDO
			}
			if (posicaoX == 2 && posicaoY == 13) {
				status = "A"; //ANGULO DIREITO
			}
		}
		
		this.local = status;
		
	}
	
	public void verificarQuadrante() {
		int quadrante = 4;
		if (posicaoX <= 3 && posicaoY <= 7) {
			quadrante = 1;
		} else if (posicaoX <= 3 && posicaoY > 7) {
			quadrante = 2;
		} else if (posicaoX > 3 && posicaoY <= 7) {
			quadrante = 3;
		}
		this.quadrante = quadrante;
	}
	
	//METÓDOS COMUNS - SET E GET

	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}
	
	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}
	
	public int getPosicaoX() {
		return this.posicaoX;
	}
	
	public int getPosicaoY() {
		return this.posicaoY;
	}
	
	public int getQuadrante() {
		return quadrante;
	}
	
	public String getLocal() {
		return local;
	}

}
