package Entity;

public class UserEntity {
	 private int userID;
	    private String name;
	    private String password;
	    private String number;
	    private String birthday;
	    
	    // コンストラクタ
	    public UserEntity(int userID, String name, String password, String number, String birthday) {
	        this.userID = userID;
	        this.name = name;
	        this.password = password;
	        this.number = number;
	        this.birthday = birthday;
	    }
	    
	    // ゲッターとセッター
	    public int getUserID() {
	        return userID;
	    }

	    public void setUserID(int userID) {
	        this.userID = userID;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getNumber() {
	        return number;
	    }

	    public void setNumber(String number) {
	        this.number = number;
	    }

	    public String getBirthday() {
	        return birthday;
	    }

	    public void setBirthday(String birthday) {
	        this.birthday = birthday;
	    }
}
