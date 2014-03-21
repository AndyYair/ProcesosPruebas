<%@ page import="procesostest.SecFlujo;procesostest.Proceso" %>



<div class="fieldcontain ${hasErrors(bean: secFlujoInstance, field: 'fid', 'error')} required">
	<label for="fid">
		<g:message code="secFlujo.fid.label" default="Fid" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="fid" name="fid.id" from="${procesostest.Flujo.list()}" optionKey="id" required="" value="${secFlujoInstance?.fid?.id}" class="many-to-one"/>
         <!--create multiple select-->
        <g:select name="secuencia"
                  from="${Proceso.list()}"
                  value="${proceso?.Proceso*.id}"
                  optionKey="id"
                  id="secuencia"
                  multiple="multiple" />
</div>

<div class="fieldcontain ${hasErrors(bean: secFlujoInstance, field: 'secuencia', 'error')} ">
	
</div>

