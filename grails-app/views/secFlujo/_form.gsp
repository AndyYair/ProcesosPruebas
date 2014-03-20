<%@ page import="procesostest.SecFlujo" %>



<div class="fieldcontain ${hasErrors(bean: secFlujoInstance, field: 'secuencia', 'error')} ">
	<label for="secuencia">
		<g:message code="secFlujo.secuencia.label" default="Secuencia" />
		
	</label>
	<g:textField name="secuencia" value="${secFlujoInstance?.secuencia}"/>
</div>

