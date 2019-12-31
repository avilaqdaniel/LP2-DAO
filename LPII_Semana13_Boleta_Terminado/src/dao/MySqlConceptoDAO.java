package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Alumno;
import entidad.Concepto;
import interfaces.ConceptoDAO;
import utils.MysqlDBConexion;

public class MySqlConceptoDAO implements ConceptoDAO {

	@Override
	public List<Concepto> listaConceptoXNombre(String nombre) {
		List<Concepto> data=new ArrayList<Concepto>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Concepto dis=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="select *from tb_concepto where nom_concepto like ?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, nombre+"%");
			rs=pstm.executeQuery();
			while(rs.next()){
				dis=new Concepto();
				dis.setCodigo(rs.getInt(1));
				dis.setNombre(rs.getString(2));
				dis.setPrecio(rs.getDouble(3));
				data.add(dis);
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
		return data;
	}

}
