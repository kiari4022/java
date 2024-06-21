package Logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.ConnectionManager;
import Dao.YamadaDao;
import Dao.YamadaDao2;
import Entity.PostEntity;






public class YamadaLogic {
    public void insertPost(PostEntity Post) throws SQLException {
        // Connectionを取得
        try (Connection con = ConnectionManager.getConnection()) {
            con.setAutoCommit(false); // 自動コミットモードを無効にする
            YamadaDao dao = new YamadaDao(); // Daoクラスのインスタンスを作成
            int r = dao.insertPost(Post); // 投稿情報を挿入し、影響を受けた行数を取得
            if (r > 0) {
                con.commit(); // コミット
            } else {
                con.rollback(); // ロールバック
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // 例外を再スローする
        }
    }
    



    public ArrayList<PostEntity> searchPostList() {
        ArrayList<PostEntity> post = null;
        Connection con = null;
        
        try {
            con = ConnectionManager.getConnection(); // Connectionを取得
            YamadaDao dao = new YamadaDao(con); // ConnectionをYamadaDaoに渡す
            post = dao.searchPostList();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Connectionをクローズする必要があります
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return post;
    }
    
    
    
    
    //userID検索
	public ArrayList<PostEntity> searchPostList(int userID) throws SQLException { //メソッドは従業員を検索してリストとして返す

		ArrayList<PostEntity> post = null; // メソッドはユーザーIDで投稿を検索してリストとして返す
		try {
			Connection con = ConnectionManager.getConnection();
			YamadaDao dao = new YamadaDao(con);  //(con)をdaoの引数に設して、接続情報を渡す。
			post = dao.searchPostList(userID);  
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
	
//昇降機能
//	public ArrayList<PostEntity> UpPostList() {
//	    ArrayList<PostEntity> postList = null;
//	    try {
//	        YamadaDao dao = new YamadaDao();
//	        postList = dao.searchPostList();
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    return postList;
//	}
//	
	

//	public ArrayList<PostEntity> getPost() throws SQLException {
//	    YamadaDao dao = new YamadaDao();
//	    return dao.getPost();
//	}

//	public void updatePost(PostEntity post) throws SQLException {
//        try (Connection con = ConnectionManager.getConnection()) {
//            con.setAutoCommit(false); // 自動コミットモードを無効にする
//            YamadaDao dao = new YamadaDao(); // Daoクラスのインスタンスを作成
//            int rowsAffected = dao.updatePost(post); // 投稿情報を更新し、影響を受けた行数を取得
//            if (rowsAffected > 0) {
//                con.commit(); // コミット
//            } else {
//                con.rollback(); // ロールバック
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw e; // 例外を再スローする
//        }
//    }
}