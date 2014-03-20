
<%@ page import="procesostest.Compania" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'compania.label', default: 'Compania')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-compania" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-compania" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="clavemon" title="${message(code: 'compania.clavemon.label', default: 'Clavemon')}" />
					
						<g:sortableColumn property="nombcomp" title="${message(code: 'compania.nombcomp.label', default: 'Nombcomp')}" />
					
						<g:sortableColumn property="numcomp" title="${message(code: 'compania.numcomp.label', default: 'Numcomp')}" />
					
						<g:sortableColumn property="numdirec" title="${message(code: 'compania.numdirec.label', default: 'Numdirec')}" />
					
						<g:sortableColumn property="numeprom" title="${message(code: 'compania.numeprom.label', default: 'Numeprom')}" />
					
						<g:sortableColumn property="numorg" title="${message(code: 'compania.numorg.label', default: 'Numorg')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${companiaInstanceList}" status="i" var="companiaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${companiaInstance.id}">${fieldValue(bean: companiaInstance, field: "clavemon")}</g:link></td>
					
						<td>${fieldValue(bean: companiaInstance, field: "nombcomp")}</td>
					
						<td>${fieldValue(bean: companiaInstance, field: "numcomp")}</td>
					
						<td>${fieldValue(bean: companiaInstance, field: "numdirec")}</td>
					
						<td>${fieldValue(bean: companiaInstance, field: "numeprom")}</td>
					
						<td>${fieldValue(bean: companiaInstance, field: "numorg")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${companiaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
