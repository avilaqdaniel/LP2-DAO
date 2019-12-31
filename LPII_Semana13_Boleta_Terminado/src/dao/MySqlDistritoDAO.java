package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Distrito;
import entidad.Docente;
import interfaces.DistritoDAO;
import utils.MysqlDBConexion;

public class MySqlDistritoDAO implements DistritoDAO {

	@Override
	public List<Distrito> listDistrito() {
		List<Distrito> lista=new ArrayList<Distrito>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="SELECT *FROM TB_DISTRITO";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				Distrito dis=new Distrito();
				dis.setCodigo(rs.getInt(1));
				dis.setNombre(rs.getString(2));
				lista.add(dis);
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
