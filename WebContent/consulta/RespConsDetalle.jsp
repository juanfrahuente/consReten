<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"	prefix="html"%> 
<netui-data:declareBundle bundlePath="../resources/properties/RetencionesText" name="messages"></netui-data:declareBundle>
<script type="text/javascript" src="/ConsRetencionesWeb/resources/js/utiles.js"></script>
<netui:html>
<head>

<title>Tesoreria General de la Republica</title>
</head>
<body>
	<link href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css" rel="stylesheet">
	<div align="center">
		<table border="0" width="581" cellspacing="0" cellpadding="0">
			<tr>
				<td height="44" class="tituloSecciones"><netui:label
						value="${bundle.messages.TITULO1}" /></td>
			</tr>
		</table>
	</div>
	<BR>
	<div align="center" class="ClasificacionPF">
		<netui:label value="${bundle.messages.TITULO2}" />
	</div>
	<div align="center">
		<netui:errors />
	</div>
	<br>
	<br>
	<div align="center">
		<form name="beginForm">
			<input type="hidden" name="detalle" value="ok">
			<table align="center" class="leftbottom" width="581">
				<tr valign="top">
					<td class="bajada" colspan="2"><netui:label
							value="${bundle.messages.DATPERSONA}" /></td>
				</tr>
				<tr>
					<td class="obtenga_clave"><netui:label
							value="${bundle.messages.RUT}" /></td>
					<td class="parrafo">: <netui:content
							value="${pageFlow.beginForm.rut}" /> <netui:hidden
							dataSource="pageFlow.beginForm.rut" /> - <netui:content
							value="${pageFlow.beginForm.dv}" /> <netui:hidden
							dataSource="pageFlow.beginForm.dv" />
					</td>
				</tr>
				<tr>
					<td class="obtenga_clave"><netui:label
							value="${bundle.messages.APPPAT}" /></td>
					<td class="parrafo">: <netui:content
							value="${pageFlow.beginForm.appPat}" /> <netui:hidden
							dataSource="pageFlow.beginForm.appPat" />
					</td>
				</tr>
				<tr>
					<td class="obtenga_clave"><netui:label
							value="${bundle.messages.APPMAT}" /></td>
					<td class="parrafo">: <netui:content
							value="${pageFlow.beginForm.appMat}" /> <netui:hidden
							dataSource="pageFlow.beginForm.appMat" />
					</td>
				</tr>
				<tr>
					<td class="obtenga_clave"><netui:label
							value="${bundle.messages.NOMBRE}" /></td>
					<td class="parrafo">: <netui:content
							value="${pageFlow.beginForm.nombre}" /> <netui:hidden
							dataSource="pageFlow.beginForm.nombre" />
					</td>
				</tr>
				<logic:equal value="false" name="error">
					<logic:equal value="1" name="tipoReten">
						<jsp:include page="DetalleRetJudicial.jsp" />
					</logic:equal>
					<logic:equal value="2" name="tipoReten">
						<jsp:include page="DetalleRetMandato.jsp" />
					</logic:equal>
					<logic:equal value="3" name="tipoReten">
						<jsp:include page="DetalleOtrasReten.jsp" />
					</logic:equal>
					<logic:equal value="4" name="tipoReten">
						<jsp:include page="DetalleEgresCuestion.jsp" />
					</logic:equal>
					<logic:equal value="5" name="tipoReten">
						<jsp:include page="DetalleRetenQuiebra.jsp" />
					</logic:equal>
					<logic:equal value="6" name="tipoReten">
						<jsp:include page="DetalleCondJudicial.jsp" />
					</logic:equal>
					<logic:equal value="7" name="tipoReten">
						<jsp:include page="DetalleCreUniv.jsp" />
					</logic:equal>
					<logic:equal value="10" name="tipoReten">
						<jsp:include page="DetallePensionAlimen.jsp" />
					</logic:equal>
				</logic:equal>
			</table>
			<br>
			<div align="center" class="ClasificacionPF">
				<netui:label value="${bundle.messages.HISTORIAL}" />
			</div>
			<table border="1" cellpadding="1" cellspacing="1" align="center"
				class="fondoTituloColumna">
				<tr>
					<td align="center"><netui:label
							value="${bundle.messages.FECHA}" /></td>
					<td align="center"><netui:label
							value="${bundle.messages.RUTFUN}" /></td>
					<td align="center"><netui:label
							value="${bundle.messages.CODTESO}" /></td>
					<td align="center"><netui:label
							value="${bundle.messages.TESO}" /></td>
					<td align="center"><netui:label
							value="${bundle.messages.MONTO}" /></td>
					<td align="center"><netui:label
							value="${bundle.messages.GLOSA}" /></td>
				</tr>
				<logic:iterate id="histo" name="historial">
					<%
                String[] arrHisto = (String[]) pageContext.getAttribute("histo");
            %>
					<tr>
						<td class="TR_bgColor_1"><%=arrHisto[0]%></td>
						<td class="TR_bgColor_1"><%=arrHisto[1]%>-<%=arrHisto[2]%></td>
						<td class="TR_bgColor_1"><%=arrHisto[3]%></td>
						<td class="TR_bgColor_1"><%=arrHisto[4]%></td>
						<td class="TR_bgColor_1"><%=arrHisto[5]%></td>
						<td class="TR_bgColor_1"><%=arrHisto[6]%></td>
					</tr>
				</logic:iterate>
			</table>
			<div align="center">
				
				
				<a href="javascript:window.history.back();"><netui:button type="button" value="Volver"/></a>
				
				<input type="button" name="imprime" value="Imprimir"
					onclick="imprimir()" />
					
				<a href="cerrar.jsp"><input type="button" name="cerrar" value="Cerrar"
					onclick= "cerrar.jsp" /></a>
					
			</div>
			
		</form>
	</div>
</body>
</netui:html>
