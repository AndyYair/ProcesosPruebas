
<%@ page import="procesostest.Compania" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'compania.label', default: 'Compania')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-compania" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-compania" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list compania">
			
				<g:if test="${companiaInstance?.clavemon}">
				<li class="fieldcontain">
					<span id="clavemon-label" class="property-label"><g:message code="compania.clavemon.label" default="Clavemon" /></span>
					
						<span class="property-value" aria-labelledby="clavemon-label"><g:fieldValue bean="${companiaInstance}" field="clavemon"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companiaInstance?.nombcomp}">
				<li class="fieldcontain">
					<span id="nombcomp-label" class="property-label"><g:message code="compania.nombcomp.label" default="Nombcomp" /></span>
					
						<span class="property-value" aria-labelledby="nombcomp-label"><g:fieldValue bean="${companiaInstance}" field="nombcomp"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companiaInstance?.numcomp}">
				<li class="fieldcontain">
					<span id="numcomp-label" class="property-label"><g:message code="compania.numcomp.label" default="Numcomp" /></span>
					
						<span class="property-value" aria-labelledby="numcomp-label"><g:fieldValue bean="${companiaInstance}" field="numcomp"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companiaInstance?.numdirec}">
				<li class="fieldcontain">
					<span id="numdirec-label" class="property-label"><g:message code="compania.numdirec.label" default="Numdirec" /></span>
					
						<span class="property-value" aria-labelledby="numdirec-label"><g:fieldValue bean="${companiaInstance}" field="numdirec"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companiaInstance?.numeprom}">
				<li class="fieldcontain">
					<span id="numeprom-label" class="property-label"><g:message code="compania.numeprom.label" default="Numeprom" /></span>
					
						<span class="property-value" aria-labelledby="numeprom-label"><g:fieldValue bean="${companiaInstance}" field="numeprom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companiaInstance?.numorg}">
				<li class="fieldcontain">
					<span id="numorg-label" class="property-label"><g:message code="compania.numorg.label" default="Numorg" /></span>
					
						<span class="property-value" aria-labelledby="numorg-label"><g:fieldValue bean="${companiaInstance}" field="numorg"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companiaInstance?.rfccomp}">
				<li class="fieldcontain">
					<span id="rfccomp-label" class="property-label"><g:message code="compania.rfccomp.label" default="Rfccomp" /></span>
					
						<span class="property-value" aria-labelledby="rfccomp-label"><g:fieldValue bean="${companiaInstance}" field="rfccomp"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companiaInstance?.secontrato}">
				<li class="fieldcontain">
					<span id="secontrato-label" class="property-label"><g:message code="compania.secontrato.label" default="Secontrato" /></span>
					
						<span class="property-value" aria-labelledby="secontrato-label"><g:fieldValue bean="${companiaInstance}" field="secontrato"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${companiaInstance?.tcambio}">
				<li class="fieldcontain">
					<span id="tcambio-label" class="property-label"><g:message code="compania.tcambio.label" default="Tcambio" /></span>
					
						<span class="property-value" aria-labelledby="tcambio-label"><g:fieldValue bean="${companiaInstance}" field="tcambio"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${companiaInstance?.id}" />
					<g:link class="edit" action="edit" id="${companiaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
