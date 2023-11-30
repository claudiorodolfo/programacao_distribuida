<?php
	//https://www.php.net/manual/pt_BR/class.soapclient.php
	//https://tableless.com.br/novidade-php-7-operador-null-coalesce/
	try {

		$op = ($_POST['operacao'] ?? "");
		$a = ($_POST['parametro1'] ?? 0);
		$b = ($_POST['parametro2'] ?? 0);

		// Cria uma instância de SoapClient
		$url = "http://localhost:8080/CalcWSProvider/Calculadora?WSDL";
		$clienteWS = new SoapClient($url);
		
		//Chamada a função wsdl
		switch($op) {
			case "+":
				$resultado = $clienteWS->adicao(array("a"=>$a,"b"=>$b));
			break;
			case "-":
				$resultado = $clienteWS->subtracao(array("a"=>$a,"b"=>$b));
			break;
			case "*":
				$resultado = $clienteWS->multiplicacao(array("a"=>$a,"b"=>$b));
			break;
			case "/":
				$resultado = $clienteWS->divisao(array("a"=>$a,"b"=>$b));
			break;
			default:
				print "Não deveria estar aqui";
		}
		// Echo the result
		//echo "<pre>".print_r($result, true)."</pre>";
		
		echo "<pre>O resultado da operação " . $op . " é:". $resultado->return ."</pre>";
		
	} catch(Exception $e) {
		print $e->getMessage();
	}
?>