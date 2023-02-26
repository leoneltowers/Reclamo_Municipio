<%-- 
    Document   : RegistrarPersona
    Created on : 27 oct. 2022, 01:27:26
    Author     : Leonel_Towers
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<jsp:include page="../partesIdem/inicioHTML.jsp"/>

<jsp:include page="../partesIdem/inicioHead.jsp"/>
<title> Registrar Persona</title>
<jsp:include page="../partesIdem/finHead.jsp"/>
<div class="container mt-8 col-lg-12">    
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
              <div class="card text-black" style="border-radius: 25px;">
                <div class="card-body p-md-5">
                  <div class="row justify-content-center">
                    <div class="col-md-10 col-lg-6 col-xl-6 order-2 order-lg-1">
      
                      <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Registrarse</p>
      
                      <form class="mx-1 mx-md-4" action="${pageContext.request.contextPath}/registrarUsuario?accion=registrarse" method="post">
      
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                          
                          <div class="form-outline flex-fill mb-0">
                            <input type="text" id="dni" name ="dni" class="form-control" />
                            <label class="form-label" for="form3Example1c">Tu DNI</label>
                          </div>
                        </div>
                          
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                          
                          <div class="form-outline flex-fill mb-0">
                            <input type="text" id="nom" name ="nombre" class="form-control" />
                            <label class="form-label" for="form3Example1c">Tu nombre</label>
                          </div>
                        </div>

                        <div class="d-flex flex-row align-items-center mb-4">
                            <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                            <div class="form-outline flex-fill mb-0">
                              <input type="text" id="ape" name ="apellido" class="form-control" />
                              <label class="form-label" for="form3Example1c">Tu apellido</label>
                            </div>
                          </div>
      
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <input type="email" id="email" name="email" class="form-control" />
                            <label class="form-label" for="form3Example3c">Tu Email</label>
                          </div>
                        </div>
      
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <input type="txt" id="tel" name="telefono" class="form-control" />
                            <label class="form-label" for="form3Example4c">Tu telefono</label>
                          </div>
                        </div>
                        <!--crear usuario -->
                        
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <input type="text" id="form3Example3c" name="usuario" class="form-control" />
                            <label class="form-label" for="form3Example3c">Nombre de usuario</label>
                          </div>
                        </div>
      
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <input type="password" id="form3Example4c" name="password" class="form-control" />
                            <label class="form-label" for="form3Example4c">Contraseña</label>
                          </div>
                        </div>
      
                        <div class="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                          <div class="form-outline flex-fill mb-0">
                            <input type="password" id="form3Example4cd" name="Rpass"class="form-control" />
                            <label class="form-label" for="form3Example4cd">Repite tu contraseña</label>
                          </div>
                        </div>
      
                        <div class="form-check d-flex justify-content-center mb-5">
                          <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3c" />
                          <label class="form-check-label" for="form2Example3">
                            I agree all statements in <a href="#!">Terms of service</a>
                          </label>
                        </div>
                          
                        
                        <!--fin usuario -->
                          
                          
      
                        <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                          <button  type="submit"  class="btn btn-primary btn-lg">Registrarse</button>                      
                        </div>
                        
                        <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                        <a   href="${pageContext.request.contextPath}/index.jsp">Volver a la pagina principal</a>
                        </div>
      
                      </form>
      
                    <!-- </div>
                     <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
      
                      <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                        class="img-fluid" alt="Sample image"> 
      
                    </div> -->
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
<jsp:include page="../partesIdem/footer.jsp"/>

<jsp:include page="../partesIdem/finHTML.jsp"/> 