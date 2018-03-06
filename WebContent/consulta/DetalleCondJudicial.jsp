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
          <div align="left"><netui:label value="${bundle.messages.TITULO7}"/></div>
         </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.NUMFOLIORETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="convJudi" property="folio"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.ESTADORETEN}"/></td>
            <td class="parrafo">:
                <bean:write name="convJudi" property="estado"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.TRIBUNAL}"/></td>
            <td class="parrafo">:
                <bean:write name="convJudi" property="juzgado"/>
            </td>
        </tr>            
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.EXPJUDI}"/></td>
            <td class="parrafo">:
                <bean:write name="convJudi" property="numExpe"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.YEAREXPJUDI}"/></td>
            <td class="parrafo">:
                <bean:write name="convJudi" property="expeYear"/>
            </td>
        </tr>

        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.FECHAPROBCONVJUDI}"/></td>
            <td class="parrafo">:
                <bean:write name="convJudi" property="fechAprovConv"/>
            </td>
        </tr>
        <tr valign="top">
            <td class="obtenga_clave"><netui:label value="${bundle.messages.NOMSINDTITU}"/></td>
            <td class="parrafo">:
                <bean:write name="convJudi" property="sindico"/>
            </td>
        </tr>
</netui:html>