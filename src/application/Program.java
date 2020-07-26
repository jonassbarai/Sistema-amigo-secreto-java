package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);		
		ArrayList<String> participantes = new ArrayList<>();
		
		int op=0;
		do{
			System.out.println("------------------amigo secreto-------------------");
			System.out.println("1- adicionar pessoa");
			System.out.println("2- remover pessoa");
			System.out.println("3- sortear");
			System.out.println("4- sair");
			op = sc.nextInt();
			
			switch(op) {
			case 1:{
				System.out.print("nome do participante: ");
				sc.nextLine();
				String nome = sc.nextLine();			
			
				boolean repetido=false;
				if(!participantes.isEmpty()) {
				for(String p: participantes) {
					if(p.equals(nome)) {
						System.out.println("esse nome ja existe");
						repetido= true;						
					}			
				}
			}	
					if(repetido == false) {
						participantes.add(nome);
					}
					break;
			}
			case 2 :{
				System.out.print("digite o nome que deseja deletar: ");
				sc.nextLine();
				 final String nomeDelete = sc.nextLine();
				participantes.removeIf(n -> n.toUpperCase().equals(nomeDelete.toUpperCase()));
				break;
			}
			case 3 :{
				ArrayList<String> aux = (ArrayList<String>) participantes.clone();				
				Random random = new Random();
				
				do {
					String amigoSecreto = aux.get(random.nextInt(aux.size()));
					String nome = participantes.get(random.nextInt(participantes.size()));
					if(!nome.equals(amigoSecreto)) {
						System.out.println(nome + " , amigo secreto: " + amigoSecreto);
						aux.remove(amigoSecreto);
						participantes.remove(nome);
					}
				}
				while(!aux.isEmpty());			
			}
			break;
		}
		}
		while(op != 4);
		
		
		

		sc.close();
	}	
}