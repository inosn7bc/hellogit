package blog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BlogController {

	private static BlogController controller = new BlogController();


	public static BlogController getInstance(){
		return controller;
	}

	private BlogController(){

	}

	public void postTopic(Topic topic){
		String sql = "INSERT into topic(title, content) values('"
				+ topic.getTitle() + "','" + topic.getContent() + "')";

		try (Connection conn = ConnectionManager.getConnection();
				Statement smt = conn.createStatement()) {
			smt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Topic> getTopics(){
		String sql = "select * from topic";
		List<Topic>topics = new ArrayList<>();

		try (Connection conn = ConnectionManager.getConnection();
				Statement smt = conn.createStatement()) {
			ResultSet rs =
			smt.executeQuery(sql);

			while (rs.next()){
				Topic topic = new Topic();
				topic.setId(rs.getInt("ID"));
				topic.setPostDate(rs.getTimestamp("POST_DATE"));
				topic.setTitle(rs.getString("TITLE"));
				topic.setContent(rs.getString("CONTENT"));
				topics.add(topic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topics;
	}

	public static void main (String[]args){
		BlogController ctrl = BlogController.getInstance();
		List<Topic>topics = ctrl.getTopics();
		for (Topic topic : topics) {
			System.out.println(topic);
		}
	}

}
