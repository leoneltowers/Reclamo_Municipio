<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
    Document   : GenerarReclamo
    Created on : 17 oct. 2022, 15:18:17
    Author     : Leonel_Towers
--%>

<jsp:include page="pages/partesIdem/inicioHTML.jsp"/>

<jsp:include page="pages/partesIdem/inicioHead.jsp"/>
<title> Generar Reclamos</title>
<jsp:include page="pages/partesIdem/finHead.jsp"/>
  <body> <br><br>
  <div class="d-flex">
    <div class="card col-sm-4">
     <div class="card-body">
         <form action="generar" method="POST">
          <div class="form-group">
            <label>Fecha Creacion</label>
            <input type="text" name="txtFecha" class="form-control">
          </div>
          <div class="form-group">
            <label>Tipo de Reclamo</label>
            <input type="text" name="txtTipo" class="form-control"><!--pendiente  -->
              
          </div>
          <div class="form-group">
            <label>Domicilio</label>
            <input type="text" name="txtDomicilio" class="form-control">
          </div>
          <label></label>
          <input type="submit" name="accion" value="Agregar" class="btn btn-info">
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
            <!--falta categoria -->
            <th>DOMICILIO</th>
          </tr>
        </thead>
        
        <tbody> 
           <c:forEach var="rec" items="${listarReclamos}" > 
                <tr>
                    <td>${rec.idReclamo}</td>
                    <td>${rec.fechaCreacion}</td>
                    <td>${rec.fechaResolucion}</td>
                    
                    <td>${rec.domicilio}</td>
                 </tr>
       
            </c:forEach>    
        </tbody>

      </table>
        
    </div>   
    
      
  
  </div>

 </body>
   <jsp:include page="pages/partesIdem/finHTML.jsp"/>


