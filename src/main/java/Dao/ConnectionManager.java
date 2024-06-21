package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	////////////////////////////////////
	// ConnectionManager
	// 　データベースへの接続の管理

		//データベース接続に必要な情報
		
		private static final String URL = "jdbc:mysql://localhost:3306/techdb";//url
		private static final String USER = "seed"; //ユーザー名
		private static final String PASSWORD  = "Tech_123";//パスワード

		//----------------------------
		// データベースに接続
		//　 [戻値]con:接続情報
	    public static Connection getConnection() throws SQLException {
	    	Connection con = null;
	    	try {
				con = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				throw e;
			}
	    	
	    	return con;
	    }
	}




