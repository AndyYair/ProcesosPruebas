<label for="secuencia">
		<g:message code="secflujoflujo.secuencia.label" default="Procesos" />
		<span class="required-indicator">*</span>
</label>

<select id="secuencia" from="${list}" name="secuencia" value="" multiple="true">
    <g:each var="l" in="${list}">
             <option value="${l.id}">${l}</option>
    </g:each>
</select>