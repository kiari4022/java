package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.UserEntity;

public class TakahashiDao {

	////////////////////////////////////
	//TakahashiDAO
	//�itoycar�e�[�u���Ɋւ���DAO�j
		//�f�[�^�x�[�X�̐ڑ����
	private Connection con;

	//----------------------------
	//�R���X�g���N�^
	//�@[����]con�F�f�[�^�x�[�X�̐ڑ����
	public TakahashiDao(Connection con) {
		this.con = con;
	}

	//----------------------------
	// �ǉ�����
	//----------------------------
//		public int insertToyCar(ToyCar toycar) throws SQLException {
//			String sql = "INSERT INTO toycar VALUES(?,?,?,?,?)";
//			PreparedStatement stmt = con.prepareStatement(sql);
//			stmt.setInt(1, toycar.getToyID());
//			stmt.setString(2, toycar.getToyName());
//			stmt.setInt(3, toycar.getCategoryId());
//			stmt.setInt(4, toycar.getPrice());
//			stmt.setInt(5, toycar.getStock());
//			int result = stmt.executeUpdate();
//			return result;
//		}
	public void signUp(String name, String tell, String pass, String date) throws SQLException {
		String sql = "INSERT INTO user(name, password, number,birthday) VALUES(? , ?, ?, ?)";

		PreparedStatement stmt = null;
		UserEntity result = null;
		//データベースに対する処理
		stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, pass);
		stmt.setString(3, tell);
		stmt.setString(4, date);
		int res = stmt.executeUpdate();

		stmt.close();
	}

}

