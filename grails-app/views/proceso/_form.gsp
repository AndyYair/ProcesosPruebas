<%@ page import="procesostest.Proceso" %>



<div class="fieldcontain ${hasErrors(bean: procesoInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="proceso.status.label" default="Status" />
		
	</label>
	<g:textField name="status" value="${procesoInstance?.status}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: procesoInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="proceso.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textField name="descripcion" value="${procesoInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: procesoInstance, field: 'fid', 'error')} required">
	<label for="fid">
		<g:message code="proceso.fid.label" default="Fid" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="fid" name="fid.id" from="${procesostest.Flujo.list()}" optionKey="id" required="" value="${procesoInstance?.fid?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: procesoInstance, field: 'finVig', 'error')} required">
	<label for="finVig">
		<g:message code="proceso.finVig.label" default="Fin Vig" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="finVig" precision="day"  value="${procesoInstance?.finVig}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: procesoInstance, field: 'iniVig', 'error')} required">
	<label for="iniVig">
		<g:message code="proceso.iniVig.label" default="Ini Vig" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="iniVig" precision="day"  value="${procesoInstance?.iniVig}"  />
</div>

