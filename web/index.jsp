<%-- 
    Curso Completo de Java Server Page
   Data da Criação : 9/fev/2020, 17:14:03
   Julio Sebatiao André
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Sistema Gestao - login</title>
        <link rel="icon" type="image/png" sizes="16x16" href="../assets/images/favicon.html">
    <!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous"> -->
    <link href="css/style.css" rel="stylesheet">
    
    </head>
    <body class="h-100">
        <div><h1 style="text-align: center">Administração</h1></div>
       
 
    <div id="preloader">
        <div class="loader">
            <svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
            </svg>
        </div>
    </div>
    <!--*******************
        Preloader end
    ********************-->

    <div class="login-form-bg h-100">
        <div class="container h-100">
            <div class="row justify-content-center h-100">
                <div class="col-xl-6">
                    <div class="form-input-content">
                        <div class="card login-form mb-0">
                            <div class="card-body pt-5">
                                <h4 class="text-center">Usuario</h4>
                                <form class="mt-5 mb-5 login-input" action="LoginServlet" method="POST" >
                                    <div class="form-group">
                                         <i class="fa fa-user fa-2x"></i> <span></span>
                                         <input type="text" class="form-control" placeholder="Nome" name="utilizador" required="true" />
                                    </div>
                                    
                                     <div class="form-group">
                                         <i class="fa fa-user fa-2x"></i> <span></span>
                                         <input type="password" class="form-control" name="senha" required="true" />
                                    </div>
                                  
                                    <button class="btn login-form__btn submit w-100" type="submit">Login</button>
                                </form>
                                                              
                                <div class="mt-5 row justify-content-center login-form__footer" style="color:red;"> 
                                    <%=(request.getAttribute("typeMessage")!=null?"Dados Invalidos!!":"")%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!--**********************************
        Scripts
    ***********************************-->
    <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>
</body>

<!-- Mirrored from demo.themefisher.com/quixlab/page-login.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 29 Aug 2019 16:26:36 GMT -->
</html>







