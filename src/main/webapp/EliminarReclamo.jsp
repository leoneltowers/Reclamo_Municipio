<%-- 
    Document   : GenerarReclamo
    Created on : 17 oct. 2022, 15:18:17
    Author     : Leonel_Towers
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="pages/partesIdem/inicioHTML.jsp"/>

<jsp:include page="pages/partesIdem/inicioHead.jsp"/>
<title> Administrar Reclamos</title>
<jsp:include page="pages/partesIdem/finHead.jsp"/>
    
  <body> <br><br>
      
      <div class="d-flex">
    <div class="card col-sm-4">
      <div class="card-body">
          <h2>ELIMINANDO RECLAMOS</h2>
          <form action="${pageContext.request.contextPath}/administrar?accion=delete&idReclamo=${editarReclamo.idReclamo}" method="POST" class="was-validated">
             
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
            <input type="text" value="${editarReclamo.idReclamo}" name="txtDomicilio" class="form-control">
          </div>
          <label></label>
          <h6>Estas seguro de eliminar?</h6>
          <button type="submit" name="accion" Value="update"class="btn btn-danger">Elimiar de forma permanente</button>
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
            <th>ACCIONES</th>
          </tr>
        </thead>
        
        <tbody>
           <c:forEach var="rec" items="${listarReclamos}" > 
            <tr>
                    <td>${rec.idReclamo}</td>
                    <td>${rec.fechaCreacion}</td>
                    <td>${rec.fechaResolucion}</td>
                    <td>PENDIENTE</td>
                    <td>${rec.domicilio}</td>
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
  
 <jsp:include page="pages/partesIdem/finHTML.jsp"/>

