package Logic;

import java.sql.Connection;
import java.sql.SQLException;

import Dao.ConnectionManager;
import Dao.KamiyaDao;
import Entity.UserEntity;

public class KamiyaLogic {
	public UserEntity searchLogin(String phone, String pass) throws SQLException {
		Connection con = null;
		UserEntity em = null;
		con = ConnectionManager.getConnection();
		KamiyaDao dao = new KamiyaDao(con);
		em = dao.searchLogin(phone, pass);
		return em;
	}
}
