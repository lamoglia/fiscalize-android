<html lang="en">
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <title>OPS Fiscalize PRO</title>
	
	    <!-- Bootstrap -->
	    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    <link href="css/fiscalize.css" rel="stylesheet">
	
	    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	</head>

	<h1>Detalhes da Nota Fiscal</h1><br/>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    
    <div class="container">
	<?php
		include_once 'web_include.php';
		include_once INCLUDE_ROOT.'/controllers/FiscalizeController.class.php';
	
		if(isset($_GET["notaFiscalId"])) {
			$notaFiscalId = $_GET["notaFiscalId"];
	
			$fiscalizeController = new FiscalizeController();
			
			$html = $fiscalizeController->consultarNotaFiscal($notaFiscalId);
			echo $html;
			
		} else {
			echo "Erro! Passe notaFiscalId como parâmetro!";
		}
		
	?>
	</div>
	
</body>
</html>