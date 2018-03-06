<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<netui-data:declareBundle bundlePath="../resources/properties/RetencionesText" name="messages"></netui-data:declareBundle>
<link href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css" rel="stylesheet">
<netui:html>
        <tr>
         <td colspan="2" class="bajada"><br>
          <div align="left"><netui:label value="${bundle.messages.TITULO3}"/></div>
         </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.NUMFOLIORETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="retJudicial" property="folio"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.ESTADORETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="retJudicial" property="estado"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.CAUSA}"/></td>
            <td class="parrafo">:
                <bean:write name="retJudicial" property="causal"/>
            </td>
        </tr>            
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.ROL}"/></td>
            <td class="parrafo">:
                <bean:write name="retJudicial" property="rol"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.NUMOFICIO}"/></td>
            <td class="parrafo">:
                <bean:write name="retJudicial" property="numOficio"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.YEAROFICIO}"/></td>
            <td class="parrafo">:
                <bean:write name="retJudicial" property="oficioYear"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.GRUPOEGRE}"/></td>
            <td class="parrafo">:
                <bean:write name="retJudicial" property="grupoEgreso"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.YEARRETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="retJudicial" property="retenYear"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.MONTORETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="retJudicial" property="monto"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.MONEDA}"/></td>
            <td class="parrafo">:
                <bean:write name="retJudicial" property="moneda"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.PORCEN}"/></td>
            <td class="parrafo">:
                <bean:write name="retJudicial" property="porcentaje"/>
            </td>
        </tr>        
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.JUZGA}"/></td>
            <td class="parrafo">:
                <bean:write name="retJudicial" property="juzgado"/>
            </td>
        </tr>        
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.TIPPAGO}"/></td>
            <td class="parrafo">:
                <bean:write name="retJudicial" property="tipoPago"/>
            </td>
        </tr>        
        <tr valign="middle">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.OBSERV}"/></td>
            <td class="parrafo">
                <textarea readonly rows="3" style="width:300px"><bean:write name="retJudicial" property="observacion"/></textarea>
            </td>
        </tr> 
</netui:html>