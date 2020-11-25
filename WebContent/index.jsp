<html>
   <head>
       <meta charset="utf-8">
       <title>Envio de Email</title>
       <script src="https://cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script>
       <script src="resources/js/jquery.min.js"></script>
       <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
       
       <style>
       		.btn{
       			margin: 0 auto;
       			margin-top: 10px;
       			display: block;
       		}
       		
       		.gif-enviando{
				width: 200px;
    			margin-top: 100px;
			    margin-right: auto;
			    margin-bottom: 0px;
			    margin-left: auto;
       			display: block;
       		}
       		
       		.cobertura{
       			background-color: black;
       			width: 100%;
       			height: 100%;
       			opacity: 0.5;
			    display: none;
			    z-index: 1;
			    position: absolute;
       		}
       		
       		.alert{
       			width: 300px;
       			margin-top: 0px;
			    margin-right: auto;
			    margin-bottom: 10px;
			    margin-left: auto;
       		}
       </style>
   </head>
   <body>
   
   <div class="cobertura">
   	<img alt="Enviando" src="resources/img/enviando.gif" class="gif-enviando ">
   </div>
   
  	<form action="email" method="post" name="formulario">
  		 <center><h1>Envio de EMAIL</h1></center>
  		 
  		 <div class="input-group input-group-sm mb-3">
		  <div class="input-group-prepend">
		    <span class="input-group-text" id="inputGroup-sizing-sm">Nome Remetente</span>
		  </div>
		  <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="nomeRemetente">
		</div>
  		 
		<div class="input-group input-group-sm mb-3">
		  <div class="input-group-prepend">
		    <span class="input-group-text" id="inputGroup-sizing-sm">Destinatário *</span>
		  </div>
		  <input type="email" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="destinatario" required="required">
		</div>
		
		<div class="input-group input-group-sm mb-3">
		  <div class="input-group-prepend">
		    <span class="input-group-text" id="inputGroup-sizing-sm">Em cópia</span>
		  </div>
		  <input type="email"  class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="copia">
		</div>
		
		<div class="input-group input-group-sm mb-3">
		  <div class="input-group-prepend">
		    <span class="input-group-text" id="inputGroup-sizing-sm">Assunto</span>
		  </div>
		  <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" name="assunto">
		</div>
		
		   <textarea name="email"></textarea>
		   
		    
		   <button type="submit" class="btn btn-primary ">Enviar</button>
  	</form>
  	
  	
           
   </body>
   
   <script>
       CKEDITOR.replace( 'email' );
       
       $(function(){
			
    	   $("[name=formulario]").on("submit", function(){
    		   $(".cobertura").show();
    		   $(".btn").attr("disabled", "disabled");
    		   $(".btn").html("Enviando email...");
    		   //return false;
    		 })
    	  

       });
       
   </script>
           
           
</html>