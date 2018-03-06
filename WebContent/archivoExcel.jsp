<%@page import="cl.tesoreria.utiles.files.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.ArrayList"%>
<%
response.setContentType("application/vnd.ms-excel");
response.setHeader("Content-Disposition","attachment;filename=salida.xls"); 
GeneraExcel generaExcel = new GeneraExcel();
DataOutput output = new DataOutputStream(response.getOutputStream());
String[] giroEncabezado = (String[]) request.getAttribute("titulos");
ByteArrayOutputStream bufferSalida = generaExcel.generarArchivo((ArrayList) request.getAttribute("arrayResult"),giroEncabezado);
byte[] bytes = bufferSalida.toByteArray();
response.setContentLength(bytes.length);
System.out.println("Buffer " + bytes.length);
for( int i = 0; i < bytes.length; i++ )
{ 
    output.writeByte(bytes[i]); 
}
%>