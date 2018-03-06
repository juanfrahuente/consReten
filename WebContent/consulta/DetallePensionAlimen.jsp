<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<netui-data:declareBundle bundlePath="../resources/properties/RetencionesText" name="messages"></netui-data:declareBundle>
<link href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css" rel="stylesheet">
<netui:html>
        <tr>
         <td colspan="2" class="bajada"><br>
          <div align="left"><netui:label value="${bundle.messages.TITULO10}"/></div>
         </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.NUMFOLIORETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="pensionAlimen" property="folio"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.ESTADORETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="pensionAlimen" property="estado"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.YEARRETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="pensionAlimen" property="retenYear"/>
            </td>
        </tr>            
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.RIT}"/></td>
            <td class="parrafo">:
                <bean:write name="pensionAlimen" property="rit"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.RUC}"/></td>
            <td class="parrafo">:
                <bean:write name="pensionAlimen" property="ruc"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.MONTORETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="pensionAlimen" property="montoReten"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.JUZGA}"/></td>
            <td class="parrafo">:
                <bean:write name="pensionAlimen" property="juzgado"/>
            </td>
        </tr>
        <tr>
         <td colspan="2" class="bajada"><br>
          <div align="left"><netui:label value="${bundle.messages.TITULO11}"/></div>
         </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.RUT}"/></td>
            <td class="parrafo">:
                <bean:write name="pensionAlimen" property="rutBene"/>
                -
                <bean:write name="pensionAlimen" property="dvBene"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.NOMRAZONC}"/></td>
            <td class="parrafo">:
                <bean:write name="pensionAlimen" property="appPatBene"/>&nbsp;<bean:write name="pensionAlimen" property="appMatBene"/>&nbsp;<bean:write name="pensionAlimen" property="nombreBene"/>                
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.NUMEROCTA}"/></td>
            <td class="parrafo">:
                <bean:write name="pensionAlimen" property="numCta"/>
            </td>
        </tr>            
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.BANCO}"/></td>
            <td class="parrafo">:
                <bean:write name="pensionAlimen" property="banco"/>
            </td>
        </tr>
        <tr valign="middle">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.OBSERV}"/></td>
            <td class="parrafo">
                <textarea readonly="true" rows="3" style="width:300px"><bean:write name="pensionAlimen" property="observacion"/></textarea>
            </td>
        </tr>                  
</netui:html>