package Prova01;

import java.util.ArrayList;
import java.util.Random;

public class GolQuest {
	
	/*ATRIBUTOS - ArrayList<tipo_primitivo> descricao_do_array = new ArrayList<>();*/
	
	private ArrayList<CelulaGol> celulas = new ArrayList<>();
	private ArrayList<Chute> chutes = new ArrayList<>();
	private ArrayList<Selecao> selecoes = new ArrayList<>();

	public void chuteAoGol() {
		
	/*METODO PARA SORTEAR A PRIMEIRA POSIÇÃO DA DEFESA DO GOLEIRO (AAG) */
		
	CelulaGol cgaux = new CelulaGol();
		
	for (Selecao selecao : selecoes) {
		for (Goleiro goleiro : selecao.getGoleiros()) {
			for (Chute ch : chutes) {
				cgaux = sortearPosicao(ch);
				verificarGol(cgaux, ch, goleiro);
				}
			}
		}
	
	}

	public void verificarGol(CelulaGol caux, Chute ch, Goleiro goleiro) {
		
	/*METODO PARA VERIFICAR SE O GOLEIRO DEFENDEU, COMPLEMENTAR O METODO ANTERIOR (I)
	  E ANALISAR A SITUAÇÃO FORÇA DO GOLEIRO X CHUTE (II) */
		
	int x = caux.getPosicaoX();
	int y = caux.getPosicaoY();
	int count = 0, somador, n = goleiro.getAAG();
	boolean defesa = false;
	somador = n % 4 == 0 ? (n / 4) - 1 : (n / 4);
	
	Chute aux = new Chute(ch);
	
	do {
		if (count < 4) {
			if (x == ch.getPosicaoX() && y == ch.getPosicaoX()) {
				if (count == 3) { //I
					if (goleiro.getForca() >= ch.getForca()) {
						defesa = true;
					} else { //II
						goleiro.addGoldeForca();
						defesa = false;
					}

				} else if (y == caux.getPosicaoY() + somador) { //I
					if (goleiro.getForca() >= ch.getForca()) {
						defesa = true;
					} else { //II
						goleiro.addGoldeForca();
						defesa = false;
					}
				} else
					defesa = true;

			}
				n--;
				count++;
				x = x > 0 ? x -= 1 : caux.getPosicaoX();
			} else {
				x = caux.getPosicaoX();
				y = y < 15 ? y += 1 : y;
				count = 0;
			}

		} while ((n > 0 && defesa == false));
		if (defesa == true) {
			aux.setLocal("Defesa");
			goleiro.addChute(aux);
		} else {
			aux.setLocal("Gol");
			goleiro.addChute(aux);
		}
	}

	public CelulaGol sortearPosicao(Chute ch) {
		
	/*METODO PARA GERAR POSIÇÃO NO EIXO X, POSIÇÃO NO EIXO Y E GARANTIR QUE O
	  QUADRANTE DO CHUTE É IGUAL AO QUADRANTE DO GOLEIRO */
		
	Random ale = new Random();
		
	CelulaGol caux = new CelulaGol();
	do {
		caux.setPosicaoX(ale.nextInt(8));
		caux.setPosicaoY(ale.nextInt(16));
		caux.verificarQuadrante();
	} while (caux.getQuadrante() != ch.getQuadrante());
		
	return caux;
		
	}

	public String primeiraQuestao() {
		
		double media = 0;
		String total = "----- MEDIA DE DEFESAS - SELEÇÃO -----\n";
		for (Selecao sel : selecoes) {
			int soma = 0;
			for (Goleiro go : sel.getGoleiros()) {
				soma += go.contarDefesas();
			}
			media = (double) soma / sel.getGoleiros().size();
			total += "\nSelecão: " + sel.getID() + "\nMedia: " + String.format("%.1f", media);
			
		}
		
		return total;
		
	}

	public String segundaQuestao() {
		
		String result = "\n----- PONTUACAO DOS GOLEIROS -----\n";
		
		for (Selecao sel : selecoes) {
			result += "\nSelecao: " + sel.getID() + "\n\n";
			int maior = 0;
			String nome = "";
			for (Goleiro gol : sel.getGoleiros()) {
				result += gol.getNome() + "\nDefesas: " + gol.contarDefesas() + "\n";
				if (gol.contarDefesas() > maior) {
					maior = gol.contarDefesas();
					nome = gol.getNome();

				}
			}
			result += "\nGoleiro titular indicado: " + nome + "\n";
		}
		return result;
	}

	
	public String terceiraQuestao() {
		
		String result = "----- MEDIA - GOLS TOMADOS -----\n\n";

		for (Selecao sel : selecoes) {
			int soma = 0;
			double media = 0;
			for (Goleiro gol : sel.getGoleiros()) {
				soma += gol.contarGols();

			}
			media = (double) soma / sel.getGoleiros().size();
			result += "Selecão " + sel.getID() + ": " + String.format("%.1f", media) + "\n";
		}
		return result;
	}

	// Parei aqui!
	
	public String quartaQuestao() {
		int te = 0, td = 0, fora = 0;
		for (Chute ch : chutes) {
			ch.mapearPosicoes();
			if (ch.getLocal().equals("TE"))
				te++;
			if (ch.getLocal().equals("TD"))
				td++;
			if (ch.getLocal().equals("F"))
				fora++;
		}
		String result = "----- LOCAL DOS CHUTES -----\n" + "\nFora: " + fora + "\nTrave do lado esquerdo: " + te + "\nTrave do lado direito: " + td;
		
		return result;
	}
	
