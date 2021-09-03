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

Calse extendida de profes para verificacions y disp de horarios: **OrgaProfes**

Clase para ingresar materias: **Materias**

Clase extendida de materias para añadir descripsiones y horarios: **OrgMaterias**

Clase para generar el horario: **Generador**

Clase para generar un horario mas avanzado: **GenAvanz** 

---
### Atributos:
**Contenido Propuesto que tendrán las entidades, así como las funciones**  

**Inicio:** *Aqui se llamaran todas las funciones*  

**Usuarios:**
- Nombre
- Tipo
- Contraseña
- Salir  

* valida() //*valida los datos*

**Profes:**
- Nombre
- Edad 
- Numero
- Domicilio  

* valida() //*valida los datos*


**OrgaProfes:**
- Asignaturas
- Horarios  
* Enl_Mate() //*Enlaza el profe a la materia*
* Val_Hor() //*Valida los horarios de los profes*


**Materias:**
- Nombre
- Descripsion 
- Plan   

* Valida() //*valida los datos de las materias*


**OrgMaterias:**
- Materia
- Horario
- Oportunidad
- Grupo
- Alumnos

* Val_Gpo() // *Valida un numero minimo de alumnos para que se pueda hacer el gpo*
* Gpos_Esp() // *Asigna grupos de oportunidad !=1 *
* Asig_Gpo() // *Asigna la materia a los grupos*

**Generador:**
- Au_Ma // *Indica si el horario se realizara automatico o manual*

* Gen() // *Imprime el Horario*

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

![Grafica UML:](Diagrama)
