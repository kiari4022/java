package Logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.ConnectionManager;
import Dao.TairaDao;
import Dao.YamadaDao;
import Entity.PostEntity;

public class TairaLogic {
	//----------------------------
	// 引数で指定したpostを検索する
	// 	　[引数]postID:投稿ID
	//　 [戻値]post:投稿
	public PostEntity serchPostById(int postID) {
		Connection con = null;
		PostEntity post = null;

		//コネクション呼び出し
		try {
			con = ConnectionManager.getConnection();
			//DAOを生成と、メソッドを呼びだし
			TairaDao tairaDAO = new TairaDao(con);
			post = tairaDAO.serchPostById(postID);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return post;
	}

	public int updatePost(PostEntity post) {
		Connection con = null;
		int posts = 0;

		//コネクション呼び出し
		try {
			con = ConnectionManager.getConnection();
			con.setAutoCommit(false);//DBのテーブルの変更(インサート、デリート、アップデート)に
			//関わる際はcon,で始まるトランザクション制御を考慮しようね
			//DAOを生成と、メソッドを呼びだし
			TairaDao tairaDAO = new TairaDao(con);
			posts = tairaDAO.updatePost(post);
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		}

		return posts;
		
	}
	public ArrayList<PostEntity> searchPostList(int userID) throws SQLException { //メソッドは従業員を検索してリストとして返す
		 ArrayList<PostEntity> post = null; // メソッドはユーザーIDで投稿を検索してリストとして返す
		 try {
		 Connection con = ConnectionManager.getConnection();
		 TairaDao dao = new TairaDao(con); //(con)をdaoの引数に設して、接続情報を渡す。
		 post = dao.searchPostList(userID);
		 // DAOクラスのsearchPostListメソッドを呼び出し、従業員情報のリストを取得。daoのsearchEmployeeとつながってる。
		 if (post == null) {
		 throw new SQLException("処理されるデータがありません。");
		 }
		 } catch (SQLException e) {
		 e.printStackTrace(); //例外処理
		 throw e; // 例外を再スローする
		 }
		 return post;
			}
}
