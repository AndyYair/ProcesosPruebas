<%@ page import="procesostest.*" %>

<div class="fieldcontain ${hasErrors(bean: flujoInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="flujo.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textField name="descripcion" value="${flujoInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: flujoInstance, field: 'finVig', 'error')} required">
	<label for="finVig">
		<g:message code="flujo.finVig.label" default="Fin Vig" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="finVig" precision="day"  value="${flujoInstance?.finVig}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: flujoInstance, field: 'idpromotora', 'error')} required">
	<label for="idpromotora">
		<g:message code="flujo.idpromotora.label" default="Idpromotora" />
		<span class="required-indicator">*</span>
	</label>
                   <g:select id="idpromotora" name="idpromotora" from="${Promotora.list()}" onchange="${remoteFunction(action: 'getCompanias', params: '\'idpromotora=\'+this.value', update:'divcompanias')}"  optionKey="id" value="${flujoInstance.idpromotora}" noSelection="['null':'- Seleccione una promotora -']" />
	
</div>

<div id="divcompanias" class="fieldcontain ${hasErrors(bean: flujoInstance, field: 'idcompania', 'error')} required">
	                    
</div>

<div class="fieldcontain ${hasErrors(bean: flujoInstance, field: 'iniVig', 'error')} required">
	<label for="iniVig">
		<g:message code="flujo.iniVig.label" default="Ini Vig" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="iniVig" precision="day"  value="${flujoInstance?.iniVig}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: flujoInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="flujo.status.label" default="Status" />
		
	</label>
	<g:textField name="status" value="${flujoInstance?.status}"/>
</div>


