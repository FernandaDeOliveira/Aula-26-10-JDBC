import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	
	private String url="jdbc:mysql://localhost/alg3";
	private String user="root";
	private String password="vertrigo";
	public Connection conexao=null;
	public String msg;
	public boolean con; 
 
	
	public  Conexao(){		
		 this.url="jdbc:mysql://localhost/alg3";
		this.user="root";
		this.password="vertrigo";
		this.abrir();
	}
	public Conexao(String u,String user, String pasw){
	    this.url=u;
		this.user=user;
		this.password=pasw;
		this.abrir();
	}

	public boolean abrir(){
		 try {
				this.conexao = DriverManager.getConnection(this.url,this.user, this.password);
				this.con =true;	
				this.msg="Conectado";
			 } catch (SQLException e) {
				// TODO Auto-generated catch block
				 this.con=false;
				 this.msg=e.getMessage();
				
			}
			return this.con;	
	}
	
	public boolean fechar(){
		try {
			this.conexao.close();
			return this.conexao.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	

}
