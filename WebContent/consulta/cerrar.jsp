<%
  //Se procede a cerrar la sesi�n.
  session.invalidate();
  //Se redirecciona nuevamente al login.
  response.sendRedirect("/ConsRetencionesWeb/login.jsp");
%>