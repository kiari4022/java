package Web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.PostEntity;
import Logic.YamadaLogic;
import Logic.YamadaLogic2;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8"); //最初に表示する・文字化け防止コード
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("UTF-8");

		YamadaLogic2 logic = new YamadaLogic2();
		// データベースに追加された後に検索を行い、最新のデータを取得する
		ArrayList<PostEntity> returnValue = logic.searchToyCarList();
		
		
		
        // ファイル名を取得
//        String filename = photo.getSubmittedFileName(); // IE対応が不要な場合
//         String filename = Paths.get(photo.getSubmittedFileName()).getFileName().toString(); // IE対応が必要な場合
//        // アップロードするフォルダ
//        String path = getServletContext().getRealPath("/upload");
//        // 実際にファイルが保存されるパス確認
//        System.out.println(path);
//        // 書き込み
//        photo.write(path + File.separator + filename);
		
		request.setAttribute("post", returnValue);
		
		
		

		 Collections.sort(returnValue, Comparator.comparing(PostEntity::getPostID).reversed());
		// フォワード先のJSPを指定
		String next = "Post.jsp";

		// フォワード
		request.getRequestDispatcher(next).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ファイルアップロード処理
		//Part filePart = request.getPart("photo");
		//InputStream a= filePart.getInputStream();

		//	    String date=request.getParameter("date");
		//	    Date sqlDate= Date.valueOf(date);
		//		String userID= request.getParameter("userID");
		//		int userIDInt = Integer.parseInt(userID);
		//	    String shop = request.getParameter("shop");
		//	    String menu = request.getParameter("menu");
		//	    String price = request.getParameter("price");
		//	    int priceInt = Integer.parseInt(price);
		//	    String address = request.getParameter("address");
		//	    String time = request.getParameter("time");
		//	    int timeInt = Integer.parseInt(time);
		//	    String photo = request.getParameter("photo");
		//	    String text = request.getParameter("text");
		//
		//	    
		//	    PostEntity e = new PostEntity(0,0, shop, menu, priceInt, address, timeInt, photo, text);

	}

}
