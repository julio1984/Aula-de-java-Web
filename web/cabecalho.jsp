<%-- 
    Curso Completo de Java Server Page
   Data da Criação : 11/fev/2020, 19:50:37
   Julio Sebatiao André
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
     <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/Footer-white.css">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/3.3/examples/theme/">
     <link rel="stylesheet" href="css/demo.css">
     <script src="js/demo.js"></script>

        <title>Projecto Gestão - Desportiva menu</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/theme.css" rel="stylesheet">
    <script src="js/ie-emulation-modes-warning.js"></script>
    </head>
    <body>
       
     
    <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Sistema - Gestão</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Inicio</a></li>
            <li><a href="#about">Sobre Nos</a></li>
     
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Registar<span class="caret"></span></a>
              <ul class="dropdown-menu">
              
                <li role="separator" class="divider"></li>
              
                 <li class="dropdown-header">PRODUTOS SISTEMA</li>
                 <li><a href="Produtos.jsp">Produtos</a></li>
                <li><a href="#">Categoria dos Produtos</a></li>
                
                 <li><a href="#">produtos em Destaques</a></li>
                <li><a href="produto_Stock.jsp">Produtos em Stock</a></li>
                <li role="separator" class="divider"></li>
               
                <li class="dropdown-header">UTILIZADORES DO SISTEMA</li>
                <li><a href="#">Utilizadores</a></li>
                <li><a href="#">Funcionarios</a></li>
                <li><a href="#">Fornecedores</a></li>
                <li><a href="#">Clientes</a></li>
                <li role="separator" class="divider"></li>
                <li role="separator" class="divider"></li>
               
              </ul>
            </li>
            
                 <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Consultar<span class="caret"></span></a>
              <ul class="dropdown-menu">
              
                <li role="separator" class="divider"></li>
              
                 <li class="dropdown-header">PRODUTOS SISTEMA</li>
                 <li><a href="#">Produtos</a></li>
                <li><a href="#">Categoria dos Produtos</a></li>
                
                 <li><a href="#">produtos em Destaques</a></li>
                <li><a href="#">Produtos em Stock</a></li>
                <li role="separator" class="divider"></li>
               
                <li class="dropdown-header">UTILIZADORES DO SISTEMA</li>
                <li><a href="#">Utilizadores</a></li>
                <li><a href="#">Funcionarios</a></li>
                <li><a href="#">Fornecedores</a></li>
                <li><a href="#">Clientes</a></li>
                <li role="separator" class="divider"></li>
                <li role="separator" class="divider"></li>
               
              </ul>
            </li>
            
             <li><a href="contato.jsp">Contacto</a></li>
             <li><a href="index.jsp">Administração</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>