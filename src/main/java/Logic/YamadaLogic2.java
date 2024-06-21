package Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.ConnectionManager;
import Dao.YamadaDao;
import Dao.YamadaDao2;
import Entity.PostEntity;



public class YamadaLogic2 {

	
    // 全検索
    public ArrayList<PostEntity> searchToyCarList() {
        ArrayList<PostEntity> car = null;
        try {
            Connection con = ConnectionManager.getConnection(); // Connectionを取得
            YamadaDao2 dao = new YamadaDao2(con); // ConnectionをYamadaDao2に渡す
            car = dao.searchToyCarList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }
    
    


   
    
    //postID検索
	public ArrayList<PostEntity> searchPostList(int postID) throws SQLException { //メソッドは従業員を検索してリストとして返す

		ArrayList<PostEntity> post = null; // メソッドはユーザーIDで投稿を検索してリストとして返す
		try {
			Connection con = ConnectionManager.getConnection();
			YamadaDao2 dao = new YamadaDao2(con);  //(con)をdaoの引数に設して、接続情報を渡す。
			post = dao.searchPostList(postID);  
			// DAOクラスのsearchPostListメソッドを呼び出し、従業員情報のリストを取得。daoのsearchEmployeeとつながってる。
			if (post == null) {
				throw new SQLException("処理されるデータがありません。");
			}
		} catch (SQLException e) {  
			e.printStackTrace();  //例外処理
			throw e; // 例外を再スローする
		}
		return post;
	}
    
}
