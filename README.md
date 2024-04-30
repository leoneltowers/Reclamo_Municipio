Un municipio te encomienda un pequeño prototipo de sistema web con persistencia a través de una 
base de datos relacional que permita procesar los reclamos que las personas realizan sobre algún 
inmueble particular.
La información que interesa mantener registrada es la siguiente:
▪ Personas: Tendrán un ID único, además del DNI, nombre, apellido, mail y teléfono movil.
▪ Reclamos: Tendrán un ID único, la fecha en que se creó y la fecha en que se resolvió (esta 
última puede no existir si aún no se ha resuelto), la categoría (alumbrado, arbolado, limpieza, 
pluvial) y el domicilio del inmueble sobre afectado.
Se desea un sistema con dos tipos de usuarios:
▪ El administrador será capaz de manejar las altas, bajas, modificaciones y consultas de cada 
de los reclamos. Además, le debe ser posible visualizar los reclamos pendientes de 
resolución, discriminados por categoría, teniendo la posibilidad de marcarlos como 
resueltos. Para ello, debe loguearse con su usuario y contraseña.
▪ El contribuyente será capaz de ver sus reclamos (resueltos o no) y generar nuevos. Para ello, 
debe loguearse con su usuario y contraseña. Si es la primera vez que ingresa al sitio, deberá 
ser capaz de registrarse con un usuario y contraseña.
FORMATO DE ENTREGA
Subir los cambios a su repositorio de GitHub y compartir el enlace en la instancia de examen 
habilitada en Microsoft Teams. El repositorio debe ser público o bien privado, pero con permiso de 
acceso al docente para poder efectuar la corrección.
El formato de entrega es EXCLUYENTE. No se aceptan archivos adjuntos.
El repositorio debe contener:
▪ El proyecto Java, con el siguiente nombre:
INSPT-ProgII-2602-fi-2022-reclamos-municipio-TUAPELLIDO-TUNOMBRE
▪ El Diagrama Entidad-Relación de la base de datos.
▪ El/los archivos que permitan regenerar la base de datos de forma local (si es que no se trabaja 
con base de datos en la nube).
No cumplir con alguna indicación del formato de entrega disminuye la nota del examen.
2
Carrera: Tec. Sup. En Informática Aplicada
Materia: Programación II
Comisión: 2-602 TT
Profesor:Carlos E. Cimino 
Título: Examen Final
Versión: 2022.10.24 
Esta obra está bajo una Licencia Creative Commons Atribución-NoComercial-CompartirIgual 4.0 
Internacional.
CRITERIOS DE EVALUACIÓN
Para considerar aprobado el examen, el mismo debe demostrar la correcta aplicación de los 
siguientes conceptos de la programación orientada a objetos, el diseño de base de datos y el 
lenguaje Java:
▪ Definición de clases y asignación adecuada de sus responsabilidades.
▪ Encapsulamiento, ocultando detalles de implementación y utilizando métodos getters y 
setters sólo cuando corresponda.
▪ Modularización reutilizable y mantenible, usando funciones con correcta 
parametrización, aplicando alta cohesión y bajo acoplamiento.
▪ Correcta implementación de los constructores.
▪ Validación de los datos que ingresan al sistema.
▪ Aplicación de herencia y polimorfismo, incluyendo interfaces.
▪ Excepciones chequeadas y no chequeadas.
▪ Generics y colecciones.
▪ Patrón MVC, asignando a cada componente las responsabilidades adecuadas.
▪ Aplicaciones web utilizando servlets, JSP y JSTL.
▪ Diseño de la base de datos y pasaje a tablas.
▪ Acceso a bases de datos con JDBC
▪ Algoritmos precisos, finitos y eficientes.
▪ Buenas prácticas de programación:
o Uso de constantes en lugar de números mágicos.
o Nombres de variables, métodos y clases descriptivos, que sigan la convención del 
lenguaje.
o Uso adecuado de los ciclos. No alterar la naturaleza de los mismos utilizando 
instrucciones de control como break y continue (puede desacreditar el examen).
o Código ordenado e indentado correctamente.
