<%@ page import="procesostest.Promotora" %>



<div class="fieldcontain ${hasErrors(bean: promotoraInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="promotora.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${promotoraInstance?.nombre}"/>
</div>

