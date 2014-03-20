<%@ page import="procesostest.Flujo" %>



<div class="fieldcontain ${hasErrors(bean: flujoInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="flujo.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textField name="descripcion" value="${flujoInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: flujoInstance, field: 'idpromotora', 'error')} required">
	<label for="idpromotora">
		<g:message code="flujo.idpromotora.label" default="Idpromotora" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="idpromotora" name="idpromotora" from="${procesostest.Promotora.list()}" optionKey="id" required="" value="${flujoInstance?.idpromotora}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: flujoInstance, field: 'idcompania', 'error')} required">
	<label for="idcompania">
		<g:message code="flujo.idcompania.label" default="Idcompania" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="idcompania" name="idcompania" from="${procesostest.Compania.list()}" optionKey="numcomp" required="" value="${flujoInstance?.idcompania}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: flujoInstance, field: 'nomenclatura', 'error')} ">
	<label for="nomenclatura">
		<g:message code="flujo.nomenclatura.label" default="Nomenclatura" />
		
	</label>
	<g:textField name="nomenclatura" value="${flujoInstance?.nomenclatura}"/>
</div>

