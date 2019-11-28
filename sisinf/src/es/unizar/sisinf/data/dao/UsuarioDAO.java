package es.unizar.sisinf.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.unizar.sisinf.data.db.ConnectionManager.*;
import es.unizar.sisinf.data.vo.UsuarioVO;

/**
 * Clse DAO de gestión de objetos usuario
 * @author hayk
 *
 */
public class UsuarioDAO {
	private static String findByIdQuery = "SELECT * FROM Usuario WHERE nombre = ?";
	private static String findAll = "SELECT * FROM Usuario";
	private static String insertUser = "INSERT INTO Usuario (nombre, contrasena, correo) VALUES (?,MD5(?),?)";
	private static String existeUser = "SELECT count(*) as cantidad FROM Usuario WHERE nombre= ?";
	
	/**
	 * Busca un registrod en la tabla DEMO por ID
	 * @param id Identificador del regsitro buscado
	 * @return Objeto DemoVO con el identificador buscado, o null si no se encuentra
	 */
	public boolean existeUsuario (String name) {
		boolean exito = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(existeUser);
			ps.setString(1,name);
			System.out.println("vamos a ver si existe");
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				System.out.println("entro if");
				int value = rs.getInt("cantidad");
				System.out.println("despues get");
				if (value > 0) {
					exito = true;
				}
			}
		}catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return exito;
		
	}
	public void insertUser (UsuarioVO user) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(insertUser);
			ps.setString(1,user.getNickname());
			ps.setString(2,user.getPasswd());
			ps.setString(3,user.getEmail());
			
			if ( ps.executeUpdate() > 0) {
				System.out.println("REGISTRADO CORRECTAMENTE");
			}
			
		}catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	public UsuarioVO findById (int id) {
		
		UsuarioVO result = null;
		
		try {
			//Abrimos la conexión e inicializamos los parámetros
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(findByIdQuery);
			ps.setInt(1,id);
			
			//Ejecutamos la consulta
			ResultSet rs = ps.executeQuery();
			
			//Leemos resultados
			if (rs.first()) {
				result = new UsuarioVO(rs.getString("nombre"), rs.getString("contrasena"), rs.getString("correo"));
			}
			else {
				result = null;
			}
			ConnectionManager.releaseConnection(conn);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return result;
	}
	/**
	 * Devuelvetodoslosregistrosdelatabla DEMO 
	 * @returnListadetodoslosregistrosdelatabla DEMO 
	 */
	public List<UsuarioVO> findAll(){ 
		List<UsuarioVO> result = new ArrayList<UsuarioVO>();
		try {// Abrimoslaconexión e inicializamoslosparámetros 
			Connection conn = ConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(findAll);
			// Ejecutamos la consulta 
			ResultSet rs = ps.executeQuery();
			// Leemos resultados 
			while(rs.next()) {
				UsuarioVO tmp = new UsuarioVO(rs.getString("nombre"), rs.getString("contrasena"), rs.getString("correo"));
				result.add(tmp); 
			}  
			ConnectionManager.releaseConnection(conn); 
		} catch(SQLException se) {
			se.printStackTrace();  
		} catch(Exception e) {
			e.printStackTrace(System.err); 
		}
		return result;
	}
}
