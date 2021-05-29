
package biblioteca_mvc;


public class Biblioteca_MVC {

  
    public static void main(String[] args) {
   
                
          FormAutor v = new FormAutor();
//          FormLibro vl = new FormLibro();
//          ModeloAutor m = new ModeloAutor();
//          ControladorAutor c = new ControladorAutor(v,m);
        
          ModeloBiblioteca m = new ModeloBiblioteca();
          ControladorBiblioteca c = new ControladorBiblioteca(v,m);
        
          v.setVisible(true);
       
    }
    
}
