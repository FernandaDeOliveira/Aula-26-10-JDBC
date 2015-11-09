import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {
	public static void main(String[]args){
		
		
		int op=0,id=0;
		String nome;
		Scanner tc= new Scanner(System.in);
		do{
			System.out.println("\n 1- Adicionar pessoa");		
			System.out.println("\n 2- Mostrar pessoa por nome");
			System.out.println("\n 3- Mostrar pessoa por Id");
			System.out.println("\n 4- Remover pessoa por nome");
			System.out.println("\n 5- Remover pessoa por Id");
			System.out.println("\n 6- Atualizar por nome");
			System.out.println("\n 7- Listar todos*");			
			System.out.println("\n 8- quantidade de elementos no banco*");
			op = tc.nextInt();
			switch (op) {
			case 1:{
				Pessoa p = new Pessoa();
				p.ler();
				p.salvar();	
				
				break;
			}
			case 2:{
				System.out.println("Digite o nome:");
				nome=tc.next();
				  Pessoa busca = new Pessoa();			  
				     if(busca.getByNome(nome)){
				      	 System.out.println(busca.toString());
				   	  
				     }else{
				    	 	System.out.println("não existe este nome");
				     }
				break;
			}				
			case 3:{
				System.out.println("Digite o id");
				id=tc.nextInt();
				  Pessoa busca = new Pessoa();
				     if(busca.getById(id)){
				      	 System.out.println(busca.toString());
				   	  
				     }else{
				    	 	System.out.println("NÃ£o existe este id");
				     }
				break;
			}
			case 4:{				
				System.out.println("Digite o nome");
				nome=tc.next();
				  Pessoa busca = new Pessoa();
				     if(busca.removerNome(nome)){
				      	 System.out.println("Removido com sucesso");
				   	  
				     }else{
				    	 	System.out.println("NÃ£o existe este nome");
				     }
				break;
			}
			case 5:{
				System.out.println("Digite o id");
				id=tc.nextInt();
				  Pessoa busca = new Pessoa();
				     if(busca.removerId(id)){
				      	 System.out.println(busca.toString());
				   	  
				     }else{
				    	 	System.out.println("NÃ£o existe este id");
				     }
				break;
			}
			case 6:{
				System.out.println("Digite o nome que deseja alterar");
				nome=tc.next();			
				  Pessoa busca = new Pessoa();
				     if(busca.getByNome(nome)){
				    	 busca.ler();
				    	 busca.update(nome);
				      	 System.out.println("Alterado com sucesso");
				   	  
				     }else{
				    	 	System.out.println("Não existe este nome");
				     }
				break;
			}
			case 7:{
				Pessoa p=new Pessoa();
				System.out.println(p.getAll());
			}
			case 8:{}
			default:
				break;
			}
			
		}while(op!=9);
		
		
		
	
	     
	   
	
	}
			
	
	
	
	}

