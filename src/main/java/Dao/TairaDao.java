package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.PostEntity;

public class TairaDao {

	private Connection con;

	//コンストラクタ
	public TairaDao(Connection con) {
		this.con = con;

	}

	//引数で指定したレコードを検索する
	public List<PostEntity> serchEmployee(int userID) throws SQLException {
		String sql = "SELECT * FROM post "
				+ "WHERE userID=?";

		PreparedStatement stmt = null;
		ResultSet res;
		List<PostEntity> list = new ArrayList<>();

		//データベースに対する処理
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, userID);
		res = stmt.executeQuery();

		while (res.next()) {
			PostEntity result = new PostEntity();
			result.setPostID(res.getInt("postID")); //
			result.setUserID(res.getInt("userID")); //
			result.setStore(res.getString("store")); //
			result.setMenu(res.getString("menu")); //
			result.setPrice(res.getInt("price")); //
			result.setDate(res.getDate("date")); //
			result.setPhoto(res.getString("picture")); //
			result.setAddress(res.getString("jyuusho"));
			result.setTime(res.getInt("train")); //
			result.setText(res.getString("str")); //
			//複数レコードが該当するケースがあるのでリストへ格納する
			list.add(result);

		}
		stmt.close();
		return list;// リストを返す;

	}

	public PostEntity serchPostById(int postID) throws SQLException {
		ResultSet res;
		String sql = "SELECT * FROM post "
				+ "WHERE postID=?";

		PreparedStatement stmt = con.prepareStatement(sql);

		//データベースに対する処理
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, postID);
		res = stmt.executeQuery();
		PostEntity result = null;

		while (res.next()) {
			result = new PostEntity();
			result.setPostID(res.getInt("postID"));
			result.setUserID(res.getInt("userID"));
			result.setStore(res.getString("store"));
			result.setMenu(res.getString("menu"));
			result.setPrice(res.getInt("price"));
			result.setDate(res.getDate("date"));
			result.setPhoto(res.getString("picture"));
			result.setAddress(res.getString("jyuusho"));
			result.setTime(res.getInt("train"));
			result.setText(res.getString("str")); //複数レコードが該当するケースがあるのでリストへ格納する

		}

		return result;

	}

	//更新する
	public int updatePost(PostEntity post) throws SQLException {
		String sql = "UPDATE post "
				+ "SET store=?,menu=?,price=?,date=?,str=?,picture=?,jyuusho=?,train=?"
				+ " WHERE postID=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, post.getStore());
		stmt.setString(2, post.getMenu());
		stmt.setInt(3, post.getPrice());
		stmt.setDate(4, post.getDate());
		stmt.setString(5, post.getText());
		stmt.setString(6, post.getPhoto());
		stmt.setString(7, post.getAddress());
		stmt.setInt(8, post.getTime());
		stmt.setInt(9, post.getPostID());

		int result = stmt.executeUpdate();

		return result;
	}

	public ArrayList<PostEntity> searchPostList(int userID) throws SQLException {
		String sql = "SELECT postID, userID, store, menu, price, date, jyuusho, train, picture, str FROM Post WHERE userID=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, userID);
			try (ResultSet res = stmt.executeQuery()) {
				ArrayList<PostEntity> PostList = new ArrayList<>();
				while (res.next()) {
					PostEntity post = new PostEntity(
							res.getInt("postID"),
							res.getInt("userID"),
							res.getString("store"),
							res.getString("menu"),
							res.getInt("price"),
							res.getDate("date"),
							res.getString("jyuusho"),
							res.getInt("train"),
							res.getString("picture"),
							res.getString("str"));
					PostList.add(post);
				}
				return PostList;
			}
		}
	}
}
