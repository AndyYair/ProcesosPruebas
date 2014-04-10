<%@ page import="procesostest.ReglaCalculo" %>
<%@ page import="procesostest.Concepto_RC" %>
<%@ page import="procesostest.Proceso" %>

<div class="fieldcontain ${hasErrors(bean: reglaCalculoInstance, field: 'iniVig', 'error')} required">
	<label for="iniVig">
		<g:message code="reglaCalculo.iniVig.label" default="Ini Vig" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="iniVig" precision="day"  value="${reglaCalculoInstance?.iniVig}"  />

</div>
        
<div class="fieldcontain ${hasErrors(bean: reglaCalculoInstance, field: 'finVig', 'error')} required">
	<label for="finVig">
		<g:message code="reglaCalculo.finVig.label" default="Fin Vig" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="finVig" precision="day"  value="${reglaCalculoInstance?.finVig}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: reglaCalculoInstance, field: 'status', 'error')} required">
	<label for="status">
		<g:message code="reglaCalculo.status.label" default="status" />
	</label>
	<g:textField name="status" value="${reglaCalculoInstance?.status}"/>

</div>


<div class="fieldcontain ${hasErrors(bean: reglaCalculoInstance, field: 'formulaConceptual', 'error')} ">
	<label for="formulaConceptual">
		<g:message code="reglaCalculo.formulaConceptual.label" default="Formula Conceptual" />
		
	</label>
	<g:textField name="formulaConceptual" value="${reglaCalculoInstance?.formulaConceptual}"/>

</div>

<div id="formaExplicita" class="fieldcontain ${hasErrors(bean: reglaCalculoInstance, field: 'formulaExplicita', 'error')} ">
	<label for="formulaExplicita">
		<g:message code="reglaCalculo.formulaExplicita.label" default="Formula Explicita, sera determinada por los conceptos seleccionados" />
		
	</label>
	<g:textField name="formulaExplicita" value="${reglaCalculoInstance?.formulaExplicita}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reglaCalculoInstance, field: 'objAfe1', 'error')} ">
	<label for="objAfe1">
		<g:message code="reglaCalculo.objAfe1.label" default="Obj Afe1" />
		
	</label>
	<g:textField name="objAfe1" value="${reglaCalculoInstance?.objAfe1}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reglaCalculoInstance, field: 'attrAfe1', 'error')} ">
	<label for="attrAfe1">
		<g:message code="reglaCalculo.attrAfe1.label" default="Attr Afe1" />
		
	</label>
	<g:textField name="attrAfe1" value="${reglaCalculoInstance?.attrAfe1}"/>

</div>


<div class="fieldcontain ${hasErrors(bean: reglaCalculoInstance, field: 'numConceptos', 'error')} required">
	<label for="numConceptos">
		<g:message code="reglaCalculo.numConceptos.label" default="Num Conceptos" />
		<span class="required-indicator">*</span>
	</label>
        
        <g:select id="numConceptos" name="numConceptos" from="${1..100}" value='' noSelection="['null':'- Primero defina el numero de conceptos.-']"
                  onchange="${remoteFunction(action: 'tratarConceptos', params: '\'cvalue=\'+this.value', update:'conceptos')}" 
         />
       

</div>



<div class="fieldcontain ${hasErrors(bean: reglaCalculoInstance, field: 'pid', 'error')} required">
	<label for="pid">
		<g:message code="reglaCalculo.pid.label" default="Pid" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="pid" name="pid.id" from="${procesostest.Proceso.list()}" optionKey="id" required="" value="${reglaCalculoInstance?.pid?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reglaCalculoInstance, field: 'valorAsignado1', 'error')} ">
	<label for="valorAsignado1">
		<g:message code="reglaCalculo.valorAsignado1.label" default="Valor Asignado1" />
		
	</label>
	<g:textField name="valorAsignado1" value="${reglaCalculoInstance?.valorAsignado1}"/>

</div>

<div id="conceptos">
	
</div>


