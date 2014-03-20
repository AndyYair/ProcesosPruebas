<%@ page import="procesostest.SecFlujo" %>



<div class="fieldcontain ${hasErrors(bean: secFlujoInstance, field: 'fid', 'error')} required">
	<label for="fid">
		<g:message code="secFlujo.fid.label" default="Fid" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="fid" name="fid.id" from="${procesostest.Flujo.list()}" optionKey="id" required="" value="${secFlujoInstance?.fid?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: secFlujoInstance, field: 'secuencia', 'error')} required">
	<label for="secuencia">
		<g:message code="secFlujo.secuencia.label" default="Secuencia" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="secuencia" multiple="true" name="secuencia.id" from="${procesostest.Proceso.list()}" optionKey="id" required="" value="${secFlujoInstance?.secuencia?.id}" class="many-to-one"/>
</div>

