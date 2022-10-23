package Prova01;

import java.util.ArrayList;

public class Selecao {
	
	private int id;
	private ArrayList<Goleiro> listaDeGoleiros = new ArrayList<>();
	
	/* METODO CONSTRUTOR - INFORMAR O ID DA SELEÇÃO */
	
	public Selecao(int id) {
		
		this.id = id;
		
	}
	
	/* METODOS COMUNS - SET E GET */
	
	public ArrayList<Goleiro> getGoleiros(){
		
		return this.listaDeGoleiros;
		
	}
	
	public int getID() {
		
		return id;
	}

	/* OUTROS MÉTODOS */
	
	public void addGoleiro(Goleiro goleiro) {
		
		this.listaDeGoleiros.add(goleiro);
		
	}
}
