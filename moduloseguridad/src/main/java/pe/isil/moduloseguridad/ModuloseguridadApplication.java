package pe.isil.moduloseguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class ModuloseguridadApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ModuloseguridadApplication.class, args);

		//Cargar driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		//Crear conexión
		Connection conexion = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/moduloseg2", "root", "root");


		//Statement(conexion);
		//preparedStatement(conexion);
		callableStatement(conexion);
		//Cerrar conexion
		conexion.close();


		}


	public static void Statement(Connection connection) throws Exception{
		//Crear statement
		Statement statement = connection.createStatement();

		//Ejecutar sentencia
		int affectedRows = statement.executeUpdate("DELETE FROM USUARIOS where id=2");
		System.out.println("Filas afectadas:" + affectedRows);


	}
	public static void preparedStatement(Connection connection) throws Exception{
		//Crear statement
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USUARIOS SET name=? Where id=?");
		preparedStatement.setString(1,"Luis");
		preparedStatement.setInt(2,2);



		int affectedRows = preparedStatement.executeUpdate();
		System.out.println("Filas afectadas:" + affectedRows);
		ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM USUARIOS");
		while (resultSet.next()) {
			System.out.println(resultSet.getString("name"));
		}

	}

	public static void callableStatement(Connection connection) throws Exception{

		CallableStatement cs=connection.prepareCall("{call leerUsuarios()}");
		ResultSet rs = cs.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("name")+" "+
					rs.getString("lastname")+" "+
					rs.getString("username")+" "+
					rs.getString("pass"));
		}
	}
}

