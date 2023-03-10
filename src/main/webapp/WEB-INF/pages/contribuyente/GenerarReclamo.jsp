<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
    Document   : GenerarReclamo
    Created on : 17 oct. 2022, 15:18:17
    Author     : Leonel_Towers
--%>

<jsp:include page="../partesIdem/inicioHTML.jsp"/>

<jsp:include page="../partesIdem/inicioHead.jsp"/>
<title> Generar Reclamos</title>
<jsp:include page="../partesIdem/finHead.jsp"/>
  <body> <br><br>
  <div class="d-flex">
    <div class="card col-sm-4">
     <div class="card-body">
         <form action="${pageContext.request.contextPath}/generar?accion=agregarReclamo&id_user=${usuario.getId_user}" method="POST" class="was-validated">
          <div class="form-group">
            <label>FECHA</label>
            <input type="text" name="txtFecha" class="form-control">
          </div>
          
             
           <div class="form-group">
            <label>CATEGORIA</label>
            <input type="text" name="txtCategoria" class="form-control"><!--pendiente  -->
              
          </div>  
             
          <div class="form-group">
            <label>DOMICILIO</label>
            <input type="text" name="txtDomicilio" class="form-control">
          </div>
         
          <div class="form-group">
            <label>DESCRIPCION</label>
            <input type="text" name="txtDescripcion" class="form-control">
          </div>
          
          <label></label>
          <input type="submit" name="accion" value="Agregar" class="btn btn-success">
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
                 </tr>
       
            </c:forEach>    
        </tbody>

      </table>
        
    </div>   
    
      
  
  </div>

 </body>
   <jsp:include page="../partesIdem/finHTML.jsp"/>


