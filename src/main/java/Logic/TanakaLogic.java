package Logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Dao.ConnectionManager;
import Dao.TanakaDao;
import Entity.PostEntity;

public class TanakaLogic {
	public List<PostEntity> serchUser(int userId) throws SQLException {
		Connection con = null;
		List<PostEntity> list = null;
		con = ConnectionManager.getConnection();
		TanakaDao dao = new TanakaDao(con);
		list = dao.serchUser(userId);
		return list;
	}

	public PostEntity selectPost(int postId) {
		Connection con = null;
		PostEntity result = null;
		try {
			con = ConnectionManager.getConnection();
			con.setAutoCommit(false);
			TanakaDao dao = new TanakaDao(con);
			result = dao.selectPost(postId);
			if (result == null) {
				throw new SQLException("処理されるデータがありません。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// postIdを条件に該当するレコードを削除する
	public void deletePost(int postId) {
		Connection con = null;
		try {
			con = ConnectionManager.getConnection();
			con.setAutoCommit(false);
			TanakaDao dao = new TanakaDao(con);
			int post = dao.deletePost(postId);
			if (post < 0) {
				throw new SQLException("処理されるデータがありません。");
				//throw newの主な目的は、エラーや問題が発生した際に、プログラムの制御を中断して例外を上位のコードに伝え、適切な例外処理が行われるようにする。
			}
			con.commit(); //更新系（INSERT,UPDATE,DELEAT）以外はやらなくていい。
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} //更新系（INSERT,UPDATE,DELEAT）以外はやらなくていい。
			e.printStackTrace();
		}
	}

}
