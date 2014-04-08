<head>
                                     <link rel="stylesheet" href="${resource(dir: 'css', file: 'jquery-ui-1.10.4.custom.css')}" type="text/css">
                                     <script src="${resource(dir: 'js', file: 'jquery-1.10.2.js')}"></script>
                                     <script src="${resource(dir: 'js', file: 'jquery-ui-1.10.4.custom.js')}"></script>
                                     <style type="text/css">
                                                     ul { list-style-type: none; margin: 0; padding: 0; margin-bottom: 10px; }
                                                     li { margin: 5px; padding: 5px; width: 250px; font-size: 13px; font-family: Trebuchet MS;}
                                      </style>
                                     <script type="text/javascript">
                                                $(function() {
                                                                  $( "#sortable" ).sortable({
                                                                            update: function(event, ui) {
                                                                            var newOrder = $(this).sortable('toArray').toString();
                                                                            document.getElementById('secuencia').value = newOrder;
                                                                            }
                                                                   });
                                                                  $( "#sortable" ).disableSelection();
                                                });
                                     </script>
	</head>    

<label for="secuencia">
		<g:message code="secflujoflujo.secuencia.label" default="Procesos" />
		<span class="required-indicator">*</span>
</label>

          <ul id="sortable">
                   <g:each status="i" var="l" in="${list}">
                            
                       <li  class="ui-state-default" id="${l.id}">${l}</li>
                   </g:each>
         </ul>

<input id="secuencia" name="secuencia" type="text" hidden>
