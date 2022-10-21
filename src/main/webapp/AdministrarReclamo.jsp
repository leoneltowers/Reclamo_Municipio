<%-- 
    Document   : GenerarReclamo
    Created on : 17 oct. 2022, 15:18:17
    Author     : Leonel_Towers
--%>

<jsp:include page="pages/partesIdem/inicioHTML.jsp"/>

<jsp:include page="pages/partesIdem/inicioHead.jsp"/>
<title> Administrar Reclamos</title>
<jsp:include page="pages/partesIdem/finHead.jsp"/>
    
  <body> <br><br>
      
      <div class="d-flex">
    <div class="card col-sm-4">
      <div class="card-body">
        <form action="">
          <div class="form-group">
            <label>Fecha Creacion</label>
            <input type="text" name="txtFechaCreacion" class="form-control">
          </div>
            <div class="form-group">
            <label>Fecha Resolucion</label>
            <input type="text" name="txtFechaResolucion" class="form-control">
          </div>  
          <div class="form-group">
            <label>Categoria</label>
            <input type="text" name="txtTipo" class="form-control">
          </div>
          <div class="form-group">
            <label>Domicilio</label>
            <input type="text" name="txtIdReclamo" class="form-control">
          </div>
          <label></label>
          <input type="submit" name="" value="Actualizar" class="btn btn-info">
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
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <a class="btn btn-warning" href="#">Editar</a>
                    <a class="btn btn-danger" href="#">Eliminar</a>
                </td>
            </tr>
        </tbody>
      

      </table>
    </div>

  </div>

      
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
  </body>
  
 <jsp:include page="pages/partesIdem/finHTML.jsp"/>

