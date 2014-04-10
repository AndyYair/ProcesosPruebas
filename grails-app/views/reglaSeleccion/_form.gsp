<%@ page import="procesostest.ReglaSeleccion" %>



<div class="fieldcontain ${hasErrors(bean: reglaSeleccionInstance, field: 'sqlQuery', 'error')} ">
	<label for="sqlQuery">
		<g:message code="reglaSeleccion.sqlQuery.label" default="Sql Query" />
		
	</label>
	<g:textArea name="sqlQuery" cols="40" rows="5" maxlength="4000" value="${reglaSeleccionInstance?.sqlQuery}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reglaSeleccionInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="reglaSeleccion.status.label" default="Status" />
		
	</label>
	<g:textField name="status" value="${reglaSeleccionInstance?.status}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reglaSeleccionInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="reglaSeleccion.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textField name="descripcion" value="${reglaSeleccionInstance?.descripcion}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reglaSeleccionInstance, field: 'finVig', 'error')} required">
	<label for="finVig">
		<g:message code="reglaSeleccion.finVig.label" default="Fin Vig" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="finVig" precision="day"  value="${reglaSeleccionInstance?.finVig}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: reglaSeleccionInstance, field: 'iniVig', 'error')} required">
	<label for="iniVig">
		<g:message code="reglaSeleccion.iniVig.label" default="Ini Vig" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="iniVig" precision="day"  value="${reglaSeleccionInstance?.iniVig}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: reglaSeleccionInstance, field: 'pid', 'error')} required">
	<label for="pid">
		<g:message code="reglaSeleccion.pid.label" default="Pid" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="pid" name="pid.id" from="${procesostest.Proceso.list()}" optionKey="id" required="" value="${reglaSeleccionInstance?.pid?.id}" class="many-to-one"/>

</div>