	public String quintaQuestao() {
		int angulo = 0;
		for (Chute ch : chutes) {
			ch.mapearPosicoes();
			if (ch.getLocal().equals("A"))
				angulo++;
		}
		String resultado = "\n----- GOLS NO ÂNGULO -----\n" + "\nQuantidade: " + angulo;
		return resultado;
	}

	public String sextaQuestao() {
		int maior = 0, indexSelecao = 0;
		ArrayList<Selecao> aux = selecoes;
		String result = "\n----- MELHORES GOLEIROS -----\n\n";
		for (int i = 0; i < 3; i++) {
			maior = 0;
			for (Selecao sel : aux) {
				for (Goleiro gol : sel.getGoleiros()) {
					if (gol.contarDefesas() > maior) {
						maior = gol.contarDefesas();
						indexSelecao = aux.indexOf(sel);
					}
				}
			}
			result += "Seleção: " + aux.get(indexSelecao).getID() + "\n";
		}
		return result;
	}

	public String setimaQuestao() {
		int soma = 0;
		for (Selecao sel : selecoes) {
			for (Goleiro gol : sel.getGoleiros()) {
				soma += gol.getGolDeForca();
			}
		}
		return "----- GOLS POR FORÇA -----\n" + "\nQuantidade: " + soma;
	}

	public String oitavaQuestao() {
		String result = "\n-----  LISTA DE GOLEIROS -----\n"
				+ "\nNOME - SELEÇÃO - DEFESAS - GOLS TOMADOS - AAG\n";
		for (Selecao sel : selecoes) {
			for (Goleiro gol : sel.getGoleiros()) {
				result += "\n" + gol.getNome() + " - " + sel.getID() + " - " + gol.contarDefesas() + " - "
						+ gol.contarGols() + " - " + gol.getAAG();
			}
		}
		return result;
	}

	public String nonaQuestao(int id) {
		String result = "";
		for (Selecao sel : selecoes) {
			for (Goleiro goleiro : sel.getGoleiros()) {
				if (id == goleiro.getID()) {
					result = "\nGoleiro: " + goleiro.getNome() + "\nQuadrante mais vazado: " + quadranteVazado(goleiro);
				}
			}
		}
		return result;
	}

	public String decimaQuestao() {
		String saida = "\n----- MATRIZES DOS GOLEIROS -----\n\n";
		for (Selecao sel : selecoes) {
			for (Goleiro gol : sel.getGoleiros()) {
				saida += "Goleiro: " + gol.getNome() + "\n\n";
				saida += matrizDoGoleiro(gol) + "\n";
			}
		}
		return saida;
	}

	public String matrizDoGoleiro(Goleiro goleiro) {
		String result = " ";
		int ocorrencias = 0;
		String saida = "";
		ArrayList<Chute> aux = goleiro.getTotalDeChutes();
		for (int i = 0; i < celulas.size(); i++) {
			ocorrencias = 0;
			Chute verify = procurarPosicao(celulas.get(i).getPosicaoX(), celulas.get(i).getPosicaoY(), aux);
			if (verify != null) {
				ocorrencias = ocorrencia(celulas.get(i).getPosicaoX(), celulas.get(i).getPosicaoY(), aux);
				if (verify.getLocal().equals("Gol")) {
					result = (ocorrencias + "*");
				} else
					result = (ocorrencias + "X");
			} else {
				result = (celulas.get(i).getLocal() + " ");
			}
			if (celulas.get(i).getPosicaoY() == 15) {
				result += "\n";
			}
			saida += result;
		}
		return saida;
	}

	//METODOS AUXILIARES - COMPLEMENTAR ALGUMAS QUESTÕES
	
	public int quadranteVazado(Goleiro goleiro) {
		int maior = 0, index = 0;
		int[] vet = new int[4];
		for (Chute ch : goleiro.getTotalDeChutes()) {
			if (ch.getLocal().equals("Gol")) {
				vet[ch.getQuadrante() - 1]++;
			}
		}
		for (int i = 0; i < vet.length; i++) {
			if (vet[i] > maior) {
				maior = vet[i];
				index = i;
			}
		}
		return index + 1;
	}
	
	public int ocorrencia(int x, int y, ArrayList<Chute> totalch) {
		int ocorrencia = 0;
		for (Chute chute : totalch) {
			if (chute.getPosicaoX() == x && chute.getPosicaoY() == y) {
				ocorrencia++;
			}
		}
		return ocorrencia;
	}

	public Chute procurarPosicao(int x, int y, ArrayList<Chute> totalch) {
		for (Chute chute : totalch) {
			if (x == chute.getPosicaoX() && y == chute.getPosicaoY()) {
				return chute;
			}
		}
		return null;
	}
	
	//METODOS COMUNS - SET E GET

	public void addSelecao(Selecao selecao) {
		this.selecoes.add(selecao);
	}

	public void addChute(Chute chute) {
		this.chutes.add(chute);
	}

	public void addCelula(CelulaGol celula) {
		this.celulas.add(celula);
	}

	public ArrayList<CelulaGol> getCelulas() {
		return celulas;
	}

	public ArrayList<Chute> getChutes() {
		return chutes;
	}

	public ArrayList<Selecao> getSelecoes() {
		return selecoes;
	}

}
