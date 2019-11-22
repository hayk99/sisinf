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
	
	/**
	 * Busca un registrod en la tabla DEMO por ID
	 * @param id Identificador del regsitro buscado
	 * @return Objeto DemoVO con el identificador buscado, o null si no se encuentra
	 */
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
