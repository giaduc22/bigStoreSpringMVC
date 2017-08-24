<% 
String view = request.getParameter("view");
if(view.startsWith("user")){
	pageContext.forward("parent_layout.jsp");
} else {
	pageContext.forward("child_layout.jsp");
}
 

%>