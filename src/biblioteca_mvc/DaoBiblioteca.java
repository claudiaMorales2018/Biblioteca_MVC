package biblioteca_mvc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class DaoBiblioteca {

    Conexion c;

    public DaoBiblioteca() {
        c = new Conexion();
    }
  
  //Metodos ABC - Crear Nuevos Autores
  public boolean createAutor(ModeloBiblioteca B) {

        String sql = "INSERT INTO autor(nombre,apellidos,nacionalidad,direccion)VALUES(?,?,?,?) ";
        try {
            PreparedStatement ps = c.Conectar().prepareStatement(sql);
            ps.setString(1, B.getNombre());
            ps.setString(2, B.getApellidos());
            ps.setString(3, B.getNacionalidad());
            ps.setString(4, B.getDireccion());
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;

        } catch (SQLException ex) {
            System.out.println("No se Inserto registros");
            return false;
        }   
    }

  //Metodos ABC - Mostar dentro del arreglo a los autores
     public ArrayList<ModeloBiblioteca> readListaAutor() {
        ArrayList<ModeloBiblioteca> lista = new ArrayList<ModeloBiblioteca>();
        try {

            String sql = "SELECT * FROM autor";

            PreparedStatement ps = c.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ModeloBiblioteca B = new ModeloBiblioteca();
                B.setId_autor(rs.getInt("id_autor"));
                B.setNombre(rs.getString("nombre"));
                B.setApellidos(rs.getString("apellidos"));
                B.setNacionalidad(rs.getString("nacionalidad"));
                B.setDireccion(rs.getString("direccion"));
                lista.add(B);
            }
            ps.close();
            ps = null;
            c.desconectar();

        } catch (SQLException ex) {
            System.out.println("Fallo la lectura");
            System.out.println(ex);
        }
        return lista;
    }

  //Metodos ABC - Actualizar información de Autores
  public boolean updateAutor (ModeloBiblioteca B ){
  
   String sql = "UPDATE  autor SET nombre=?,apellidos=?,nacionalidad=?,direccion=? WHERE id_autor=? ";
        try {
            PreparedStatement ps = c.Conectar().prepareStatement(sql);
            ps.setString(1, B.getNombre());
            ps.setString(2, B.getApellidos());
            ps.setString(3, B.getNacionalidad());
            ps.setString(4, B.getDireccion());
            ps.setInt (5, B.getId_autor());
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;

        } catch (SQLException ex) {
            return false;

        }
  
  } 
  
   //Metodos ABC - Actualizar información de Autores
    public ModeloBiblioteca readAutor(int id) {
       ModeloBiblioteca B = new ModeloBiblioteca();
        try {

            String sql = "SELECT * FROM autor  WHERE id_autor=?";
            PreparedStatement ps = c.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                B.setId_autor(rs.getInt("id_autor"));
                B.setNombre(rs.getString("nombre"));
                B.setApellidos(rs.getString("apellidos"));
                B.setNacionalidad(rs.getString("nacionalidad"));
                B.setDireccion(rs.getString("direccion"));
               
            }
            ps.close();
            ps = null;
            c.desconectar();

        } catch (SQLException ex) {
            System.out.println("Fallo la lectura de Autor");
        }
        return B;
    }
    
    
    //Metodos ABC - Actualizar información de Autores
    public ModeloBiblioteca readAutorNombre(int id) {
       ModeloBiblioteca B = new ModeloBiblioteca();
        try {

            String sql = "SELECT nombre,apellidos FROM autor  WHERE id_autor=?";
            PreparedStatement ps = c.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                B.setNombre(rs.getString("nombre"));
                B.setApellidos(rs.getString("apellidos"));                           
            }
            ps.close();
            ps = null;
            c.desconectar();

        } catch (SQLException ex) {
            System.out.println("Fallo la lectura de Autor");
        }
        return B;
    }
    
    
    //Metodos ABC - Suprimir información Autores
      public  boolean deleteAutor (int id){
    
        try {
            String sql="DELETE FROM autor WHERE id_autor=? ";
            PreparedStatement ps=c.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            ps=null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
          return false;
        }
    }
  
   //************************************************************************************************************
   //Metodos ABC - Crear Nuevos Libros
   public boolean createLibro(ModeloBiblioteca B) {

        String sql = "INSERT INTO libro(titulo,editorial,idioma,paginas,genero,id_autor)VALUES(?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = c.Conectar().prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, B.getTitulo());
            ps.setString(2, B.getEditorial());
            ps.setString(3, B.getIdioma());
            ps.setString(4, B.getPaginas());
            ps.setString(5, B.getGenero());
            ps.setInt(6, B.getId_autor2());
            System.out.println(ps);
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;

        } catch (SQLException ex) {
            System.out.println("No se Inserto libros");
            return false;

        }   
    }  
   
 //Metodos ABC - Mostar dentro del arreglo a los libros
 public ArrayList<ModeloBiblioteca> readListalibro() {
     
        ArrayList<ModeloBiblioteca> lista = new ArrayList<ModeloBiblioteca>();
        try {

            String sql = "SELECT * FROM libro";

            PreparedStatement ps = c.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ModeloBiblioteca B = new ModeloBiblioteca();
                B.setId_libro(rs.getInt("id_libro"));
                B.setTitulo(rs.getString("titulo"));
                B.setEditorial(rs.getString("editorial"));
                B.setIdioma(rs.getString("idioma"));
                B.setPaginas(rs.getString("paginas"));
                B.setGenero(rs.getString("genero"));
                B.setId_autor2(rs.getInt("id_autor"));
                lista.add(B);
            }
            ps.close();
            ps = null;
            c.desconectar();

        } catch (SQLException ex) {
            System.out.println("Fallo la lectura");
        }
        return lista;
    }    
  
 //Metodos ABC - Actualizar dentro del arreglo a los libros
  public boolean updateLibro (ModeloBiblioteca B){
  
   String sql = "UPDATE  libro SET titulo=?,editorial=?,idioma=?,paginas=?,genero=?,id_autor=? WHERE id_libro=? ";
        try {
            PreparedStatement ps = c.Conectar().prepareStatement(sql);
            ps.setString(1, B.getTitulo());
            ps.setString(2, B.getEditorial()); 
            ps.setString(3, B.getIdioma());
            ps.setString(4, B.getPaginas());
            ps.setString (5, B.getGenero());
            ps.setInt(6, B.getId_autor2());
            ps.setInt(7, B.getId_libro());
                       
            System.out.println(sql);
            System.out.println(ps);
            
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;

        } catch (SQLException ex) {
            return false;

        }
  
  }  
 
  //Metodos ABC - Actualizar información de Libros
 public ModeloBiblioteca readLibro(int id) {
       ModeloBiblioteca B= new ModeloBiblioteca();
        try {

            String sql = "SELECT * FROM libro  WHERE id_libro=?";
            PreparedStatement ps = c.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                B.setId_libro(rs.getInt("id_libro"));
                B.setTitulo(rs.getString("titulo"));
                B.setEditorial(rs.getString("editorial"));
                B.setIdioma(rs.getString("idioma"));
                B.setPaginas(rs.getString("paginas"));
                B.setGenero(rs.getString("genero"));
                B.setId_autor2(rs.getInt("id_autor"));
               
            }
            ps.close();
            ps = null;
            c.desconectar();

        } catch (SQLException ex) {
            System.out.println("Fallo la lectura de Libro");
        }
        return B;
    }
  
 
 
 //Metodos ABC - Suprimir información de Libros
   public  boolean deleteLibro (int id){
    
        try {
            String sql="DELETE FROM libro WHERE id_libro=? ";
            PreparedStatement ps=c.Conectar().prepareStatement(sql);
            ps.setInt(1, id);                   
            ps.execute();
            ps.close();
            ps=null;
            c.desconectar();
            return true;
        } catch (SQLException ex) {
          return false;
        }
    }
   
   
   
  //Metodos ABC - Mostar dentro del arreglo a los libros
 public void ConsultarAutores(JComboBox cbox_autor) {
     
        
        try {

            String sql = "SELECT id_autor  FROM autor ORDER BY id_autor ASC";

            PreparedStatement ps = c.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbox_autor.addItem(rs.getInt("id_autor"));                             
            }
            ps.close();
            ps = null;
            c.desconectar();

        } catch (SQLException ex) {
            System.out.println("Fallo la lectura");
        }
        
    }    
 
   public void ConsultarIdiomas(JComboBox cbox_idiomas) {
     
        
        try {

            String sql = "SELECT distinct idioma FROM libro ORDER BY idioma ASC";

            PreparedStatement ps = c.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbox_idiomas.addItem(rs.getString("idioma"));                             
            }
            ps.close();
            ps = null;
            c.desconectar();

        } catch (SQLException ex) {
            System.out.println("Fallo la lectura");
        }
        
    }
   
      public void ConsultarGenero(JComboBox cbox_generos) {
     
        
        try {

            String sql = "SELECT distinct genero FROM libro ORDER BY genero ASC";

            PreparedStatement ps = c.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbox_generos.addItem(rs.getString("genero"));                             
            }
            ps.close();
            ps = null;
            c.desconectar();

        } catch (SQLException ex) {
            System.out.println("Fallo la lectura");
        }
        
    }
   
   
   
     
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

