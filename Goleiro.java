package Prova01;

import java.util.ArrayList;

public class Goleiro {

	private String nome;
	private int id, AAG;
	private int forca, flexibilidade, velocidade, agilidade, coordenacao, equilibrio;
	private ArrayList<Chute> listaDeChutes = new ArrayList<>();
	private int golDeForca = 0;
	
	/* MÉTODO CONSTRUTOR - ADICIONAR OS ATRIBUTOS DO GOLEIRO E CALCULAR O AAG */
	
	public Goleiro(int id, String nome, int velocidade, int flexibilidade, int agilidade, int coordenacao, int forca, int equilibrio){
		
		this.nome = nome;
		this.id = id;
		this.flexibilidade = flexibilidade;
		this.velocidade = velocidade;
		this.agilidade = agilidade;
		this.coordenacao = coordenacao;
		this.forca = forca;
		this.equilibrio = equilibrio;
		this.AAG = ((velocidade * 3) + (flexibilidade * 2) + (agilidade * 3) + (coordenacao * 2) + (forca) + (equilibrio * 2)) / 8;
		listaDeChutes = new ArrayList<Chute>();
	}
	
	/* MÉTODOS COMUNS - GET: “PEGAR” OS ATRIBUTOS DA CLASSE GOLEIRO */
	
	public String getNome(){
		return this.nome;
	}
	
	public int getID(){
		return id;
	}
	
	public int getFlexibilidade(){
		return this.flexibilidade;
	}
	
	public int getVelocidade(){
		return this.flexibilidade;
	}
	
	public int getAAG() {
		return AAG;
	}
	
	public int getAgilidade(){
		return this.agilidade;
	}
	
	public int getCoordenacao(){
		return this.coordenacao;
	}
	
	public int getForca(){
		return this.forca;
	}
	
	public int getEquilibrio(){
		return this.equilibrio;
	}
	
	public ArrayList<Chute> getTotalDeChutes() {
		return listaDeChutes;
	}
	
	public int getGolDeForca() {
		return golDeForca;
	}
	
	/* MÉTODOS CALCULATIVOS - CALCULAR QUANTAS DEFESAS O GOLEIRO REALIZOU E QUANTOS GOLS ELE TOMOU */
	
	public int contarDefesas() {
		int defesas = 0;
		for (Chute ch : listaDeChutes) {
			if (ch.getLocal().equals("Defesa")) {
				defesas++;
			}
		}
		return defesas;
	}
	
	public int contarGols() {
		int gols = 0;
		for (Chute ch : listaDeChutes) {
			if (ch.getLocal().equals("Gol")) {
				gols++;
			}
		}
		return gols;
	}
	
	/* OUTROS METODOS - CALCULAR GOLS DE FORÇA E ADICIONAR A LISTA DE CHUTES */

	public void addGoldeForca() {
		golDeForca++;
	}
	
	public void addChute(Chute ch) {
		listaDeChutes.add(ch);
	}
}
