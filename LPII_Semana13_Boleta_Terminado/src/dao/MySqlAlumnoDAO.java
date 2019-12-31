package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Alumno;
import entidad.Distrito;
import interfaces.AlumnoDAO;
import utils.MysqlDBConexion;

public class MySqlAlumnoDAO implements AlumnoDAO {

	@Override
	public List<Alumno> listaAlumnoxApellido(String apellido) {
		List<Alumno> data=new ArrayList<Alumno>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Alumno dis=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="select *from tb_alumno where ape_alu like ?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, apellido+"%");
			rs=pstm.executeQuery();
			while(rs.next()){
				dis=new Alumno();
				dis.setCodigo(rs.getInt(1));
				dis.setNombre(rs.getString(2));
				dis.setApellido(rs.getString(3));
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
