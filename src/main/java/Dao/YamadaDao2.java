package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.PostEntity;

public class YamadaDao2 {
    private Connection con; // Connectionをフィールドとして保持

    public YamadaDao2(Connection con) {
        this.con = con;
    }

    public ArrayList<PostEntity> searchToyCarList() throws SQLException {
        String sql = "SELECT postID, userID, store, menu, price, date, jyuusho, train, picture, str FROM Post";
        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet res = stmt.executeQuery()) {
            ArrayList<PostEntity> carList = new ArrayList<>();
            while (res.next()) {
                PostEntity car = new PostEntity(
                        res.getInt("postID"), 
                        res.getInt("userID"), 
                        res.getString("store"), 
                        res.getString("menu"), 
                        res.getInt("price"), 
                        res.getDate("date"), 
                        res.getString("jyuusho"), 
                        res.getInt("train"), 
                        res.getString("picture"), 
                        res.getString("str")
                );
                carList.add(car);
            }
            return carList;
        }
    }
        
        
    
    
    
    
        
        


  //userID検索
  	public ArrayList<PostEntity> searchPostList(int postID) throws SQLException {
  		String sql = "SELECT postID, userID, store, menu, price, date, jyuusho, train, picture, str FROM Post WHERE postID=?";
  		try (PreparedStatement stmt = con.prepareStatement(sql)) {
  			stmt.setInt(1, postID);
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

