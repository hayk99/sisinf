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
	private static String findByIdQuery = "SELECT * FROM usuario WHERE id = ?";
	private static String findAll = "SELECT * FROM usuario";
	
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
				result = new UsuarioVO(rs.getString("id"), rs.getString("passwd"), rs.getString("name"));
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
}
