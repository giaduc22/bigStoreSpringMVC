<% 
String view = request.getParameter("view");
if(view.startsWith("login")){
	pageContext.forward("parent_layout.jsp");
} else {
	pageContext.forward("child_layout.jsp");
}
 

%>