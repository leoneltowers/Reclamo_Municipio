<%-- 
    Document   : index
    Created on : 16 oct 2022, 14:59:41
    Author     : Leonel_Towers
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="pages/partesIdem/inicioHTML.jsp"/>

<jsp:include page="pages/partesIdem/inicioHead.jsp"/>
<title> Municipalidad de La Matanza</title>
<jsp:include page="pages/partesIdem/finHead.jsp"/>
<!-- <jsp:include page="pages/partesIdem/nav.jsp"/>-->
 
      <div class="container mt-4 col-lg-4">
          <div class="card col-sm-10 bg-secondary">
              <div class="card-body">
                  <form class="form-sing" action="Controlador" method="post">
                      <div class="form-group text-center">
                          <h3>Login</h3>
                          <img src="img/logo-left.png" alt="logo_municipalidad" width="300"/>
                          <label>Bienvenido al Municipio </label>
                      </div>
                      <div class="form-group">
                          <label>Usuario: </label>
                          <input type="txt" name="txtuser" class="form-control">
                      </div>
                      <div class="form-group">
                          <label>Password: </label>
                          <input type="password" name="txtpass" class="form-control">
                      </div>
                      <br>
                      <input type="submit" name="accion" Value="Ingresar" class="btn btn-primary btn-block">
                      <a href="pages/formulario.html">Registrar Usuario</a>
                  </form>
                  
              </div>
          </div>
          
      </div>
    
<jsp:include page="pages/partesIdem/footer.jsp"/>

<jsp:include page="pages/partesIdem/finHTML.jsp"/>    