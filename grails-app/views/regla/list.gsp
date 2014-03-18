
<%@ page import="procesostest.Regla" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'regla.label', default: 'Regla')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-regla" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-regla" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="attrAfe1" title="${message(code: 'regla.attrAfe1.label', default: 'Attr Afe1')}" />
					
						<g:sortableColumn property="attrCond1" title="${message(code: 'regla.attrCond1.label', default: 'Attr Cond1')}" />
					
						<g:sortableColumn property="attrCond2" title="${message(code: 'regla.attrCond2.label', default: 'Attr Cond2')}" />
					
						<g:sortableColumn property="condicion" title="${message(code: 'regla.condicion.label', default: 'Condicion')}" />
					
						<g:sortableColumn property="condicionEnlazada" title="${message(code: 'regla.condicionEnlazada.label', default: 'Condicion Enlazada')}" />
					
						<g:sortableColumn property="descripcion" title="${message(code: 'regla.descripcion.label', default: 'Descripcion')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${reglaInstanceList}" status="i" var="reglaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${reglaInstance.id}">${fieldValue(bean: reglaInstance, field: "attrAfe1")}</g:link></td>
					
						<td>${fieldValue(bean: reglaInstance, field: "attrCond1")}</td>
					
						<td>${fieldValue(bean: reglaInstance, field: "attrCond2")}</td>
					
						<td>${fieldValue(bean: reglaInstance, field: "condicion")}</td>
					
						<td>${fieldValue(bean: reglaInstance, field: "condicionEnlazada")}</td>
					
						<td>${fieldValue(bean: reglaInstance, field: "descripcion")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${reglaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
