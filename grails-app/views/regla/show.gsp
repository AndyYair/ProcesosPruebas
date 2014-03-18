
<%@ page import="procesostest.Regla" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'regla.label', default: 'Regla')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-regla" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-regla" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list regla">
			
				<g:if test="${reglaInstance?.attrAfe1}">
				<li class="fieldcontain">
					<span id="attrAfe1-label" class="property-label"><g:message code="regla.attrAfe1.label" default="Attr Afe1" /></span>
					
						<span class="property-value" aria-labelledby="attrAfe1-label"><g:fieldValue bean="${reglaInstance}" field="attrAfe1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.attrCond1}">
				<li class="fieldcontain">
					<span id="attrCond1-label" class="property-label"><g:message code="regla.attrCond1.label" default="Attr Cond1" /></span>
					
						<span class="property-value" aria-labelledby="attrCond1-label"><g:fieldValue bean="${reglaInstance}" field="attrCond1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.attrCond2}">
				<li class="fieldcontain">
					<span id="attrCond2-label" class="property-label"><g:message code="regla.attrCond2.label" default="Attr Cond2" /></span>
					
						<span class="property-value" aria-labelledby="attrCond2-label"><g:fieldValue bean="${reglaInstance}" field="attrCond2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.condicion}">
				<li class="fieldcontain">
					<span id="condicion-label" class="property-label"><g:message code="regla.condicion.label" default="Condicion" /></span>
					
						<span class="property-value" aria-labelledby="condicion-label"><g:fieldValue bean="${reglaInstance}" field="condicion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.condicionEnlazada}">
				<li class="fieldcontain">
					<span id="condicionEnlazada-label" class="property-label"><g:message code="regla.condicionEnlazada.label" default="Condicion Enlazada" /></span>
					
						<span class="property-value" aria-labelledby="condicionEnlazada-label"><g:fieldValue bean="${reglaInstance}" field="condicionEnlazada"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.descripcion}">
				<li class="fieldcontain">
					<span id="descripcion-label" class="property-label"><g:message code="regla.descripcion.label" default="Descripcion" /></span>
					
						<span class="property-value" aria-labelledby="descripcion-label"><g:fieldValue bean="${reglaInstance}" field="descripcion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.finVig}">
				<li class="fieldcontain">
					<span id="finVig-label" class="property-label"><g:message code="regla.finVig.label" default="Fin Vig" /></span>
					
						<span class="property-value" aria-labelledby="finVig-label"><g:formatDate date="${reglaInstance?.finVig}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.iniVig}">
				<li class="fieldcontain">
					<span id="iniVig-label" class="property-label"><g:message code="regla.iniVig.label" default="Ini Vig" /></span>
					
						<span class="property-value" aria-labelledby="iniVig-label"><g:formatDate date="${reglaInstance?.iniVig}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.objAfe1}">
				<li class="fieldcontain">
					<span id="objAfe1-label" class="property-label"><g:message code="regla.objAfe1.label" default="Obj Afe1" /></span>
					
						<span class="property-value" aria-labelledby="objAfe1-label"><g:fieldValue bean="${reglaInstance}" field="objAfe1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.objCond1}">
				<li class="fieldcontain">
					<span id="objCond1-label" class="property-label"><g:message code="regla.objCond1.label" default="Obj Cond1" /></span>
					
						<span class="property-value" aria-labelledby="objCond1-label"><g:fieldValue bean="${reglaInstance}" field="objCond1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.objCond2}">
				<li class="fieldcontain">
					<span id="objCond2-label" class="property-label"><g:message code="regla.objCond2.label" default="Obj Cond2" /></span>
					
						<span class="property-value" aria-labelledby="objCond2-label"><g:fieldValue bean="${reglaInstance}" field="objCond2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.operador1}">
				<li class="fieldcontain">
					<span id="operador1-label" class="property-label"><g:message code="regla.operador1.label" default="Operador1" /></span>
					
						<span class="property-value" aria-labelledby="operador1-label"><g:fieldValue bean="${reglaInstance}" field="operador1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.operadorCondicion}">
				<li class="fieldcontain">
					<span id="operadorCondicion-label" class="property-label"><g:message code="regla.operadorCondicion.label" default="Operador Condicion" /></span>
					
						<span class="property-value" aria-labelledby="operadorCondicion-label"><g:fieldValue bean="${reglaInstance}" field="operadorCondicion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.operadorEnlace}">
				<li class="fieldcontain">
					<span id="operadorEnlace-label" class="property-label"><g:message code="regla.operadorEnlace.label" default="Operador Enlace" /></span>
					
						<span class="property-value" aria-labelledby="operadorEnlace-label"><g:fieldValue bean="${reglaInstance}" field="operadorEnlace"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.pid}">
				<li class="fieldcontain">
					<span id="pid-label" class="property-label"><g:message code="regla.pid.label" default="Pid" /></span>
					
						<span class="property-value" aria-labelledby="pid-label"><g:link controller="proceso" action="show" id="${reglaInstance?.pid?.id}">${reglaInstance?.pid?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.valorAsignado1}">
				<li class="fieldcontain">
					<span id="valorAsignado1-label" class="property-label"><g:message code="regla.valorAsignado1.label" default="Valor Asignado1" /></span>
					
						<span class="property-value" aria-labelledby="valorAsignado1-label"><g:fieldValue bean="${reglaInstance}" field="valorAsignado1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.valorCondicion1}">
				<li class="fieldcontain">
					<span id="valorCondicion1-label" class="property-label"><g:message code="regla.valorCondicion1.label" default="Valor Condicion1" /></span>
					
						<span class="property-value" aria-labelledby="valorCondicion1-label"><g:fieldValue bean="${reglaInstance}" field="valorCondicion1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaInstance?.valorCondicion2}">
				<li class="fieldcontain">
					<span id="valorCondicion2-label" class="property-label"><g:message code="regla.valorCondicion2.label" default="Valor Condicion2" /></span>
					
						<span class="property-value" aria-labelledby="valorCondicion2-label"><g:fieldValue bean="${reglaInstance}" field="valorCondicion2"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${reglaInstance?.id}" />
					<g:link class="edit" action="edit" id="${reglaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
