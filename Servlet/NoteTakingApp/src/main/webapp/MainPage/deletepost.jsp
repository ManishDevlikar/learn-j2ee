<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<%
String fqcn = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306?user=root&password=root5003";

try {
    Class.forName(fqcn);
    Connection con = DriverManager.getConnection(url);

    // Retrieve the post ID from the request
    int postId = Integer.parseInt(request.getParameter("postId"));
    String mobNo = request.getParameter("mobile");

    // Delete the post
    PreparedStatement pstmt = con.prepareStatement("DELETE FROM blogusers.blogposts WHERE post_id=?");
    pstmt.setInt(1, postId);
    pstmt.executeUpdate();

    // Redirect back to the main.jsp page after deletion
    String dataToSend = mobNo;
    response.sendRedirect("main.jsp?message=" + dataToSend);


} catch (Exception e) {
    e.printStackTrace();
}
%>
