package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.UserEntity;

public class KamiyaDao {
	//データベースの接続情報
	private Connection con;

	//----------------------------
	//コンストラクタ
	//　[引数]con：データベースの接続情報
	public KamiyaDao(Connection con) {
		this.con = con;
	}

	public UserEntity searchLogin(String phone, String pass) throws SQLException {
		String sql = "SELECT userID, name FROM user "
				+ "WHERE number=? AND password=?";

		PreparedStatement stmt = null;
		ResultSet res;
		UserEntity result = null;
		//データベースに対する処理
		stmt = con.prepareStatement(sql);
		stmt.setString(1, phone);
		stmt.setString(2, pass);
		res = stmt.executeQuery();

		if (res.next()) {
			result = new UserEntity(res.getInt("userID"),
					res.getString("name"),"", "", "");
			
		}else{
			throw new SQLException();
		}
		stmt.close();
		return result;
	}
}
