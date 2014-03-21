
<%@ page import="procesostest.Flujo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'flujo.label', default: 'Flujo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-flujo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-flujo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="descripcion" title="${message(code: 'flujo.descripcion.label', default: 'Descripcion')}" />
					
						<g:sortableColumn property="finVig" title="${message(code: 'flujo.finVig.label', default: 'Fin Vig')}" />
					
						<g:sortableColumn property="idcompania" title="${message(code: 'flujo.idcompania.label', default: 'Idcompania')}" />
					
						<g:sortableColumn property="idpromotora" title="${message(code: 'flujo.idpromotora.label', default: 'Idpromotora')}" />
					
						<g:sortableColumn property="iniVig" title="${message(code: 'flujo.iniVig.label', default: 'Ini Vig')}" />
					
						<g:sortableColumn property="nomenclatura" title="${message(code: 'flujo.nomenclatura.label', default: 'Nomenclatura')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${flujoInstanceList}" status="i" var="flujoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${flujoInstance.id}">${fieldValue(bean: flujoInstance, field: "descripcion")}</g:link></td>
					
						<td><g:formatDate date="${flujoInstance.finVig}" /></td>
					
						<td>${fieldValue(bean: flujoInstance, field: "idcompania")}</td>
					
						<td>${fieldValue(bean: flujoInstance, field: "idpromotora")}</td>
					
						<td><g:formatDate date="${flujoInstance.iniVig}" /></td>
					
						<td>${fieldValue(bean: flujoInstance, field: "nomenclatura")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${flujoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
