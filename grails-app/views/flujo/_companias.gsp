<%@ page import="procesostest.*" %>
<g:select id="nocompania"
       from="${companias}"
       name="nomenclatura" 
       onchange="${remoteFunction(action: 'obtenerNoCompania', params: '\'idpromotora=\'+this.value', update:'idcompania')}"  
       value="" >
</g:select>
