# Producto Integrador de Aprendizaje - POO
___
___

 ### Datos del alumno
* **Nombre:** Rocha Moreno Ricardo   
* **Matricula:** 2076182
___
### Introduccion
Una secundaria tiene problemas para generar y administrar los horarios, pues muchos maestros no tienen facilidad de horario y siempre tiene problemas de empalmamiento de horarios, ademas se les dificulta imprimir el horario.  

**Solucion:** Realizar una interfaz grafica donde el usuario pueda almacenar los profesores y las materias ademas de condicionar los horarios de los profesores que no tengan disponibilidad y generar aleaotoriamente el horario complete e imprimirlo
___
### Entidades:
**Primeras Clases Propuestas Para La Aplicacion**    

Clase De La Funcion Principal: **Inicio**

Clase Respecto a la administrasion de usuarios: **Usuarios**

Clase para ingresar a profesores: **Profes** 

Calse extendida de profes para verificacions y disp de horarios: **OrgaProfes** -Se modifico a Gestprofes-

Clase para ingresar materias: **Materias**

Clase extendida de materias para añadir descripsiones y horarios: **OrgMaterias** -Se modifico a GestUsuarios-

Clase para generar el horario: **Generador**

Clase para generar un horario mas avanzado: **GenAvanz** -Se elimino esta clase-

---
### Atributos:
**Contenido Propuesto que tendrán las entidades, así como las funciones**  

**Inicio:** *Aqui se llamaran todas las funciones*  

**Usuarios:**
- Nombre
- Tipo
- Contraseña

**GestUsuarios:** 

* menu() //*Menu donde se mandan a llamar metodos*
* IngresarUsArchvios() //*Agrega usuarios a los archivos*
* AgregarUs() //*solicita los datos de los usuarios *
* MostrarU() //*Muestra los datos de los usuarios *
* BuscarUs() //*Busca los datos de los usuarios *

**Profes:**
- Nombre
- Materia
- Edad 
- Numero
- Domicilio  



**GestProfes:**
* menu() //*Menu donde se mandan a llamar metodos*
* IngresarProfes() //*Agrega maestros a los archivos*
* AgregarUs() //*solicita los datos de los maestros *
* MostrarU() //*Muestra los datos de los maestros *
* BuscarUs() //*Busca los datos de los maestros *



**Generador:**
* menu() //*Menu donde se mandan a llamar metodos*
* IngresarArchivos() //*Agrega los horarios a los archivos*
* AgregarHorario() //*solicita los datos de los maestros *
* Mostrar_hor() //*Muestra el horario de los maestros *
* Buscar_profes() //*Busca los datos de los maestros *

**GenAvanz** 

* Gen() // *Imprime horario especifico solo para gerarquia mas alta*

---
### Funcionalidades
**Funcionalidades Propuestas Para La Aplicacion** 
- Hora() // *Imprime hora*
- bd_alumns() // *guarda los alumnos*
- bd_mates() // *guarda las materias*
- bd_horarios() // *guarda los horarios realizados*

---

![Grafica UML:](Diagrama ER de DBMS (notación UML) (1).png)
