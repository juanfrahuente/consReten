<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@ taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<netui-data:declareBundle bundlePath="../resources/properties/RetencionesText" name="messages"></netui-data:declareBundle>
<link href="../resources/css/style.css" type="text/css" rel="stylesheet">
<netui:html>
        <tr>
         <td colspan="2" class="bajada"><br>
          <div align="left"><netui:label value="${bundle.messages.TITULO9}"/></div>
         </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.NUMFOLIORETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="creditUniv" property="folio"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.ESTADORETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="creditUniv" property="estado"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.FECHLIQUI}"/></td>
            <td class="parrafo">:
                <bean:write name="creditUniv" property="fechaLiqui"/>
            </td>
        </tr>            
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.GRUPOEGRE}"/></td>
            <td class="parrafo">:
                <bean:write name="creditUniv" property="grupoEgreso"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.YEARRETEN}"/></td>
            <td class="parrafo">:
                <logic:equal value="-1" name="creditUniv" property="retenYear">
                    TODOS
                </logic:equal>
                <logic:notEqual value="-1" name="creditUniv" property="retenYear">
                    <bean:write name="creditUniv" property="retenYear"/>
                </logic:notEqual>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.MONTORETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="creditUniv" property="montoReten"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.MONEDA}"/></td>
            <td class="parrafo">:
                <bean:write name="creditUniv" property="moneda"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.TIPPAGO}"/></td>
            <td class="parrafo">:
                <bean:write name="creditUniv" property="tipoPago"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.RUTADMINUNI}"/></td>
            <td class="parrafo">:
                <bean:write name="creditUniv" property="rut"/>
                -
                <bean:write name="creditUniv" property="dv"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.NOMADMINUNI}"/></td>
            <td class="parrafo">:
                <bean:write name="creditUniv" property="universidad"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.CTACTE}"/></td>
            <td class="parrafo">:
                <bean:write name="creditUniv" property="numCta"/>
            </td>
        </tr>        
        <tr valign="middle">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.OBSERV}"/></td>
            <td class="parrafo">
                <textarea readonly="true" rows="3" style="width:300px"><bean:write name="creditUniv" property="observacion"/></textarea>
            </td>
        </tr> 
</netui:html>