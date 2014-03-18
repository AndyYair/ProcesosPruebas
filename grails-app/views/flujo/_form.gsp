<%@ page import="procesostest.Flujo" %>



<div class="fieldcontain ${hasErrors(bean: flujoInstance, field: 'secuenciapid', 'error')} ">
	<label for="secuenciapid">
		<g:message code="flujo.secuenciapid.label" default="Secuenciapid" />
		
	</label>
	<g:textField name="secuenciapid" value="${flujoInstance?.secuenciapid}"/>
</div>

