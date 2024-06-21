package Web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class InsertCheckServlet
 */
@WebServlet("/InsertCheckServlet")
@MultipartConfig
public class InsertCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertCheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//        
		request.setCharacterEncoding("UTF-8");

		try {
			String userID = request.getParameter("userID");
			String shop = request.getParameter("shop");
			String menu = request.getParameter("menu");
			String price = request.getParameter("price");
			String date = request.getParameter("date");
			String address = request.getParameter("address");
			String time = request.getParameter("time");
			Part photo = request.getPart("photo");
			String text = request.getParameter("text");



			if (shop == null || menu == null || price == null || address == null || time == null
					||  photo.getSize() == 0 || text == null) {

				String next = "Insert.jsp";
				request.getRequestDispatcher(next).forward(request, response);
				return;
			}
			
			// ファイル名を取得
			String filename = photo.getSubmittedFileName();
			// String filename = Paths.get(photo.getSubmittedFileName()).getFileName().toString(); // IE対応が必要な場合
			// アップロードするフォルダ
			String path = getServletContext().getRealPath("/upload");
			// 実際にファイルが保存されるパス確認
			System.out.println(path);
			// 書き込み
			photo.write(path + File.separator + filename);

			request.setAttribute("userID", userID);
			request.setAttribute("shop", shop);
			request.setAttribute("menu", menu);
			request.setAttribute("price", price);
			request.setAttribute("date", date);
			request.setAttribute("address", address);
			request.setAttribute("time", time);
			request.setAttribute("photo", filename);
			request.setAttribute("text", text);

			String next = "InsertCheck.jsp";
			// 確認画面へフォワード
			request.getRequestDispatcher(next).forward(request, response);

		} catch (NumberFormatException e) {
			// 型が異なる場合、同じ画面にとどまる
 		String next = "Insert.jsp";
			request.getRequestDispatcher(next).forward(request, response);
		}
	}
}

