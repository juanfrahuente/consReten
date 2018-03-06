<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="/WEB-INF/utiles.tld" prefix="utiles"%>
<netui-data:declareBundle bundlePath="../resources/properties/RetencionesText" name="messages"></netui-data:declareBundle>
<link href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css" rel="stylesheet">
<netui:html>
        <tr>
         <td colspan="2" class="bajada"><br>
          <div align="left"><netui:label value="${bundle.messages.TITULO6}"/></div>
         </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.NUMFOLIORETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="egresoCuestion" property="folio"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.ESTADORETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="egresoCuestion" property="estado"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.TIPFORMRETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="egresoCuestion" property="tipoForm"/>
            </td>
        </tr>            
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.CODCTAPRESU}"/></td>
            <td class="parrafo">:
                <bean:write name="egresoCuestion" property="tipoDevo"/>
            </td>
        </tr>
        <tr valign="middle">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.OBSERV}"/></td>
            <td class="parrafo">
                <textarea readonly="true" rows="3" style="width:300px"><bean:write name="egresoCuestion" property="observacion"/></textarea>
            </td>
        </tr>                  
</netui:html>