
package biblioteca_mvc;

import java.util.Date;


public class ModeloBiblioteca {
 
 //Declaracion variabbles del Autor
 Integer id_autor;
 String  nombre;
 String  apellidos;
 String  nacionalidad;
 String  direccion;

 //Declaracion variables del Libro
 Integer id_libro;
 String  titulo;
 String  editorial;
 String  genero;
 String  idioma;
 String  paginas;
 Integer id_autor2;
 
 public ModeloBiblioteca (){
//    System.out.println("se ingreso el libro");
}

 //Estructura para recibir informacion de Autor
 public ModeloBiblioteca(Integer id_autor, String nombre, String apellidos, String nacionalidad, String direccion) {
        this.id_autor = id_autor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
    }

 //Estructura para recibir informacion de Autor
    public ModeloBiblioteca(String nombre, String apellidos, String nacionalidad, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
    }
 
  //Estructura para recibir informacion de Libro

    public ModeloBiblioteca(Integer id_libro, String titulo, String editorial, String genero, String idioma, String paginas, Integer id_autor2) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.editorial = editorial;
        this.genero = genero;
        this.idioma = idioma;
        this.paginas = paginas;
        this.id_autor2 = id_autor2;
    }
  

    //Estructura para recibir informacion de Libro
    public ModeloBiblioteca(String titulo, String editorial, String genero, String idioma, String paginas, Integer id_autor2) { 
        this.titulo = titulo;
        this.editorial = editorial;
        this.genero = genero;
        this.idioma = idioma;
        this.paginas = paginas;
        this.id_autor2 = id_autor2;
    }

    //Metodos Autor
    public Integer getId_autor() {
        return id_autor;
    }
    public void setId_autor(Integer id_autor) {
        this.id_autor = id_autor;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    //Metodos Libro
    public Integer getId_libro() {
        return id_libro;
    }
    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
   
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public String getPaginas() {
        return paginas;
    }
    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }
    public Integer getId_autor2() {
        return id_autor2;
    }
    public void setId_autor2(Integer id_autor2) {
        this.id_autor2 = id_autor2;
    }

  
    }

    
