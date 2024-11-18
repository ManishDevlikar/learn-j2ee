<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
         <%@ page import="java.util.*"%>
    <%@ page import="com.blog.*" %>
     
     <%@ page session="false" %>
     <%
     response.setHeader("Cache-Control", "no-store, private, no-cache, max-age=0");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="main.css">
     <script
      src="https://kit.fontawesome.com/84d5accb8a.js"crossorigin="anonymous"
    ></script>
    <title>Let'sBlog-HomePage</title>
       <link
      rel="shortcut icon"
      href="../LandingPage/Img/logo-green-small.png"
      type="image/x-icon"
    />
</head>
<body>
	
		<%
	String mobNo=request.getParameter("message");
	String fqcn="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306?user=root&password=root5003";
	String fName = ""; // Initialize fName
	String email = ""; // Initialize email
	String lName="";
	String mob="";
	int loggedInUserId=0;
	
	try{
		Class.forName(fqcn);
		Connection con=DriverManager.getConnection(url);
		
		PreparedStatement pstmtRecords=con.prepareStatement("select * from blogusers.users where mobile_number=?");
		pstmtRecords.setString(1,mobNo);
		ResultSet rs=pstmtRecords.executeQuery();
		if(rs.next()!=false){
			loggedInUserId=rs.getInt(1);
			 fName=rs.getString(2);
			 lName=rs.getString(3);
			 email=rs.getString(5);
			 mob=rs.getString(4);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	%>
	
	 <%
	  List<BlogPost> postList = new ArrayList<BlogPost>();
  
  try{
	  Class.forName(fqcn);
	  Connection con=DriverManager.getConnection(url);
	  
	  PreparedStatement pstmtBlogRecord=con.prepareStatement("SELECT * FROM blogusers.blogposts WHERE user_id=?");
	  pstmtBlogRecord.setInt(1, loggedInUserId);
	  ResultSet rs=pstmtBlogRecord.executeQuery();
	  while (rs.next()) {
		    int postId = rs.getInt("post_id");
		    String title = rs.getString("title");
		    String content = rs.getString("content");
		    String time=rs.getString("created_at");
		    String author=rs.getString("author");
		    BlogPost post = new BlogPost(postId, title, content,time,author);
		    postList.add(post);
		}
  }catch(Exception e){
	  e.printStackTrace();
  }
  %>
	
    <nav id="navbar">
      <div id="navbar-logo-div">
        <a href="#"> <img id="navbar-logo" src="./Img/logo-green-small.png" alt=""></a>
       <div id="search-div">
           <input id="search" type="text" placeholder="Search">
           <i class="fas fa-search"></i>
        </div>
      </div>
      <div id="navbar-links">
        <ul id="navbar-ul">
          <li class="write"><a><i class="far fa-edit"></i><span>Write</span></a></li>
          <!-- <li><a href="#"> Sign In</a></li> -->
          <li class="user"><a><i class="fas fa-user"></i></a></li>
        </ul>
      </div>
    </nav>
  
  <section id="user-details" class="user-details hide-user-details">
  <div id="user-details-cont">
    <table id="user-details-table" class="user-details-table">
      <tr>
        <td colspan="2" class="user-info">
          <i class="fas fa-user user-profile"></i>
        </td>
      </tr>
      <tr>
        <td class="user-info-label">Name:</td>
        <td><%= fName %> <%= lName %></td>
      </tr>
      <tr>
        <td class="user-info-label">Email Id:</td>
        <td><%= email %></td>
      </tr>
      <tr>
        <td class="user-info-label">Mobile No:</td>
        <td><%= mob %></td>
      </tr>
      <tr>
        <td colspan="2">
          <a id="log-out-a"><button id="log-out" class="log-out">Log Out</button></a>
        </td>
      </tr>
    </table>
  </div>
</section>

    <section id="create-blog-section" class="create-blog-section hide-blog-section">
      <div id="blog-container" class="blog-container">
        <form id="blog-form" class="blog-form" action="saveblog.jsp" method="post">
          <p class="Close-blog"><i class="far fa-times-circle"></i><span class="close">Close</span></p>
          <h2 class="create-blog">New Blog</h2>
         																		
          <input type="hidden" name="author" value=
          <%=fName%><%=lName %>>
          <input type="hidden" name ="mobile" value=<%=mobNo %>>
          																			
          <input type="text" id="title" class="title" name="title" placeholder="Title" required/>
          <br>
          <textarea rows="10" cols="10" id="content" class="content" name="content" placeholder="Tell Your Story..." required></textarea>
          <br>
          <button class="submit" id="submit">submit</button>
        </form>
      </div>
    </section>
    <section id="blogs-section" class="blogs-section">
    
 <% for (BlogPost post : postList) { %>
  <% if (post != null) { %>
    <div id="blog-container" class="blog-container">
      <div id="blog-details" class="blog-details">
        <div class="title-and-delete">
          <h2><%= post.getTitle() %></h2>
          <!-- Add the delete icon and form for each post -->
          <form action="deletepost.jsp" method="post" class="delete-form">
            <input type="hidden" name="postId" value="<%= post.getId() %>">
            <input type="hidden" name="mobile" value="<%=mobNo %>">
            <button type="submit" class="delete-button"><i class="fas fa-trash-alt"></i></button>
          </form>
        </div>
        <p >Date: <%= post.getTime() %></p>
        <!--  <p>Author: <%= post.getAuthor() %></p>  -->
      </div>

      <div id="blog-content" class="blog-content">
        <p><%=post.getContent() %></p>
      </div>
    </div>
  <% } %>
<% } %>
   
    </section>
    <script src="main.js"></script>
</body>
</html>