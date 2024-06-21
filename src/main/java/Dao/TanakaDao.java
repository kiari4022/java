package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.PostEntity;

public class TanakaDao {
	//データベースの接続情報
	private Connection con;

	public TanakaDao(Connection con) {
		this.con = con;
	}
	
	//SELECT
	public List<PostEntity> serchUser(int userID) throws SQLException {
		String sql = "SELECT * FROM post WHERE userID=?";

		PreparedStatement stmt = null;
		ResultSet res;
		List<PostEntity> list = new ArrayList<>();

		//データベースに対する処理
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, userID);
		res = stmt.executeQuery();

		while (res.next()) {
			PostEntity result = new PostEntity();
			result.setPostID(res.getInt("postID"));	//
			result.setUserID(res.getInt("userID"));	//
			result.setStore(res.getString("store"));	//
			result.setMenu(res.getString("menu"));	//
			result.setPrice(res.getInt("price"));	//
			result.setDate(res.getDate("date"));	//
			result.setPhoto(res.getString("picture"));	//
            result.setAddress(res.getString("jyuusho"));
			result.setTime(res.getInt("train"));	//
			result.setText(res.getString("str")); 	//
			//複数レコードが該当するケースがあるのでリストへ格納する
			list.add(result);

		}
		stmt.close();
		return list;// リストを返す;

	}
	
	//削除する投稿を選択
	public PostEntity selectPost(int postId) throws SQLException{
		ResultSet res;	
		String sql ="SELECT * FROM post WHERE postID=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, postId);
		res = stmt.executeQuery();
		PostEntity result = null;
		while (res.next()) {
			result = new PostEntity();
			result.setPostID(res.getInt("postID"));	//
			result.setUserID(res.getInt("userID"));	//
			result.setStore(res.getString("store"));	//
			result.setMenu(res.getString("menu"));	//
			result.setPrice(res.getInt("price"));	//
			result.setDate(res.getDate("date"));	//
			result.setPhoto(res.getString("picture"));	//
            result.setAddress(res.getString("jyuusho"));
			result.setTime(res.getInt("train"));	//
			result.setText(res.getString("str")); 	//
		//複数レコードが該当するケースがあるのでリストへ格納する
		}
		return result;
	}	
	
	//削除する
	public int deletePost(int postId) throws SQLException {
		String sql = "DELETE FROM Post WHERE PostID=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, postId);
		int result = stmt.executeUpdate();

		return result;
	}

}
