<%@ page import="procesostest.*" %>
<label for="idcompania">
		<g:message code="flujo.idcompania.label" default="Idcompania" />
		<span class="required-indicator">*</span>
</label>
<g:textField name="idcompania" value="${numcompania}"/>
<g:select
       from="${companias}"
       name="nomenclatura" value="" >
</g:select>