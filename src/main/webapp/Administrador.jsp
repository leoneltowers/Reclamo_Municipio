<%-- 
    Document   : Principal
    Created on : 17 oct. 2022, 01:29:03
    Author     : Leonel_Towers
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="pages/partesIdem/inicioHTML.jsp"/>

<jsp:include page="pages/partesIdem/inicioHead.jsp"/>
<title>Principal</title>
<jsp:include page="pages/partesIdem/finHead.jsp"/>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-light bg-info">
  <!-- Container wrapper -->
  <div class="container-fluid">
  
    <!-- Collapsible wrapper -->
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <!-- Navbar brand -->
      <a class="navbar-brand mt-2 mt-lg-0" href="#">
        <img
          img src="img/logo.png" alt="logo_municipalidad" width="100"
         
        />
      </a>
      <!-- navegacion -->
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a  style = "margin-left:10px; border:none" class="btn btn-outline-light" href="#" target="frame">Inicio</a>
        </li>
        <li class="nav-item">
          <a style = "margin-left:10px; border:none" class="btn btn-outline-light" href="#" target="frame">ADMINISTRADOR</a>
        </li>
        <li class="nav-item">
          <a style = "margin-left:10px; border:none" class="btn btn-outline-light" href="${pageContext.request.contextPath}/administrar?accion=listar" target="frame">Reclamos</a>
        </li>
      </ul>
      <!-- fin vav -->
    </div>
    <!-- perfil-salir -->
    <div class="dropdown">
        <button style ="border:none" class="btn btn-outline-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
          ${usuario.getUser()}
        </button>
         <ul class="dropdown-menu text-center">
             <li><a class="dropdown-item" href="#">Usuario</a></li>
             <li><a class="dropdown-item" href="#">user@gmail.com</a></li>
             <form>
                 <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
             </form>
             
         </ul>
    </div>
    
    
    
  </div>
  <!-- Container wrapper -->
</nav>

<div class="m4" style="height: 550px;">
        <iframe name="frame" style="height: 100%; width: 100%"></iframe>
        
</div>

<jsp:include page="pages/partesIdem/footer.jsp"/>

<jsp:include page="pages/partesIdem/finHTML.jsp"/>   
