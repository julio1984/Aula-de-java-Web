<%@ include file="cabecalho.jsp" %>
<div class="container theme-showcase" role="main">
    <h2 style="text-align: center"><span class="label label-default">Registo dos Produtos</span></h2>

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

            <input type="text" class="form-control is-invalid" id="validationServer03" placeholder="Digite o Nome do Produto" required>
        </div>


        <div class="col-md-5 mb-5">

            <input type="text" class="form-control is-invalid" id="validationServer04" placeholder="Digite o codBarra" required>

        </div>

        <div class="col-md-2 mb-2">
            <input type="text" class="form-control is-invalid" id="validationServer05" placeholder="Digite a Quantidade" required>

        </div>
        <hr> 
        <div class="col-md-4 mb-4">
            <select class="mdb-select md-form">
                <option value="" disabled selected>Escolhe as Categoria do Produto</option>
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
                <option value="" disabled selected>Escolhe os produtos em destaque</option>
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
                <option value="" disabled selected>Escolhe o nome do Cliente</option>
                <option value="1">Julio Andre</option>
                <option value="2">Misael Andre</option>
                <option value="3">Leopoldo Andre</option>
                <option value="3">Priscila Sapalo</option>
                <option value="3">Vania Andre</option>
                <option value="3">Outros</option>
            </select>

        </div>
        <hr> <hr> 
        <div class="col-md-4 mb-4">
            <div class="form-group">
                <label class="label label-default" for="exampleFormControlFile1">Escolhe a foto do produto</label><p></p>
                <input type="file" class="form-control-file" id="exampleFormControlFile1" />
            </div>

        </div>

        <hr> <hr> 
        <div class="col-md-4 mb-4">
            <select class="mdb-select md-form">
                <option value="" disabled selected>Escolhe as formas de Pagamentos</option>
                <option value="1">Multicaixa</option>
                <option value="2">Cartão de crédito</option>
                <option value="3">Deposito Bancario</option>
                <option value="3">Cartao de Debito</option>
                <option value="3">Cheque</option>
                <option value="3">Dinheiro</option>
            </select>


        </div>

        <hr> <hr> 
        <div class="col-md-4 mb-4">
            <input type="text" class="form-control is-invalid" id="validationServer05" placeholder="Digite o valor do produto" required>

        </div>
        <div class="col-md-4 mb-4">
            <input type="date" class="form-control is-invalid" id="validationServer05"/>

        </div>
        <hr> <hr> 
        <div class="col-md-4 mb-4">
            <select class="mdb-select md-form">
                <option value="" disabled selected>Escolhe o Fabricante</option>
                <option value="1">Paula Alexandre</option>
                <option value="2">Octavio Wola</option>
                <option value="3">Marcio Aleandre</option>
                <option value="3">Herinques Mateus</option>

            </select>


        </div>   
        <hr> <hr> 
        <div class="row">

            <div class="col-md-12">
                <table class="table table-bordered">
                    <thead>
                        <tr>

                            <th>Nome Prod</th>
                            <th>CodBarra</th>
                            <th>Quantidade</th>
                            <th>Categoria</th>
                            <th>ProdDestaque</th>
                            <th>Cliente</th>
                            <th>Formas de Pagamento</th>
                            <th>Fabricante</th> 
                            <th>Date de Expiração</th>
                            <th>Imagem</th>
                            <th>Valor do Produto</th>

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

                            <td>Nome Prod</td>
                            <td>CodBarra</td>
                            <td>Quantidade</td>
                            <td>Categoria</td>
                            <td>ProdDestaque</td>
                            <td>Cliente</td>
                            <td>Formas de Pagamento</td>
                            <td>Fabricante</td>
                            <td>Date de Expiração</td>
                            <td>Imagem</td>
                            <td>Valor do Produto</td>

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
        <h4 class="modal-title">Editar o produto</h4>
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
    <input  style="width: 290px" type="text" class="form-control is-invalid" id="validationServer05" placeholder="Digite o valor do produto" required>

  </div>

 <p></p>
  <div class="form-group">
   
       <select class="mdb-select md-form col-md-6">
                <option value="" disabled selected>Escolhe as categoria dos produto</option>
                <option value="1">Multicaixa</option>
                <option value="2">Cartão de crédito</option>
                <option value="3">Deposito Bancario</option>
                <option value="3">Cartao de Debito</option>
                <option value="3">Cheque</option>
                <option value="3">Dinheiro</option>
            </select>
      

      
      <select class="mdb-select md-form col-md-6">
                <option value="" disabled selected>Escolhe Produto em destaque</option>
                <option value="1">Multicaixa</option>
                <option value="2">Cartão de crédito</option>
                <option value="3">Deposito Bancario</option>
                <option value="3">Cartao de Debito</option>
                <option value="3">Cheque</option>
                <option value="3">Dinheiro</option>
            </select>
       <select class="mdb-select md-form col-md-6">
                <option value="" disabled selected>Escolhe o nome do cliente</option>
                <option value="1">Multicaixa</option>
                <option value="2">Cartão de crédito</option>
                <option value="3">Deposito Bancario</option>
                <option value="3">Cartao de Debito</option>
                <option value="3">Cheque</option>
                <option value="3">Dinheiro</option>
            </select>
       <select class="mdb-select md-form col-md-6">
                <option value="" disabled selected>Escolhe as formas de Pagamentos</option>
                <option value="1">Multicaixa</option>
                <option value="2">Cartão de crédito</option>
                <option value="3">Deposito Bancario</option>
                <option value="3">Cartao de Debito</option>
                <option value="3">Cheque</option>
                <option value="3">Dinheiro</option>
            </select>
        <p>
       <select class="mdb-select md-form col-md-6">
                <option value="" disabled selected>Escolhe o fabricante</option>
                <option value="1">Multicaixa</option>
                <option value="2">Cartão de crédito</option>
                <option value="3">Deposito Bancario</option>
                <option value="3">Cartao de Debito</option>
                <option value="3">Cheque</option>
                <option value="3">Dinheiro</option>
            </select>
       </div> 
       <p>
 <div class="form-group">
    
    <input style="width: 290px" type="date" class="form-control" id="pwd">
  </div>
      </p> 
   <div class="form-group">
    
    <input style="width: 290px" type="text" class="form-control" id="pwd">
  </div>
  </div>
</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
