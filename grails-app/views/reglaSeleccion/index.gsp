
<%@ page import="procesostest.ReglaSeleccion" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reglaSeleccion.label', default: 'ReglaSeleccion')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-reglaSeleccion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-reglaSeleccion" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="sqlQuery" title="${message(code: 'reglaSeleccion.sqlQuery.label', default: 'Sql Query')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'reglaSeleccion.status.label', default: 'Status')}" />
					
						<g:sortableColumn property="descripcion" title="${message(code: 'reglaSeleccion.descripcion.label', default: 'Descripcion')}" />
					
						<g:sortableColumn property="finVig" title="${message(code: 'reglaSeleccion.finVig.label', default: 'Fin Vig')}" />
					
						<g:sortableColumn property="iniVig" title="${message(code: 'reglaSeleccion.iniVig.label', default: 'Ini Vig')}" />
					
						<th><g:message code="reglaSeleccion.pid.label" default="Pid" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${reglaSeleccionInstanceList}" status="i" var="reglaSeleccionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${reglaSeleccionInstance.id}">${fieldValue(bean: reglaSeleccionInstance, field: "sqlQuery")}</g:link></td>
					
						<td>${fieldValue(bean: reglaSeleccionInstance, field: "status")}</td>
					
						<td>${fieldValue(bean: reglaSeleccionInstance, field: "descripcion")}</td>
					
						<td><g:formatDate date="${reglaSeleccionInstance.finVig}" /></td>
					
						<td><g:formatDate date="${reglaSeleccionInstance.iniVig}" /></td>
					
						<td>${fieldValue(bean: reglaSeleccionInstance, field: "pid")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${reglaSeleccionInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
