import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pessoa {
	public int id;
	public String nome;
	public int idade;
	
	Scanner tc= new Scanner(System.in);

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
	}
	
	public void ler(){
		System.out.println("Digite o nome");
		nome=tc.nextLine();
		System.out.println("Digite a idade");
		idade=tc.nextInt();
	}
		
	
	public boolean salvar(){
		
		Conexao c = new Conexao();
	 try {		
			String sql = "INSERT INTO pessoa (nome,idade)VALUES(?,?);";
			PreparedStatement comandoSQl = c.conexao.prepareStatement(sql);
			comandoSQl.setString(1, this.nome);
			comandoSQl.setInt(2, this.idade);			
			comandoSQl.execute();			
			comandoSQl.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			c.msg =e.getMessage();
			return false;
		}	
	 
	}
	
	public boolean removerId(int idRemove){
		try {
			Conexao c = new Conexao();
			String sql="DELETE FROM pessoa WHERE id="+idRemove;
			PreparedStatement comandoSql=c.conexao.prepareStatement(sql);
			comandoSql.execute();
			comandoSql.close();
			
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println( e.getMessage());
		}
		return true;
	}
	
	public boolean removerNome(String nomeRemove){
		Conexao c = new Conexao();
		try {
			
			String sql="DELETE FROM pessoa WHERE nome= ?;";
			PreparedStatement comandoSql=c.conexao.prepareStatement(sql);
			comandoSql.setString(1, nomeRemove);
			comandoSql.execute();
			comandoSql.close();
			return true;
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println( e.getMessage());
			return false;
		}
		
	}
	
	public boolean update(String nome){
		Conexao c = new Conexao();
		try {
			
			String sql="UPDATE pessoa SET nome='"+this.nome +"',idade='"+this.idade+"' WHERE nome= ?;";
			PreparedStatement comandoSql=c.conexao.prepareStatement(sql);
			comandoSql.setString(1, nome);
			comandoSql.execute();
			comandoSql.close();
			return true;
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println( e.getMessage());
			return false;
		}
	}

	 public static ArrayList<Pessoa> getAll(){
		 Conexao c = new Conexao();
		 ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		 
		 try {
			 String sql= "SELECT * FROM pessoa;";
			 PreparedStatement comandoSql= c.conexao.prepareStatement(sql);
			 
			 ResultSet rs =comandoSql.executeQuery();
			 while (rs.next()) {
				 Pessoa p = new Pessoa();
				 p.id= rs.getInt("id");
				 p.nome= rs.getString("nome");		
				 p.idade = rs.getInt("idade");
				 lista.add(p);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			c.msg = e.getMessage();
			return null;
		}
		 return lista;
		 
	 }
	 public boolean getById(int id){
		 Conexao c = new Conexao();
		 
		 try {
			 String sql= "SELECT * FROM pessoa WHERE id=?;";
			 PreparedStatement comandoSql= c.conexao.prepareStatement(sql);
			 comandoSql.setInt(1,id);
			 ResultSet rs =comandoSql.executeQuery();
			 while (rs.next()) {
				 this.id= rs.getInt("id");
				 this.nome= rs.getString("nome");		
				 this.idade = rs.getInt("idade");
				 return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			c.msg = e.getMessage();
			return false;
		}
		 return false;
		 
	 }
	 
	public boolean getByNome(String nome){
	 Conexao c = new Conexao();		 
		 try {
			 String sql= "SELECT * FROM pessoa WHERE nome= ?;";
			 PreparedStatement comandoSql= c.conexao.prepareStatement(sql);
			 comandoSql.setString(1, nome);
			 ResultSet rs =comandoSql.executeQuery();
			 while (rs.next()) {
				 this.id= rs.getInt("id");
				 this.nome= rs.getString("nome");		
				 this.idade = rs.getInt("idade");
				 return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			c.msg = e.getMessage();
			return false;
		}
		 return false;
	 }
	 

}
