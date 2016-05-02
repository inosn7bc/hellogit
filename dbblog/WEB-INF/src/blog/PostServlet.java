package blog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		perform(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		perform(req, resp);

	}

	protected void perform(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		Topic topic = new Topic();
		topic.setTitle(title);
		topic.setContent(content);

		BlogController ctrl = BlogController.getInstance();
		ctrl.postTopic(topic);

		request.getRequestDispatcher("/read").forward(request, response);
	}
}
