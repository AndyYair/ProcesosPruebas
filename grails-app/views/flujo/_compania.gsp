<label for="idcompania">
                        <strong>Compañia</strong>
</label>

<select id="idcompania" from="${list}" name="idcompania" value="" >
    <option value="${null}">- Seleccione una compania -</option>
    <g:each var="l" in="${list}">
             <option value="${l.numcomp}">${l}</option>
    </g:each>
</select>