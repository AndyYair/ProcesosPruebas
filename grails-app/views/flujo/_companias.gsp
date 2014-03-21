<%@ page import="procesostest.*" %>
<g:select id="nocompania"
       from="${companias}"
       name="nomenclatura" 
       onchange="${remoteFunction(action: 'obtenerNoCompania', params: '\'idpromotora=\'+this.value', update:'id_compania')}"  
       value="" >
</g:select>
<%@ page import="procesostest.*" %>
<label for="idcompania">
		<g:message code="flujo.idcompania.label" default="Idcompania" />
		<span class="required-indicator">*</span>
</label>
<g:textField name="idcompania" value="${numcompania}"/>