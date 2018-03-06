<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"	prefix="html"%>
<%@ taglib uri="/WEB-INF/utiles.tld" prefix="utiles"%>
<netui-data:declareBundle bundlePath="../resources/properties/RetencionesText" name="messages"></netui-data:declareBundle>
<netui:html>
<head>
<title>Consulta Registros</title>
</head>
<utiles:encabezadoPaginacionTag />
<body>
	<script language="javaScript">
    
    function changeAction(nomAction){
        beginForm.action = nomAction;
        beginForm.submit();
    }
    
</script>
	<link href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css" rel="stylesheet">
	<div align="center" class="titulo">
		<table border="0" width="581" cellspacing="0" cellpadding="0">
			<tr>
				<td height="44" class="tituloSecciones"><netui:label
						value="${bundle.messages.TITULO1}" /></td>
			</tr>
		</table>
	</div>
	<BR>
	<div align="center" class="ClasificacionPF">
		<netui:label value="${bundle.messages.DATPERSONA}" />
	</div>
	<div align="center">
		<netui:errors />
	</div>
	<br>
	<br>
	<div align="center">
		<form name="beginForm" action="">
			<input type="hidden" name="detalle" value="ok">
			<table align="center" width="400">
				<tr valign="top">
					<td class="obtenga_clave" width="45%"><netui:label
							value="${bundle.messages.RUT}" /></td>
					<td class="obtenga_clave" width="55%">: <netui:hidden
							dataSource="pageFlow.beginForm.rut" /> <netui:content
							value="${pageFlow.beginForm.rut}" /> - <netui:hidden
							dataSource="pageFlow.beginForm.dv" /> <netui:content
							value="${pageFlow.beginForm.dv}" />
					</td>
				</tr>
				<tr valign="top">
					<td class="obtenga_clave"><netui:label
							value="${bundle.messages.NOMBRE}" /></td>
					<td class="obtenga_clave">: <bean:write name="persona"
							property="nombre" /> <input type="hidden" name="nombre"
						value="<bean:write name="persona" property="nombre"/>" />
					</td>
				</tr>
				<tr valign="top">
					<td class="obtenga_clave"><netui:label
							value="${bundle.messages.APPPAT}" /></td>
					<td class="obtenga_clave">: <bean:write name="persona"
							property="appPat" /> <input type="hidden" name="appPat"
						value="<bean:write name="persona" property="appPat"/>" />
					</td>
				</tr>
				<tr valign="top">
					<td class="obtenga_clave"><netui:label
							value="${bundle.messages.APPMAT}" /></td>
					<td class="obtenga_clave">: <bean:write name="persona"
							property="appMat" /> <input type="hidden" name="appMat"
						value="<bean:write name="persona" property="appMat"/>" />
					</td>
				</tr>
			</table>
			<br /> &nbsp;
			<logic:equal value="false" name="Error">
				<utiles:paginacionRadioTGR atributo="consulta" formulario="beginForm" variableSession="CONSULTA" action="/ConsRetencionesWeb/consulta/begin.do" />
			</logic:equal>
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td></td>
				</tr>
			</table>
			&nbsp;
			<table cellpadding="1" cellspacing="1" border="0">
				<tr>
      <logic:equal value="false" name="Error">
        <td  align="justify" valign="top">
            <input type="button" onclick="changeAction('<%=request.getContextPath()%>/consulta/ConsDetalle.do');" value="Continuar"/>
        </td>
        <td  align="justify" valign="top">
            <input type="button" onclick="changeAction('<%=request.getContextPath()%>/consulta/ExportaExel.do');" value="Exportar"/>
        </td>
      </logic:equal>
      <td align="justify">
            <input type="button" onclick="javascript:location.href='http://<%=request.getServerName()%>/portal/ofVirtual/aRenta.do'" value="Volver"/>
      </td>            
     </tr>
			</table>
		</form>
	</div>
</body>
</netui:html>