<%@page contentType="text/html; charset=Windows-31J"%>
<%@page import="blog.Topic, java.util.List"%>

<html>
<body>

<h2>�V���v��Blog</h2>
<a href="read">�����[�h</a>

<form action="post" method="POST">
	�^�C�g��<input type="text" name="title" size="40">
	<br>
	<textarea name="content" rows="5" cols="40" ></textarea>
	<br>
	<input type="submit" value="���e">
</form>

<%
	List topics =(List)request.getAttribute("topics");
	if(topics !=null){
		for(int i = topics.size() -1; i >=0; i--){
			Topic topic=(Topic)topics.get(i);
%>
			<hr>
			�^�C�g�� <%=topic.getTitle()%>
			(<%=topic.getPostDate()%>)
			<pre><%=topic.getContent()%></pre>

<%
		}
	}
%>
</body>
</html>
