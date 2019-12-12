package es.unizar.sisinf.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

import es.unizar.sisinf.data.db.ConnectionManager.*;
import es.unizar.sisinf.data.vo.PublicacionVO;
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
	private static String existeCorreo = "SELECT count(*) as cantidad FROM Usuario WHERE correo= ?";
	private static String checkPass = "SELECT count(*) as cantidad FROM Usuario WHERE correo=? AND contrasena=md5(?)";
	private static String insertPost = "INSERT INTO Publicacion (idPublicacion, titulo, contenido, correousuario) VALUES (?,?,?,?)";
	private static String findNews = "SELECT * FROM Publicacion";
	
	private static int contador = 0;
	
	public List<PublicacionVO> getAllNews() {
		List<PublicacionVO> result = new ArrayList<PublicacionVO>();
		try {// Abrimoslaconexión e inicializamoslosparámetros 
			System.out.println("llego aqui");
			Connection conn = ConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(findNews);
			// Ejecutamos la consulta 
			ResultSet rs = ps.executeQuery();
			// Leemos resultados 
			while(rs.next()) {
				PublicacionVO tmp = new PublicacionVO(rs.getInt("idPublicacion"), rs.getString("titulo"), rs.getString("contenido"), rs.getString("correousuario"));
				result.add(tmp); 
			}  
		} catch(SQLException se) {
			se.printStackTrace();  
		} catch(Exception e) {
			e.printStackTrace(System.err); 
		}
		return result;
	}
	public boolean insertPost (String titulo, String body, String mail) {
		boolean exito = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(insertPost);
			ps.setInt(1,contador);
			ps.setString(2,titulo);
			ps.setString(3,body);
			ps.setString(4,mail);
			
			if ( ps.executeUpdate() > 0) {
				System.out.println("METIDO POST CORRECTAMENTE");
				exito = true;
			}
			ConnectionManager.releaseConnection(conn);
			
		}catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return exito;
	}
	
	
	public boolean checkPassword (String correo, String passwd) {
		boolean exito = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(checkPass);
			ps.setString(1,correo);
			ps.setString(2,passwd);
			
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				System.out.println(rs.getString("cantidad"));
				int value = rs.getInt("cantidad");
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
	
	
	public boolean existeCorreo (String correo) {
		boolean exito = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(existeCorreo);
			ps.setString(1,correo);
			
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				int value = rs.getInt("cantidad");
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
	
	public boolean existeUsuario (String name) {
		boolean exito = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(existeUser);
			ps.setString(1,name);

			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				int value = rs.getInt("cantidad");
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
