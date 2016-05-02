package blog;

import java.util.Date;

public class Topic {

	public String toString(){
		return title;
	}

	private int id;

	private String title;

	private String content;

	private Date postDate;

	/**
	 * idを取得します。
	 * @return id
	 */
	public int getId() {
	    return id;
	}

	/**
	 * idを設定します。
	 * @param id id
	 */
	public void setId(int id) {
	    this.id = id;
	}

	/**
	 * titleを取得します。
	 * @return title
	 */
	public String getTitle() {
	    return title;
	}

	/**
	 * titleを設定します。
	 * @param title title
	 */
	public void setTitle(String title) {
	    this.title = title;
	}

	/**
	 * contentを取得します。
	 * @return content
	 */
	public String getContent() {
	    return content;
	}

	/**
	 * contentを設定します。
	 * @param content content
	 */
	public void setContent(String content) {
	    this.content = content;
	}

	/**
	 * postDateを取得します。
	 * @return postDate
	 */
	public Date getPostDate() {
	    return postDate;
	}

	/**
	 * postDateを設定します。
	 * @param postDate postDate
	 */
	public void setPostDate(Date postDate) {
	    this.postDate = postDate;
	}

}
