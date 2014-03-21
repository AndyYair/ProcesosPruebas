<%@ page import="procesostest.*" %>
<label for="idcompania">
		<g:message code="flujo.idcompania.label" default="Idcompania" />
		<span class="required-indicator">*</span>
</label>
<g:select
       from="${companias.nombcomp}"
       name="compania" value="">
</g:select>