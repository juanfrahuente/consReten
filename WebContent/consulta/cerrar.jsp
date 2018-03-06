<%
  //Se procede a cerrar la sesión.
  session.invalidate();
  //Se redirecciona nuevamente al login.
  response.sendRedirect("/ConsRetencionesWeb/login.jsp");
%>