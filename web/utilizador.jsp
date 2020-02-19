<%@ include file="cabecalho.jsp" %>
<div class="container theme-showcase" role="main">
    <h2 style="text-align: center"><span class="label label-default">Registar utilizador</span></h2>

    <div class="row">

        <div class="form-group col-md-6"> 
            <button type="button" class="btn btn-sm btn-primary">Consultar</button> 

        </div>
        <div class="form-group col-md-8"> 
            <input type="text" class="form-control" id="inputCEP" placeholder="Pesquisa o produto">
        </div>
    </div>

    <div class="row">

        <div class="col-md-5 mb-5">

            <input type="text" class="form-control is-invalid" id="validationServer03" placeholder="Digite o Nome do utilizador" required>
        </div>


        <div class="col-md-5 mb-5">

            <input type="text" class="form-control is-invalid" id="validationServer04" placeholder="Digite o login" required>

        </div>

        <div class="col-md-2 mb-2">
            <input type="text" class="form-control is-invalid" id="validationServer05" placeholder="Digite a senha do utilizador" required>

        </div>
        <hr> 
        <div class="col-md-4 mb-4">
            <select class="mdb-select md-form">
                <option value="" disabled selected>Escolhe o estado do utilizador</option>
                <option value="1">Eletrodomésticos</option>
                <option value="2">Liquidificadores</option>
                <option value="3">Batedeiras</option>
                <option value="3">Cosmetico</option>
                <option value="3">Papel Higieco</option>
                <option value="3">Outros</option>
            </select>
        </div>


        <div class="col-md-4 mb-4">
            <select class="mdb-select md-form">
                <option value="" disabled selected>Escolhe o perfil do utilizador</option>
                <option value="1">Eletrodomésticos</option>
                <option value="2">Liquidificadores</option>
                <option value="3">Batedeiras</option>
                <option value="3">Cosmetico</option>
                <option value="3">Papel Higieco</option>
                <option value="3">Outros</option>
            </select>

        </div>

        </div>
        <hr> <hr> 
        <div class="col-md-4 mb-4">
            <div class="form-group">
                <label class="label label-default" for="exampleFormControlFile1">Escolhe a foto do utilizador</label><p></p>
                <input type="file" class="form-control-file" id="exampleFormControlFile1" />
            </div>

        </div>


        <div class="row">

            <div class="col-md-12">
                <table class="table table-bordered">
                    <thead>
                        <tr>

                            <th>Nome do utilizador</th>
                            <th>Login</th>
                            <th>Senha</th>
                            <th>Estado</th>
                            <th>Perfil</th>
                          

                        </tr>
                    </thead>
                </table>
            </div>

        </div>

        <div class="row">
            <div class="col-md-12">
                <table class="table table-bordered">
                    <thead>
                        <tr>

                            <td>Nome do utilizador</td>
                            <td>Login</td>
                            <td>Senha</td>
                            <td>Estado</td>
                            <td>Perfil</td>

                        </tr>
                    </thead>

                </table>

                <p>
                <button type="button" class="btn btn-sm btn-success">Salvar</button>
                <button type="button" class="btn btn-sm btn-danger">Eliminar</button>
                <button type="button" class="btn btn-warning btn-sm" data-toggle="modal" data-target="#myModal">Editar</button>
                </p>
                
                <!-- Trigger the modal with a button -->


<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Editar o utilizador</h4>
      </div>
      <div class="modal-body">
        <form class="form-inline" action="/action_page.php">
       <p>
  <div class="form-group">
   
      <input style="width: 270px"  type="text" class="form-control" id="email">
  </div>

  <div class="form-group">
    
      <input style="width: 290px" type="text" class="form-control" id="pwd" />
  </div>
       <p></p>  
  <div class="form-group">
    
    <input style="width: 270px" type="text" class="form-control" id="pwd">
  </div>
             
  <div class="form-group">
    <input  style="width: 290px" type="text" class="form-control is-invalid" id="validationServer05" placeholder="Digite o Nome do utilizador" required>

  </div>

 <p></p>
  <div class="form-group">
   
       <select class="mdb-select md-form col-md-6">
                <option value="" disabled selected>Escolhe o estado</option>
                <option value="1">Multicaixa</option>
                <option value="2">Cartão de crédito</option>
                <option value="3">Deposito Bancario</option>
                <option value="3">Cartao de Debito</option>
                <option value="3">Cheque</option>
                <option value="3">Dinheiro</option>
            </select>
      

      
      <select class="mdb-select md-form col-md-6">
                <option value="" disabled selected>Escolhe o perfil</option>
                <option value="1">Multicaixa</option>
                <option value="2">Cartão de crédito</option>
                <option value="3">Deposito Bancario</option>
                <option value="3">Cartao de Debito</option>
                <option value="3">Cheque</option>
                <option value="3">Dinheiro</option>
            </select>
  </div>
</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Sair</button>
      </div>
    </div>

  </div>
</div>

 </div>

        </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.min.js">
    < script src = "http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js" ></script>
</script>
<script>window.jQuery || document.write('<script src="js/jquery.min.js"><\/script>');</script>
<script src="js/bootstrap.min.js"></script>
<script src="js/docs.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
