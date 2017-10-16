package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.RestauranteDao;
import model.Restaurante;

public class Console {
	
	private Scanner s = new Scanner(System.in);
	
	private RestauranteDao dao;
	
	public Console() {
		menu();
	}

	private void menu() {
		System.out.println("-----------------------------------------------");
		System.out.println("|        ESCOLHA UMA DAS OPÇÕES ABAIXO        |");
		System.out.println("| 1 -        CADASTRA RESTAURANTE             |");
		System.out.println("| 2 -        EDITAR RESTAURANTE               |");
		System.out.println("| 3 -   LISTA RESTAURANTES CADASTRADOS        |");
		System.out.println("|---------------------------------------------|");
		
		String s1 = s.nextLine();
		escolha(s1);
	}
	
	private void escolha(String s1){
		
		switch (s1) {
		case "1":
			dao.insert(addRestaurante());
			System.out.println();
			menu();
			break;
		case "2":
			editar();
			System.out.println("");
			menu();
			break;
		case "3":
			listarRestaurantes(dao.select());
			System.out.println("");
			menu();
			break;
		default:
			System.out.println(" MENU INVALIDO \n");
			System.out.println("");
			menu();
		}
	}

	private void editar() {
		
		System.out.println("INFORME O CNPJ QUE DESEJA ALTERAR: ");
		String cnpj = s.nextLine();
		
		if (dao.verificar(cnpj)) {
			
			System.out.println("INFORME O NOME: ");
			String nome = s.nextLine();
			System.out.println("INFORME O ENDEREÇO: ");
			String endereco = s.nextLine();
			System.out.println("INFORME O TELEFONE: ");
			String tel = s.nextLine();
			dao.update(new Restaurante(cnpj, nome, endereco, tel, null)); 
		}
		
		System.out.println("Esse CNPJ não esta Cadastrado!!!");
		
	}

	private void listarRestaurantes(ArrayList<Restaurante> list) {
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

	private Restaurante addRestaurante() {
		
		System.out.println("INFORME O CNPJ: ");
		String cnpj = s.nextLine();
		System.out.println("INFORME O NOME: ");
		String nome = s.nextLine();
		System.out.println("INFORME O ENDEREÇO: ");
		String endereco = s.nextLine();
		System.out.println("INFORME O TELEFONE: ");
		String tel = s.nextLine();
		
		return new Restaurante(cnpj, nome, endereco, tel, null);
	}
}
