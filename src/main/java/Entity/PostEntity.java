package Entity;

import java.sql.Date;

public class PostEntity {
    private int postID;
    private int userID;
    private String store;
    private String menu;
    private int price;
    private Date date;
    private String address;
    private int time;
    private String photo;
    private String text;
    
    // コンストラクタ
    public PostEntity() {    	
    }

    public PostEntity(int postID, int userID, String store, String menu, int price,Date date, String address, int time, String photo, String text) {
        this.postID = postID;
        this.userID = userID;
        this.store = store;
        this.menu = menu;
        this.price = price;
        this.date = date;
        this.address = address;
        this.time = time;
        this.photo = photo;
        this.text = text;
    }
    

    
    public PostEntity(int postID, int userID, String store, String menu, int price, String address, int time, String photo, String text) {
        this.postID = postID;
        this.userID = userID;
        this.store = store;
        this.menu = menu;
        this.price = price;
        this.address = address;
        this.time = time;
        this.photo = photo;
        this.text = text;
    }
    
    

    
    // ゲッターとセッター
    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }





	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


}