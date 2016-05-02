package blog;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadServlet extends HttpServlet {

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
		BlogController ctrl = BlogController.getInstance();
		List<Topic>topics=ctrl.getTopics();

		request.setAttribute("topics", topics);
		request.getRequestDispatcher("read.jsp").forward(request, response);

	}

}
