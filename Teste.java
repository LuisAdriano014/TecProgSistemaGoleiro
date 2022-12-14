package Prova01;

import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
	
	public static GolQuest criarGol() {
		
		GolQuest golaux = new GolQuest();
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 16; j++) {
				CelulaGol celula = new CelulaGol();
				celula.setPosicaoX(i);
				celula.setPosicaoY(j);
				celula.mapearPosicoes();
				celula.verificarQuadrante();
				golaux.addCelula(celula);
			}
		}
		
		carregarSelecao(golaux);
		carregarChutes(golaux);
		
		return golaux;
		
	}

	public static ArrayList<Goleiro> carregarGoleiros() {
		
		ArrayList<Goleiro> goleiros = new ArrayList<>();
		
		goleiros.add(new Goleiro(1, "Pratik Skaggs", 5, 7, 8, 9, 6, 6));
		goleiros.add(new Goleiro(2, "Uehudah Hack", 9, 6, 8, 8, 7, 10));
		goleiros.add(new Goleiro(3, "Edison Drye", 5, 8, 5, 8, 10, 7));
		goleiros.add(new Goleiro(4, "Ajani Harding", 6, 6, 5, 8, 7, 6));
		goleiros.add(new Goleiro(5, "Orazio Hart", 5, 8, 7, 9, 9, 10));
		goleiros.add(new Goleiro(6, "Tristan Karns", 9, 7, 10, 7, 7, 6));
		goleiros.add(new Goleiro(7, "Niven Glaser", 10, 9, 7, 6, 5, 8));
		goleiros.add(new Goleiro(8, "Derwyn Devers", 10, 7, 9, 5, 9, 5));
		goleiros.add(new Goleiro(9, "Tod Phan", 10, 7, 7, 5, 5, 6));
		goleiros.add(new Goleiro(10, "Eddie Hulse", 7, 6, 5, 9, 7, 5));
		goleiros.add(new Goleiro(11, "Welford Yepez", 5, 8, 8, 7, 7, 8));
		goleiros.add(new Goleiro(12, "Rishley Snyder", 6, 5, 6, 5, 7, 6));
		goleiros.add(new Goleiro(13, "Milo Mccurdy", 10, 9, 8, 6, 10, 9));
		goleiros.add(new Goleiro(14, "Carden Justus", 8, 5, 8, 5, 10, 7));
		goleiros.add(new Goleiro(15, "Carlyon Gorby", 8, 5, 8, 8, 8, 6));
		goleiros.add(new Goleiro(16, "Mungo Spangler", 8, 10, 9, 8, 9, 5));
		goleiros.add(new Goleiro(17, "Whitmore Squires", 9, 10, 7, 9, 9, 10));
		goleiros.add(new Goleiro(18, "Pedrog Mccurdy", 8, 5, 10, 5, 7, 7));
		goleiros.add(new Goleiro(19, "Ridgley Leo", 8, 8, 8, 9, 9, 9));
		goleiros.add(new Goleiro(20, "Bolton Tarin", 9, 8, 7, 6, 9, 10));
		goleiros.add(new Goleiro(21, "Edison Loy", 7, 7, 5, 10, 10, 7));
		goleiros.add(new Goleiro(22, "Delling Herndon", 7, 5, 5, 8, 9, 9));
		goleiros.add(new Goleiro(23, "Senichi Iorio", 7, 7, 5, 8, 10, 5));
		goleiros.add(new Goleiro(24, "Albin Kerner", 6, 7, 8, 8, 9, 9));
		goleiros.add(new Goleiro(25, "Jivin Justus", 9, 10, 8, 7, 7, 5));
		goleiros.add(new Goleiro(26, "Clement Fleisher", 10, 9, 10, 5, 7, 8));
		
		return goleiros;
		
	}

	
	public static void carregarSelecao(GolQuest golaux) {
		
		ArrayList<Goleiro> aux = carregarGoleiros();
		
		Selecao s1 = new Selecao(01);
		Selecao s2 = new Selecao(02);
		Selecao s3 = new Selecao(03);
		Selecao s4 = new Selecao(04);
		Selecao s5 = new Selecao(05);
		for (int i = 0; i < aux.size(); i++) {
			if (i <= 4) {
				s1.addGoleiro(aux.get(i));
			} else if (i <= 9) {
				s2.addGoleiro(aux.get(i));
			} else if (i <= 14) {
				s3.addGoleiro(aux.get(i));
			} else if (i <= 19) {
				s4.addGoleiro(aux.get(i));
			} else {
				s5.addGoleiro(aux.get(i));
			}
		}
		golaux.addSelecao(s1);
		golaux.addSelecao(s2);
		golaux.addSelecao(s3);
		golaux.addSelecao(s4);
		golaux.addSelecao(s5);

	}

	public static void carregarChutes(GolQuest golaux) {
		
		golaux.addChute(new Chute(1, 2, 1, 4, 7));
		golaux.addChute(new Chute(2, 6, 1, 3, 6));
		golaux.addChute(new Chute(3, 9, 2, 4, 15));
		golaux.addChute(new Chute(4, 5, 4, 6, 11));
		golaux.addChute(new Chute(5, 3, 4, 8, 13));
		golaux.addChute(new Chute(6, 3, 3, 6, 4));
		golaux.addChute(new Chute(7, 4, 4, 5, 8));
		golaux.addChute(new Chute(8, 7, 4, 7, 14));
		golaux.addChute(new Chute(9, 8, 4, 7, 14));
		golaux.addChute(new Chute(10, 4, 4, 6, 12));
		golaux.addChute(new Chute(11, 2, 4, 5, 15));
		golaux.addChute(new Chute(12, 7, 3, 6, 4));
		golaux.addChute(new Chute(13, 3, 3, 8, 2));
		golaux.addChute(new Chute(14, 9, 4, 7, 10));
		golaux.addChute(new Chute(15, 10, 4, 7, 12));
		golaux.addChute(new Chute(16, 5, 1, 4, 2));
		golaux.addChute(new Chute(17, 3, 4, 5, 13));
		golaux.addChute(new Chute(18, 10, 2, 4, 16));
		golaux.addChute(new Chute(19, 10, 4, 5, 16));
		golaux.addChute(new Chute(20, 10, 2, 3, 14));
		golaux.addChute(new Chute(21, 9, 2, 1, 8));
		golaux.addChute(new Chute(22, 4, 4, 8, 16));
		golaux.addChute(new Chute(23, 8, 4, 6, 14));
		golaux.addChute(new Chute(24, 7, 4, 7, 11));
		golaux.addChute(new Chute(25, 6, 1, 0, 3));
		golaux.addChute(new Chute(26, 5, 3, 6, 7));
		golaux.addChute(new Chute(27, 3, 3, 8, 4));
		golaux.addChute(new Chute(28, 4, 3, 6, 7));
		golaux.addChute(new Chute(29, 10, 2, 2, 13));
		golaux.addChute(new Chute(30, 7, 3, 5, 3));

	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		GolQuest gol = criarGol();
		gol.chuteAoGol();
		
		System.out.println(gol.primeiraQuestao());
		System.out.println(gol.segundaQuestao());
		System.out.println(gol.terceiraQuestao());
		System.out.println(gol.quartaQuestao());
		System.out.println(gol.quintaQuestao());
		System.out.println(gol.sextaQuestao());
		System.out.println(gol.setimaQuestao());
		System.out.println(gol.oitavaQuestao());
		System.out.println("\n--> Digite o ID do goleiro: ");
		System.out.println(gol.nonaQuestao(sc.nextInt()));
		System.out.println(gol.decimaQuestao());
		
		sc.close();
	}
}
