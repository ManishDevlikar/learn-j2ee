<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>

<%
String title = request.getParameter("title");
String content = request.getParameter("content");
String author = request.getParameter("author");
String mobNo = request.getParameter("mobile");

String fqcn = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306?user=root&password=root5003";

try {
    Class.forName(fqcn);
    Connection con = DriverManager.getConnection(url);

    // Retrieve the user ID based on the mobile number
    PreparedStatement pstmtUserId = con.prepareStatement("SELECT id FROM blogusers.users WHERE mobile_number=?");
    pstmtUserId.setString(1, mobNo);
    ResultSet rsUserId = pstmtUserId.executeQuery();

    int userId = 0;
    if (rsUserId.next()) {
        userId = rsUserId.getInt("id");
    }

    // Insert the blog post with the user ID
    PreparedStatement pstmt = con.prepareStatement("INSERT INTO blogusers.blogposts (title, content, author, created_at, user_id) VALUES (?, ?, ?, CURRENT_TIMESTAMP, ?)");
    pstmt.setString(1, title);
    pstmt.setString(2, content);
    pstmt.setString(3, author);
    pstmt.setInt(4, userId);
    pstmt.executeUpdate();

    String dataToSend = mobNo;
    response.sendRedirect("main.jsp?message=" + dataToSend);

} catch (Exception e) {
    e.printStackTrace();
}
%>
