<% 
String view = request.getParameter("view");
if(view.startsWith("login") || view.startsWith("cart")){
	pageContext.forward("parent_layout.jsp");
} else {
	pageContext.forward("child_layout.jsp");
}
 

%>