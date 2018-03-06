<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<netui-data:declareBundle bundlePath="../resources/properties/RetencionesText" name="messages"></netui-data:declareBundle>
<link href="<%=request.getContextPath()%>/resources/css/style.css"
	type="text/css" rel="stylesheet">
<netui:html>
<tr>
	<td colspan="2" class="bajada"><br>
		<div align="left">
			<netui:label value="${bundle.messages.TITULO4}" />
		</div></td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.NUMFOLIORETEN}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="folio" />
	</td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.ESTADORETEN}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="estado" />
	</td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.TIPOMANDATO}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="subTipoRet" />
	</td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.NUMOFICIO}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="numOficio" />
	</td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.YEAROFICIO}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="oficioYear" />
	</td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.GRUPOEGRE}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="grupoEgreso" />
	</td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.YEARRETEN}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="retenYear" />
	</td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.MONTORETEN}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="monto" />
	</td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.MONEDA}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="moneda" />
	</td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.PORCEN}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="porcentaje" />
	</td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.TIPPAGO}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="tipoPago" />
	</td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.FECHMANDATO}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="fechMandato" />
	</td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.RUTMANDATARIO}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="rut" /> - <bean:write name="retPorManda" property="dv" />
	</td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.NOMMANDATARIO}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="appPat" />&nbsp;<bean:write name="retPorManda"
			property="appMat" />&nbsp;<bean:write name="retPorManda"
			property="nombre" />
	</td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.RUTREPRELEGAL}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="repLegal" />
	</td>
</tr>
<tr valign="top">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.NUMEROCTA}" /></td>
	<td class="parrafo">: <bean:write name="retPorManda"
			property="tipoCta" />&nbsp;<netui:label
			value="${bundle.messages.NUMERO}" />&nbsp;<bean:write
			name="retPorManda" property="numeroCta" />&nbsp;DEL&nbsp;<bean:write
			name="retPorManda" property="banco" />
	</td>
</tr>
<tr valign="middle">
	<td class="obtenga_clave"><netui:label
			value="${bundle.messages.OBSERV}" /></td>
	<td class="parrafo"><textarea readonly="true" rows="3"
			style="width: 300px"><bean:write name="retPorManda"
				property="observacion" /></textarea></td>
</tr>
</netui:html>