<%-- 
    Document   : GenerarReclamo
    Created on : 17 oct. 2022, 15:18:17
    Author     : Leonel_Towers
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../partesIdem/inicioHTML.jsp"/>

<jsp:include page="../partesIdem/inicioHead.jsp"/>
<title> Administrar Reclamos</title>
<jsp:include page="../partesIdem/finHead.jsp"/>
    
  <body> <br><br>
      
      <div class="d-flex">
    <div class="card col-sm-4">
      <div class="card-body">
          <<h2>ADMINISTRANDO RECLAMOS</h2>
          <form action="${pageContext.request.contextPath}/administrar?accion=update&idReclamo=${editarReclamo.idReclamo}"  method="post" class="was-validated">
             
          <div class="form-group">
            <label>Fecha Creacion</label>
            <input type="text"    Value="${editarReclamo.fechaCreacion}" name="txtFechaCreacion" class="form-control">
          </div>
          <div class="form-group">
            <label>Fecha Resolucion</label>
            <input type="text" value="${editarReclamo.fechaResolucion}" name="txtFechaResolucion" class="form-control">
          </div>  
          <!-- falta categoria pendiente.... -->
          <div class="form-group">
            <label>Domicilio</label>
            <input type="text" value="${editarReclamo.domicilio}" name="txtDomicilio" class="form-control">
          </div>
          
          <div class="form-group">
            <label>Categoria</label>
            <input type="text" value="${editarReclamo.categoria}" name="txtcategoria" class="form-control">
          </div>
          <div class="form-group">
            <label>Descripcion</label>
            <input type="text" value="${editarReclamo.descripcion}" name="txtcategoria" class="form-control">
          </div>
          
          <label></label>
          <h6>Estas seguro que deseas modificar?</h6>
          <button type="submit"   class="btn btn-success">ACTUALIZAR</button>
        </form>
      </div>
    </div>
      
    <div class="col-sm-8">
      <table class="table table-hover">
        <thead>
          <tr>
            <th>ID RECLAMO</th>
            <th>FECHA CREACION</th>
            <th>FECHA RESOLUCION</th>
            
            <th>CATEGORIA</th>
            <th>DOMICILIO</th>
            
            <th>DESCRIPCION</th>
            
            <th>ACCIONES</th>
          </tr>
        </thead>
        
        <tbody>
           <c:forEach var="rec" items="${listarReclamos}" > 
            <tr>
                    <td>${rec.idReclamo}</td>
                    <td>${rec.fechaCreacion}</td>
                    <td>${rec.fechaResolucion}</td>
                    
                    <td>${rec.categoria}</td>
                    <td>${rec.domicilio}</td>
                    <td>${rec.descripcion}</td>
                <td>
                    <a  class="btn btn-warning" href="${pageContext.request.contextPath}/administrar?accion=edit&idReclamo=${rec.idReclamo}">Editar</a>
                    <a class="btn btn-danger"    href="${pageContext.request.contextPath}/administrar?accion=delete&idReclamo=${rec.idReclamo}">Eliminar</a>
                </td>
            </tr>
          </c:forEach>  
        </tbody>
      

      </table>
    </div>

  </div>

      
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
  </body>
  
 <jsp:include page="../partesIdem/finHTML.jsp"/>

