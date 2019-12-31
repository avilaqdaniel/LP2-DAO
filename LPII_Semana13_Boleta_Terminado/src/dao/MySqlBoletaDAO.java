package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import entidad.Boleta;
import entidad.DetalleBoleta;
import interfaces.BoletaDAO;
import utils.MysqlDBConexion;

public class MySqlBoletaDAO implements BoletaDAO {
	@Override
	public void registraBoleta(Boleta boleta, List<DetalleBoleta> detalle) {
		Connection cn=null;
		PreparedStatement pstm1=null,pstm2=null,pstm3=null;
		ResultSet rs=null;
		int cod=0;
		try {
			cn=new MysqlDBConexion().getConexion();
			cn.setAutoCommit(false);
			pstm1=cn.prepareStatement("select max(num_bol)+1 from tb_boleta");
			rs=pstm1.executeQuery();
			if(rs.next())
				cod=rs.getInt(1);

			if(cod==0)cod=1;
			String sql2="insert into tb_boleta values(?,?,?,curdate(),?)";
			pstm2=cn.prepareStatement(sql2);
			pstm2.setInt(1, cod);
			pstm2.setInt(2, boleta.getCodCliente());
			pstm2.setInt(3, boleta.getCodEmpleado());
			pstm2.setDouble(4,boleta.getMonto());
			pstm2.executeUpdate();
			String sql3="insert into tb_detalle values(?,?,?)";
			for(DetalleBoleta d:detalle){
				pstm3=cn.prepareStatement(sql3);
				pstm3.setInt(1, cod);
				pstm3.setInt(2, d.getCodProducto());
				pstm3.setInt(3, d.getCantidad());
				pstm3.executeUpdate();
			}
			cn.commit();
		} catch (Exception e) {
			try{
				cn.rollback();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(pstm3!=null)pstm3.close();if(pstm2!=null)pstm2.close();
				if(pstm1!=null)pstm1.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}

}
