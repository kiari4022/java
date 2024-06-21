package Web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.PostEntity;
import Logic.YamadaLogic;
import Logic.YamadaLogic2;

/**
 * Servlet implementation class PostDetailServlet
 */
@WebServlet("/PostDetailServlet")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // 文字化け防止
	    request.setCharacterEncoding("UTF-8");
	    try {
	        String postIDString = request.getParameter("PostID");
	        if (postIDString != null && !postIDString.isEmpty()) { // null チェックと空文字列チェック
	            int postID = Integer.parseInt(postIDString);

	            // 検索処理
	            YamadaLogic2 logic = new YamadaLogic2();

	            ArrayList<PostEntity> postList = logic.searchPostList(postID);

	            if (!postList.isEmpty()) { // postListが空でないかをチェック
	                PostEntity post = postList.get(0);
	                request.setAttribute("post", post); // リクエストスコープに詳細情報をセット
	            } else {
	                // postListが空の場合の処理（適切なメッセージをセットしたり、別の処理を行ったりする）
	                // 例えば、該当の投稿が見つからなかった場合にはエラーメッセージをセットする
	                request.setAttribute("errorMessage", "該当する投稿が見つかりませんでした。");
	            }
	        } else {
	            // PostIDがnullまたは空の場合の処理
	            // 例えば、エラーメッセージをセットするなど
	            request.setAttribute("errorMessage", "投稿IDが指定されていません。");
	        }
	    } catch (NumberFormatException e) {
	        // 数値への変換ができない場合の処理
	        e.printStackTrace();
	        // エラーハンドリング
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // エラーハンドリング
	    }

	    // JSPにフォワード
	    String next = "PostDetail.jsp";
	    request.getRequestDispatcher(next).forward(request, response);
	}
	}