<%@ page import="procesostest.ReglaCalculo" %>

<div id="formaExplicita" class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'formulaExplicita', 'error')} required">
	<label for="formulaExplicita">
		<g:message code="regla.formulaExplicita.label" default="Formula Explicita" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="formulaExplicita"  value="${formulaExplicita}"  rows="5" cols="50"/>
</div>