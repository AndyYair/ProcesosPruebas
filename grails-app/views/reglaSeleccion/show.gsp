
<%@ page import="procesostest.ReglaSeleccion" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reglaSeleccion.label', default: 'ReglaSeleccion')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-reglaSeleccion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-reglaSeleccion" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list reglaSeleccion">
			
				<g:if test="${reglaSeleccionInstance?.sqlQuery}">
				<li class="fieldcontain">
					<span id="sqlQuery-label" class="property-label"><g:message code="reglaSeleccion.sqlQuery.label" default="Sql Query" /></span>
					
						<span class="property-value" aria-labelledby="sqlQuery-label"><g:fieldValue bean="${reglaSeleccionInstance}" field="sqlQuery"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaSeleccionInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="reglaSeleccion.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${reglaSeleccionInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaSeleccionInstance?.descripcion}">
				<li class="fieldcontain">
					<span id="descripcion-label" class="property-label"><g:message code="reglaSeleccion.descripcion.label" default="Descripcion" /></span>
					
						<span class="property-value" aria-labelledby="descripcion-label"><g:fieldValue bean="${reglaSeleccionInstance}" field="descripcion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaSeleccionInstance?.finVig}">
				<li class="fieldcontain">
					<span id="finVig-label" class="property-label"><g:message code="reglaSeleccion.finVig.label" default="Fin Vig" /></span>
					
						<span class="property-value" aria-labelledby="finVig-label"><g:formatDate date="${reglaSeleccionInstance?.finVig}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaSeleccionInstance?.iniVig}">
				<li class="fieldcontain">
					<span id="iniVig-label" class="property-label"><g:message code="reglaSeleccion.iniVig.label" default="Ini Vig" /></span>
					
						<span class="property-value" aria-labelledby="iniVig-label"><g:formatDate date="${reglaSeleccionInstance?.iniVig}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${reglaSeleccionInstance?.pid}">
				<li class="fieldcontain">
					<span id="pid-label" class="property-label"><g:message code="reglaSeleccion.pid.label" default="Pid" /></span>
					
						<span class="property-value" aria-labelledby="pid-label"><g:link controller="proceso" action="show" id="${reglaSeleccionInstance?.pid?.id}">${reglaSeleccionInstance?.pid?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:reglaSeleccionInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${reglaSeleccionInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
