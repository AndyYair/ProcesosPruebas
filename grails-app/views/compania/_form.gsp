<%@ page import="procesostest.Compania" %>



<div class="fieldcontain ${hasErrors(bean: companiaInstance, field: 'clavemon', 'error')} ">
	<label for="clavemon">
		<g:message code="compania.clavemon.label" default="Clavemon" />
		
	</label>
	<g:textField name="clavemon" value="${companiaInstance?.clavemon}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: companiaInstance, field: 'nombcomp', 'error')} ">
	<label for="nombcomp">
		<g:message code="compania.nombcomp.label" default="Nombcomp" />
		
	</label>
	<g:textField name="nombcomp" value="${companiaInstance?.nombcomp}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: companiaInstance, field: 'numcomp', 'error')} required">
	<label for="numcomp">
		<g:message code="compania.numcomp.label" default="Numcomp" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="numcomp" type="number" value="${companiaInstance.numcomp}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: companiaInstance, field: 'numdirec', 'error')} required">
	<label for="numdirec">
		<g:message code="compania.numdirec.label" default="Numdirec" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="numdirec" type="number" value="${companiaInstance.numdirec}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: companiaInstance, field: 'numeprom', 'error')} required">
	<label for="numeprom">
		<g:message code="compania.numeprom.label" default="Numeprom" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="numeprom" type="number" value="${companiaInstance.numeprom}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: companiaInstance, field: 'numorg', 'error')} required">
	<label for="numorg">
		<g:message code="compania.numorg.label" default="Numorg" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="numorg" type="number" value="${companiaInstance.numorg}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: companiaInstance, field: 'rfccomp', 'error')} ">
	<label for="rfccomp">
		<g:message code="compania.rfccomp.label" default="Rfccomp" />
		
	</label>
	<g:textField name="rfccomp" value="${companiaInstance?.rfccomp}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: companiaInstance, field: 'secontrato', 'error')} required">
	<label for="secontrato">
		<g:message code="compania.secontrato.label" default="Secontrato" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="secontrato" type="number" value="${companiaInstance.secontrato}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: companiaInstance, field: 'tcambio', 'error')} required">
	<label for="tcambio">
		<g:message code="compania.tcambio.label" default="Tcambio" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="tcambio" type="number" value="${companiaInstance.tcambio}" required=""/>
</div>

