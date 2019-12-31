package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Docente;
import interfaces.DocenteDAO;
import utils.MysqlDBConexion;

public class MySqlDocenteDAO implements DocenteDAO {

	@Override
	public int addDocente(Docente doc) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="insert into tb_docente values(null,?,?,?,?,?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1,doc.getNombre());
			pstm.setString(2,doc.getPaterno());
			pstm.setString(3,doc.getMaterno());
			pstm.setString(4,doc.getSexo());
			pstm.setInt(5, doc.getNumHijos());
			pstm.setDouble(6, doc.getSueldo());
			pstm.setString(7, doc.getFecNacimiento());
			pstm.setInt(8, doc.getCodDistrito());
			pstm.setString(9, doc.getDireccion());
			estado=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public int updateDocente(Docente doc) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="update tb_docente set nom_doc=?,pat_doc=?,"+
					    "mat_doc=?,sex_doc=?,num_hijo_doc=?,sue_doc=?, "+
					    "fec_nac=?,cod_dis=?,dir_doc=? where cod_doc=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, doc.getNombre());
			pstm.setString(2, doc.getPaterno());
			pstm.setString(3, doc.getMaterno());
			pstm.setString(4, doc.getSexo());
			pstm.setInt(5, doc.getNumHijos());
			pstm.setDouble(6, doc.getSueldo());
			
			pstm.setString(7, doc.getFecNacimiento());
			pstm.setInt(8, doc.getCodDistrito());
			pstm.setString(9, doc.getDireccion());
			
			pstm.setInt(10, doc.getCodigo());
			estado=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(pstm!=null) pstm.close(); if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public int deleteDocente(int cod) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="delete from tb_docente where cod_doc=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public List<Docente> listDocente() {
		List<Docente> lista=new ArrayList<Docente>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="SELECT *FROM TB_DOCENTE";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				Docente doc=new Docente();
				doc.setCodigo(rs.getInt(1));
				doc.setNombre(rs.getString(2));
				doc.setPaterno(rs.getString(3));
				doc.setMaterno(rs.getString(4));
				doc.setSexo(rs.getString(5));
				doc.setNumHijos(rs.getInt(6));
				doc.setSueldo(rs.getDouble(7));
				doc.setFecNacimiento(rs.getString(8));
				doc.setCodDistrito(rs.getInt(9));
				doc.setDireccion(rs.getString(10));
				lista.add(doc);
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
	public Docente findDocente(int cod) {
		Docente lista=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="SELECT *from tb_docente where cod_doc=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			while(rs.next()){
				lista=new Docente();
				lista.setCodigo(rs.getInt(1));
				lista.setNombre(rs.getString(2));
				lista.setPaterno(rs.getString(3));
				lista.setMaterno(rs.getString(4));
				lista.setSexo(rs.getString(5));
				lista.setNumHijos(rs.getInt(6));
				lista.setSueldo(rs.getDouble(7));
				lista.setFecNacimiento(rs.getString(8));
				lista.setCodDistrito(rs.getInt(9));
				lista.setDireccion(rs.getString(10));
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
	public List<Docente> listDocente(double sueldo) {
		List<Docente> lista=new ArrayList<Docente>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="SELECT *FROM TB_DOCENTE where sue_doc>=?";
			pstm=cn.prepareStatement(sql);
			pstm.setDouble(1, sueldo);
			rs=pstm.executeQuery();
			while(rs.next()){
				Docente doc=new Docente();
				doc.setCodigo(rs.getInt(1));
				doc.setNombre(rs.getString(2));
				doc.setPaterno(rs.getString(3));
				doc.setMaterno(rs.getString(4));
				doc.setSexo(rs.getString(5));
				doc.setNumHijos(rs.getInt(6));
				doc.setSueldo(rs.getDouble(7));
				doc.setFecNacimiento(rs.getString(8));
				doc.setCodDistrito(rs.getInt(9));
				doc.setDireccion(rs.getString(10));
				lista.add(doc);
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
