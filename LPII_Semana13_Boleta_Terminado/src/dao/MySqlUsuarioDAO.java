package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Distrito;
import entidad.Menu;
import entidad.Usuario;
import interfaces.UsuarioDAO;
import utils.MysqlDBConexion;

public class MySqlUsuarioDAO implements UsuarioDAO {

	@Override
	public Usuario iniciarSesion(String login, String clave) {
		Usuario lista=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="SELECT cod_usu,nom_usu,ape_usu from tb_usuario where "+
					   "log_usu=? and pas_usu=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, login);
			pstm.setString(2, clave);
			rs=pstm.executeQuery();
			while(rs.next()){
				lista=new Usuario();
				lista.setCodigo(rs.getInt(1));
				lista.setNombre(rs.getString(2));
				lista.setApellido(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public List<Menu> listaMenu(int codUsuario) {
		List<Menu> lista=new ArrayList<Menu>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="select a.cod_men,m.des_men,m.url_men from "+ 
						"tb_acceso a join tb_menu m on "+ 
						"a.cod_men=m.cod_men where a.cod_usu=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codUsuario);
			rs=pstm.executeQuery();
			while(rs.next()){
				Menu m=new Menu();
				m.setCodigo(rs.getInt(1));
				m.setDescripcion(rs.getString(2));
				m.setUrl(rs.getString(3));
				lista.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
		
		
	}

}
