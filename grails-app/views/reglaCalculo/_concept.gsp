<%@ page import="procesostest.Concepto_RC" %>
<g:hiddenField name="contador" value="contador"/><!--IMPORTANTE para no repetir el ciclo infinitamente recuperamos el último valor del contador, de lo contrario se reinicializa-->
<!--div class="fieldcontain ${hasErrors(bean: reglaCalculoInstance, field: 'formulaExplicita', 'error')} "-->
<br>
<label for="operadorInicial">
		<g:message code="reglaCalculo.operadorInicial.label" default="Op.Ini." />
</label>
    <g:checkBox name="query_${contador}"   value="${params.query}"/>
    <g:select name="opIni" from="${['', '+', '-', '*', '/', '%', '^']}" value="" />
    <g:select name="opt1" from="${['(', ')', '']}" value=""  />
   <label for="cid">
		<g:message code="reglaCalculo.concepto.label" default="Concepto" />	
    </label>
        <g:select id="cid" name="cid" from="${procesostest.Concepto_RC.list()}" 
                optionKey="valor" optionValue="descripcion" required="true" value="${reglaCalculoInstance?.formulaExplicita}"  
                noSelection="['null':'- Seleccione un CONCEPTO -']"
        />
        <g:select name="opt2" from="${['(', ')', '']}" value=""  />
<br>
<!--/div-->   
