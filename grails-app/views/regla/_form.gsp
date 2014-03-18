<%@ page import="procesostest.Regla" %>



<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'attrAfe1', 'error')} ">
	<label for="attrAfe1">
		<g:message code="regla.attrAfe1.label" default="Attr Afe1" />
		
	</label>
	<g:textField name="attrAfe1" value="${reglaInstance?.attrAfe1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'attrCond1', 'error')} ">
	<label for="attrCond1">
		<g:message code="regla.attrCond1.label" default="Attr Cond1" />
		
	</label>
	<g:textField name="attrCond1" value="${reglaInstance?.attrCond1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'attrCond2', 'error')} ">
	<label for="attrCond2">
		<g:message code="regla.attrCond2.label" default="Attr Cond2" />
		
	</label>
	<g:textField name="attrCond2" value="${reglaInstance?.attrCond2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'condicion', 'error')} ">
	<label for="condicion">
		<g:message code="regla.condicion.label" default="Condicion" />
		
	</label>
	<g:textField name="condicion" value="${reglaInstance?.condicion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'condicionEnlazada', 'error')} ">
	<label for="condicionEnlazada">
		<g:message code="regla.condicionEnlazada.label" default="Condicion Enlazada" />
		
	</label>
	<g:textField name="condicionEnlazada" value="${reglaInstance?.condicionEnlazada}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="regla.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textField name="descripcion" value="${reglaInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'finVig', 'error')} required">
	<label for="finVig">
		<g:message code="regla.finVig.label" default="Fin Vig" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="finVig" precision="day"  value="${reglaInstance?.finVig}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'iniVig', 'error')} required">
	<label for="iniVig">
		<g:message code="regla.iniVig.label" default="Ini Vig" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="iniVig" precision="day"  value="${reglaInstance?.iniVig}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'objAfe1', 'error')} ">
	<label for="objAfe1">
		<g:message code="regla.objAfe1.label" default="Obj Afe1" />
		
	</label>
	<g:textField name="objAfe1" value="${reglaInstance?.objAfe1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'objCond1', 'error')} ">
	<label for="objCond1">
		<g:message code="regla.objCond1.label" default="Obj Cond1" />
		
	</label>
	<g:textField name="objCond1" value="${reglaInstance?.objCond1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'objCond2', 'error')} ">
	<label for="objCond2">
		<g:message code="regla.objCond2.label" default="Obj Cond2" />
		
	</label>
	<g:textField name="objCond2" value="${reglaInstance?.objCond2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'operador1', 'error')} ">
	<label for="operador1">
		<g:message code="regla.operador1.label" default="Operador1" />
		
	</label>
	<g:textField name="operador1" value="${reglaInstance?.operador1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'operadorCondicion', 'error')} ">
	<label for="operadorCondicion">
		<g:message code="regla.operadorCondicion.label" default="Operador Condicion" />
		
	</label>
	<g:textField name="operadorCondicion" value="${reglaInstance?.operadorCondicion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'operadorEnlace', 'error')} ">
	<label for="operadorEnlace">
		<g:message code="regla.operadorEnlace.label" default="Operador Enlace" />
		
	</label>
	<g:textField name="operadorEnlace" value="${reglaInstance?.operadorEnlace}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'pid', 'error')} required">
	<label for="pid">
		<g:message code="regla.pid.label" default="Pid" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="pid" name="pid.id" from="${procesostest.Proceso.list()}" optionKey="id" required="" value="${reglaInstance?.pid?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'valorAsignado1', 'error')} ">
	<label for="valorAsignado1">
		<g:message code="regla.valorAsignado1.label" default="Valor Asignado1" />
		
	</label>
	<g:textField name="valorAsignado1" value="${reglaInstance?.valorAsignado1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'valorCondicion1', 'error')} ">
	<label for="valorCondicion1">
		<g:message code="regla.valorCondicion1.label" default="Valor Condicion1" />
		
	</label>
	<g:textField name="valorCondicion1" value="${reglaInstance?.valorCondicion1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reglaInstance, field: 'valorCondicion2', 'error')} ">
	<label for="valorCondicion2">
		<g:message code="regla.valorCondicion2.label" default="Valor Condicion2" />
		
	</label>
	<g:textField name="valorCondicion2" value="${reglaInstance?.valorCondicion2}"/>
</div>

