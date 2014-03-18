<%@ page import="procesostest.Proceso" %>



<div class="fieldcontain ${hasErrors(bean: procesoInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="proceso.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textField name="descripcion" value="${procesoInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: procesoInstance, field: 'nomenclatura', 'error')} ">
	<label for="nomenclatura">
		<g:message code="proceso.nomenclatura.label" default="Nomenclatura" />
		
	</label>
	<g:textField name="nomenclatura" value="${procesoInstance?.nomenclatura}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: procesoInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="proceso.status.label" default="Status" />
		
	</label>
	<g:textField name="status" value="${procesoInstance?.status}"/>
</div>

