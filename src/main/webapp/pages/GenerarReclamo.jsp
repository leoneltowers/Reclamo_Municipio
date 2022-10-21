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
        <form action="">
          <div class="form-group">
            <label>Fecha</label>
            <input type="text" name="txtIdReclamo" class="form-control">
          </div>
          <div class="form-group">
            <label>Tipo de Reclamo</label>
            <input type="text" name="txtIdReclamo" class="form-control">
          </div>
          <div class="form-group">
            <label>Domicilio</label>
            <input type="text" name="txtIdReclamo" class="form-control">
          </div>
          <label></label>
          <input type="submit" name="" value="Agregar" class="btn btn-info">
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
          </tr>
        </thead>

      </table>
    </div>     <div class="card-body">
        <form action="">
          <div class="form-group">
            <label>Fecha</label>
            <input type="text" name="txtIdReclamo" class="form-control">
          </div>
          <div class="form-group">
            <label>Tipo de Reclamo</label>
            <input type="text" name="txtIdReclamo" class="form-control">
          </div>
          <div class="form-group">
            <label>Domicilio</label>
            <input type="text" name="txtIdReclamo" class="form-control">
          </div>
          <label></label>
          <input type="submit" name="" value="Agregar" class="btn btn-info">
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
          </tr>
        </thead>

      </table>
    </div>
    <c:forEach items="${listaReclamos}" var="reclamo"> 
    <tr>
        <td>
          ${reclamo.fechaCreacion}  
        </td>
        <td>
          ${reclamo.fechaResolucion}  
        </td>
        <td>
          ${reclamo.categoria}  
        </td>
        <td>
          ${reclamo.domicilio}  
        </td>
    </tr>
       
    </c:forEach>    

  </div>

      
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
  </body>
   <jsp:include page="pages/partesIdem/finHTML.jsp"/>


