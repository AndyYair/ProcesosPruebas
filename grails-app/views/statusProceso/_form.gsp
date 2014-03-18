<%@ page import="procesostest.StatusProceso" %>



<div class="fieldcontain ${hasErrors(bean: statusProcesoInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="statusProceso.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textField name="descripcion" value="${statusProcesoInstance?.descripcion}"/>
</div>

