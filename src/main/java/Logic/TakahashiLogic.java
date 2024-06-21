package Logic;

import java.sql.Connection;
import java.sql.SQLException;

import Dao.ConnectionManager;
import Dao.TakahashiDao;
import Entity.UserEntity;

public class TakahashiLogic {
	public void getLogic(String a, String b, String c, String d) throws SQLException{
		Connection con = ConnectionManager.getConnection();
		TakahashiDao dao = new TakahashiDao(con);
		dao.signUp(a, b, c, d);
	}
}
