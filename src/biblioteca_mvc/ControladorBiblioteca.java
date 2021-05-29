package biblioteca_mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ControladorBiblioteca implements ActionListener , MouseListener {

//  Declara variables
    FormLibro vistaL = new FormLibro();
    FormAutor vista = new FormAutor();
    ModeloBiblioteca modeloB = new ModeloBiblioteca();
   
   
    String Fecha_obtener;
    DaoBiblioteca daoB;
    int id1 = 0;
    int id2 = 0;
    
 
    public ControladorBiblioteca(FormAutor vista, ModeloBiblioteca modeloB) {
        this.modeloB = modeloB;
        this.vista = vista;
                
        daoB = new DaoBiblioteca();
        
        vista.btncrearautor.addActionListener(this);
        vista.btneliminarautor.addActionListener(this);
        vista.btnactualizarautor.addActionListener(this);
        vista.btnagregarlibro.addActionListener(this);
        vista.btnlimpiarautor.addActionListener(this);
        vista.tabla.addMouseListener(this);
        
        
        refrescarTabla();
       
    }

     public ControladorBiblioteca(FormLibro vistaL, ModeloBiblioteca modeloB) {
        this.modeloB = modeloB;
        this.vistaL = vistaL;
        
        daoB = new DaoBiblioteca();
        
        
        
        vistaL.btncrearLibro.addActionListener(this);
        vistaL.btneliminarLibro.addActionListener(this);
        vistaL.btnactualizarLibro.addActionListener(this);
        vistaL.btnlimpiarLibro.addActionListener(this);
        vistaL.tablaLibro.addMouseListener(this);
        
        llenarcombos();
        refrescarTablaLibro();
//       
    }
    
    
    //**************************************************************************
    // Limpiar Pantallas
    //**************************************************************************     
    public void oplimpiarAutor() {
        this.vista.txtnombreautor.setText("");
        this.vista.txtapellidosautor.setText("");
        this.vista.txtnacionalidad.setText("");
        this.vista.txtdireccion.setText("");
        
        refrescarTabla();        
    }

    
    public void oplimpiarLibro() {
        this.vistaL.txtTitulo.setText("");
        this.vistaL.txtEditorial.setText("");
        this.vistaL.txtPaginas.setText("");
        this.vistaL.txtIdlibro.setText("");
        this.vistaL.lbNombreCompleto.setText("");
        this.vistaL.jcomboxgenero.removeAllItems();
        this.vistaL.jcomboIdautor.removeAllItems();
        this.vistaL.jcomboidioma.removeAllItems();
              
  
        refrescarTablaLibro(); 
        llenarcombos();
    }   
    
    //**************************************************************************
    // Insertar Registros
    //**************************************************************************  
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Boton crear Autores
        if (e.getSource() == vista.btncrearautor) {
            modeloB.setNombre(vista.txtnombreautor.getText());
            modeloB.setApellidos(vista.txtapellidosautor.getText());
            modeloB.setNacionalidad(vista.txtnacionalidad.getText());
            modeloB.setDireccion(vista.txtdireccion.getText());

            if (daoB.createAutor(modeloB)) {
                JOptionPane.showMessageDialog(this.vista, "Se inserto los datos ");
            } else {

                JOptionPane.showMessageDialog(this.vista, "no se inserto los registros");
            }
            oplimpiarAutor();
        }

        //Boton crear Libros
        if (e.getSource() == vistaL.btncrearLibro) {
          
            modeloB.setTitulo(vistaL.txtTitulo.getText());    
            modeloB.setEditorial(vistaL.txtEditorial.getText());
            modeloB.setIdioma(vistaL.jcomboidioma.getSelectedItem().toString());
            modeloB.setGenero(vistaL.jcomboxgenero.getSelectedItem().toString());
            modeloB.setPaginas(vistaL.txtPaginas.getText());
            modeloB.setId_autor2(Integer.parseInt(vistaL.jcomboIdautor.getSelectedItem().toString()));
            

            if (daoB.createLibro(modeloB)) {
                JOptionPane.showMessageDialog(this.vistaL, "Se inserto los datos ");
            } else {

                JOptionPane.showMessageDialog(this.vistaL, "no se inserto los registros");
            }
            oplimpiarLibro();
        }
        
     //**************************************************************************
     // Suprimir registros
     //**************************************************************************    
        //Boton Suprimir Autores
        if (e.getSource() == vista.btneliminarautor) {

            int x = JOptionPane.showConfirmDialog(this.vista, "Esta seguro de eliminar fila");
            if (x == 0 && id1 > 0) {
                if (daoB.deleteAutor(id1)) {
                    JOptionPane.showMessageDialog(this.vista, "se Elimino registro");
                } else {
                    JOptionPane.showMessageDialog(this.vista, "No se Elimino registro");
                }

            }
            oplimpiarAutor();
         }
        
       //Boton Suprimir Libros
        if (e.getSource() == vistaL.btneliminarLibro) {

            int x = JOptionPane.showConfirmDialog(this.vistaL, "Esta seguro de eliminar fila");
            if (x == 0 && id2 > 0) {
                if (daoB.deleteLibro(id2)) {
                    JOptionPane.showMessageDialog(this.vistaL, "se Elimino registro");
                } else {
                    JOptionPane.showMessageDialog(this.vistaL, "No se Elimino registro");
                }

            }
            oplimpiarLibro();
         } 
        
        
     //**************************************************************************
     // Actualizar Registro
     //**************************************************************************   
        //Boton Actualizar  Autor
        if (e.getSource() == vista.btnactualizarautor) {
            modeloB.setNombre(vista.txtnombreautor.getText());
            modeloB.setApellidos(vista.txtapellidosautor.getText());
            modeloB.setNacionalidad(vista.txtnacionalidad.getText());
            modeloB.setDireccion(vista.txtdireccion.getText());

            if (!daoB.updateAutor(modeloB)) {
                JOptionPane.showMessageDialog(this.vista, "No se actualizo registro");
                daoB.updateAutor(modeloB);
            }

            oplimpiarAutor();
        }
        
        //Boton Actualizar  Libro
        if (e.getSource() == vistaL.btnactualizarLibro) {
            modeloB.setTitulo(vistaL.txtTitulo.getText());    
            modeloB.setEditorial(vistaL.txtEditorial.getText());
            modeloB.setIdioma(vistaL.jcomboidioma.getSelectedItem().toString());
            modeloB.setGenero(vistaL.jcomboxgenero.getSelectedItem().toString());
            modeloB.setPaginas(vistaL.txtPaginas.getText());
            modeloB.setId_autor2(Integer.parseInt(vistaL.jcomboIdautor.getSelectedItem().toString()));
            
            if (!daoB.updateLibro(modeloB)) {
                JOptionPane.showMessageDialog(this.vistaL, "No se actualizo registro");
                daoB.updateLibro(modeloB);
            }

            oplimpiarLibro();
        }
        
        
        
        //Boton Abrir Limpiar Valores en campos Autor
        if (e.getSource() == vista.btnlimpiarautor) {

            this.oplimpiarAutor();
        }
        
        
        
        //Boton Abrir formularios de Libros
          if (e.getSource() == vista.btnagregarlibro) { 
              vista.setVisible(false);
              LlamarLibros();           
        }
         
              
        
        //Boton Abrir Limpiar Valores en campos Libros
        if (e.getSource() == vistaL.btnlimpiarLibro) {

            this.oplimpiarLibro();
        }
        
        
        
                

          
                 
        
   }
                  
                
    //**************************************************************************
     // Evento del Mouse
     //**************************************************************************  
    
    @Override
    public void mouseClicked(MouseEvent e) {
         
         if (e.getSource() == vista.tabla) {
            int fila = vista.tabla.getSelectedRow();
            id1 = Integer.parseInt(vista.tabla.getValueAt(fila, 0).toString());
            modeloB = daoB.readAutor(id1);
            vista.txtideautor.setText("" + modeloB.getId_autor());
            vista.txtnombreautor.setText(modeloB.getNombre());
            vista.txtapellidosautor.setText(modeloB.getApellidos());
            vista.txtnacionalidad.setText(modeloB.getNacionalidad());
            vista.txtdireccion.setText(modeloB.getDireccion());
        }
         
            if (e.getSource() == vistaL.tablaLibro) {
            int fila = vistaL.tablaLibro.getSelectedRow();
            id2 = Integer.parseInt(vistaL.tablaLibro.getValueAt(fila, 0).toString());
            modeloB = daoB.readLibro(id2);
            
            vista.txtideautor.setText("" + modeloB.getId_autor());
            vista.txtnombreautor.setText(modeloB.getNombre());
            vista.txtapellidosautor.setText(modeloB.getApellidos());
            vista.txtnacionalidad.setText(modeloB.getNacionalidad());
            vista.txtdireccion.setText(modeloB.getDireccion());
            
            vistaL.txtIdlibro.setText("" + modeloB.getId_libro());
            vistaL.txtTitulo.setText(modeloB.getTitulo());
            vistaL.txtEditorial.setText(modeloB.getEditorial());
            vistaL.txtPaginas.setText(modeloB.getPaginas());
            
            this.vistaL.jcomboxgenero.setSelectedItem(0);
            this.vistaL.jcomboIdautor.setSelectedItem(0);
            this.vistaL.jcomboidioma.setSelectedItem(0);
        
            vistaL.jcomboidioma.addItem(modeloB.getIdioma());
            vistaL.jcomboxgenero.addItem(modeloB.getGenero());
            vistaL.jcomboIdautor.addItem(modeloB.getId_autor2().toString());
            
        }
         
      

          
          }

            
            
            
 
    
    
    
    
    
        public void refrescarTabla() {
                        
        while (vista.model.getRowCount() > 0) {
            vista.model.removeRow(0);

        }
        ArrayList<ModeloBiblioteca> lista = daoB.readListaAutor();
        for (ModeloBiblioteca B : lista) {
            Object item[] = new Object[5];
            item[0] = B.getId_autor();
            item[1] = B.getNombre();
            item[2] = B.getApellidos();
            item[3] = B.getNacionalidad();
            item[4] = B.getDireccion();
            vista.model.addRow(item);
        }
        vista.tabla.setModel(vista.model);     
    }

        public void refrescarTablaLibro() {
                        
        while (vistaL.model2.getRowCount() > 0) {
            vistaL.model2.removeRow(0);

        }
        ArrayList<ModeloBiblioteca> lista = daoB.readListalibro();
        for (ModeloBiblioteca B : lista) {
            Object item[] = new Object[7];
            item[0] = B.getId_libro();
            item[1] = B.getTitulo();
            item[2] = B.getEditorial();
            item[3] = B.getIdioma();
            item[4] = B.getPaginas();
            item[5] = B.getGenero();
            item[6] = B.getId_autor2();
            
            
            vistaL.model2.addRow(item);
        }
        vistaL.tablaLibro.setModel(vistaL.model2);     
    }
        
        
        
        
        
    @Override
    public void mousePressed(MouseEvent e) {
      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
   
    }

    @Override
    public void mouseEntered(MouseEvent e) {
         
    }

    @Override
    public void mouseExited(MouseEvent e) {
      
    }
  
     public void LlamarLibros() {
                        
              FormLibro vl = new FormLibro();
              ModeloBiblioteca ml = new ModeloBiblioteca();
              ControladorBiblioteca c1 = new ControladorBiblioteca(vl,ml);
              vista.setVisible(false);
              vl.setVisible(true);
              
      }
  
     public void llenarcombos() {
         daoB.ConsultarAutores(vistaL.jcomboIdautor);
         daoB.ConsultarIdiomas(vistaL.jcomboidioma);
         daoB.ConsultarGenero(vistaL.jcomboxgenero);
         
          int id3 = 0;
          String codautor, nombreapellidos;
          codautor = vistaL.jcomboIdautor.getSelectedItem().toString();
          System.out.println(codautor);
          
          id3 = Integer.parseInt(codautor);
          modeloB = daoB.readAutorNombre(id3);
          nombreapellidos = modeloB.getNombre() +" "+ modeloB.getApellidos();
          System.out.println(nombreapellidos);
          vistaL.lbNombreCompleto.setText(nombreapellidos);
         
     }
    
     
     
     
     
}