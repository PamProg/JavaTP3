package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	static String[][] pizzas;
	static Scanner input;
	
	public static void main(String[] args) {
		
		pizzas = new String[100][4];
		initPizzas();
		
		input = new Scanner(System.in);
		
		int response = -1;
		
		do {
			displayMenu();
			
			response = input.nextInt();
			
			switch (response) {
				case 1: 
					System.out.println("Liste des pizzas"); 
					displayPizzas();
					break; 
				case 2: 
					System.out.println("Ajout d'une nouvelle pizza"); 
					addPizza();
					break; 
				case 3: 
					System.out.println("Mise à jour d'une pizza");
					displayPizzas();
					break; 
				case 4: 
					System.out.println("Suppression d'une pizza");
					break; 
				case 99: 
					System.out.println("Aurevoir ♪");
					break; 
//				default:
//					break;
			}
		} while (response != 99);
		
		input.close();
	}
	
	private static void initPizzas() {
		pizzas[0] = new String[]{"0", "PEP", "Pépéroni", "12.50"};
		pizzas[1] = new String[]{"1", "MAR", "Margherita", "14.00"};
		pizzas[2] = new String[]{"2", "REI", "LA Reine", "11.50"};
		pizzas[3] = new String[]{"3", "FRO", "La 4 fromages", "12.00"};
		pizzas[4] = new String[]{"4", "CAN", "La cannibale", "12.50"};
		pizzas[5] = new String[]{"5", "SAV", "La savoyarde", "13.00"};
		pizzas[6] = new String[]{"6", "ORI", "L'orientale", "13.50"};
		pizzas[7] = new String[]{"7", "IND", "L'indienne", "14.00"};
	}

	private static void addPizza() {
		
		String codeString;
		String nomString;
		String prixString;
		
		System.out.println("Veuillez saisir le code");
		codeString = input.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		nomString = input.next();
		System.out.println("Veuillez saisir le prix");
		prixString = input.next();
		
		int nbPizzas = 0;
		for(int i=0 ; i<pizzas.length ; i++) {
			if(pizzas[i][0] != null) {
				nbPizzas++;
			}
		}
		
		pizzas[nbPizzas] = new String[]{String.valueOf(nbPizzas),
										codeString,
										nomString,
										prixString};
		
	}

	private static void displayPizzas() {
		for(String[] s : pizzas) {
			if(s[0] != null) {
				System.out.println(s[1] + " -> " + s[2] + " (" + s[3] + " €)");
			}
		}
	}

	public static void displayMenu() {
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}

}
