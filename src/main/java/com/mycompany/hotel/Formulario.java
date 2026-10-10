/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Formulario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Formulario.class.getName());

  
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JTextField txtEdad;
    private JTextField txtCantSencilla;
    private JTextField txtCantDoble;
    private JTextField txtCantSuite;
    private JButton btnProcesar;
    private JButton btnEliminar; 
     private JButton btnActualizar;
    
    

    /**
     * Creates new form Formulario
     */
    public Formulario() {
       
        TipoHabitacion.SENCILLA.setTarifaBase(80);
        TipoHabitacion.DOBLE.setTarifaBase(150);
        TipoHabitacion.SUITE.setTarifaBase(250);
        
        initComponents();
    }

          /**
    
     */
    private void eliminarUsuarioPorFormulario() {
        // 1. Desplegar el pop-up que solicita el ID del usuario
        String id_usuario = JOptionPane.showInputDialog(this, 
                "Ingrese el id_usuario del huésped que desea eliminar:", 
                "Eliminar Huésped", 
                JOptionPane.QUESTION_MESSAGE);

    
        if (id_usuario == null) {
            return; 
        }

      
        id_usuario = id_usuario.trim();

      
        if (id_usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Debe ingresar un id_usuario válido para proceder.", 
                "Campo Vacío", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

       
        int confirmar = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de que desea eliminar permanentemente al usuario con id_usuario: " + id_usuario + "?", 
            "Confirmar Eliminación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.WARNING_MESSAGE);

        if (confirmar == JOptionPane.YES_OPTION) {
            try {
              
                UsuarioDAO usuarioDAO = new UsuarioDAO(); 
                boolean exito = usuarioDAO.eliminar(id_usuario); 

                if (exito) {
                    JOptionPane.showMessageDialog(this, 
                        "Usuario con id_usuario '" + id_usuario + "' eliminado correctamente.", 
                        "Éxito", 
                        JOptionPane.INFORMATION_MESSAGE);
                    
                    
                 
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "No se encontró ningún registro con el id_usuario: " + id_usuario, 
                        "Error de Búsqueda", 
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, 
                    "Error al conectar con la base de datos: " + ex.getMessage(), 
                    "Error Crítico", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    
    
    
    
    
    
    
    
    
    /**
     
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Usuarios y Alquiler - Hotel");
        setSize(550, 520); // Aumentado ligeramente para dar espacio cómodo a los botones
        setLocationRelativeTo(null);
        
        
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;

        // =========================================================================
        // APARTADO 1: INFORMACIÓN DEL USUARIO (Campos con recuadro para llenar)
        // =========================================================================
        JPanel panelUsuario = new JPanel(new GridLayout(3, 2, 8, 8));
        panelUsuario.setBorder(BorderFactory.createTitledBorder("1. Información del Usuario"));

        panelUsuario.add(new JLabel("Nombre del usuario:"));
        txtNombre = new JTextField();
        panelUsuario.add(txtNombre);

        panelUsuario.add(new JLabel("Número de identificación:"));
        txtCedula = new JTextField();
        panelUsuario.add(txtCedula);

        panelUsuario.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        panelUsuario.add(txtEdad);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelPrincipal.add(panelUsuario, gbc);

        // =========================================================================
        // APARTADO 2: INFORMACIÓN DEL ALQUILER (Texto plano + Espacio blanco de cantidad)
        // =========================================================================
        JPanel panelAlquiler = new JPanel(new GridLayout(3, 3, 10, 10));
        panelAlquiler.setBorder(BorderFactory.createTitledBorder("2. Información del Alquiler"));

      
        panelAlquiler.add(new JLabel("Habitación Sencilla"));
        txtCantSencilla = new JTextField("0");
        panelAlquiler.add(txtCantSencilla);
        panelAlquiler.add(new JLabel("Precio: $" + TipoHabitacion.SENCILLA.getTarifaBase()));

        
        panelAlquiler.add(new JLabel("Habitación Doble"));
        txtCantDoble = new JTextField("0");
        panelAlquiler.add(txtCantDoble);
        panelAlquiler.add(new JLabel("Precio: $" + TipoHabitacion.DOBLE.getTarifaBase()));

       
        panelAlquiler.add(new JLabel("Habitación Suite"));
        txtCantSuite = new JTextField("0");
        panelAlquiler.add(txtCantSuite);
        panelAlquiler.add(new JLabel("Precio: $" + TipoHabitacion.SUITE.getTarifaBase()));

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelPrincipal.add(panelAlquiler, gbc);

        
        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 10, 0)); 

        btnProcesar = new JButton("Procesar Registro");
        btnProcesar.setFont(new Font("Arial", Font.BOLD, 13));
        panelBotones.add(btnProcesar);

        btnActualizar = new JButton("Actualizar Huésped"); 
        btnActualizar.setFont(new Font("Arial", Font.BOLD, 13));
        btnActualizar.setBackground(new Color(0, 123, 255)); 
        btnActualizar.setForeground(Color.WHITE);
        panelBotones.add(btnActualizar);

        btnEliminar = new JButton("Eliminar Huésped");
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 13));
        btnEliminar.setBackground(new Color(220, 53, 69)); 
        btnEliminar.setForeground(Color.WHITE);          
        panelBotones.add(btnEliminar);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(15, 5, 5, 5);
        panelPrincipal.add(panelBotones, gbc);

       
        getContentPane().add(panelPrincipal);

      
        btnProcesar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarFormularioOOHibrido();
            }
        });
        
        
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarUsuarioPorFormulario();
            }
        });
        
        
      

        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarUsuarioPorFormulario();
            }
        });
        
        pack();
        setSize(550, 520);
    }// </editor-fold>

                  

   
    private void procesarFormularioOOHibrido() {
        try {
           
            String nombre = txtNombre.getText().trim();
            String cedula = txtCedula.getText().trim();
            String edadRaw = txtEdad.getText().trim();
            
            
            
            
            
            

            if (nombre.isEmpty() || cedula.isEmpty() || edadRaw.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe completar todos los datos del usuario.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }
              int edad1 = Integer.parseInt(edadRaw);
            
              if (edad1<18) {
                JOptionPane.showMessageDialog(this, "Edad insuficiente", "Debe ser mayor de 18", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            
            
            int edad = Integer.parseInt(edadRaw);
            
            
            
            Usuario usuario = new Usuario(nombre, cedula, edad);
            
            
            

            
            Alquiler alquiler = new Alquiler(usuario, new Date());

            
            int cantSencilla = Integer.parseInt(txtCantSencilla.getText().trim());
            int cantDoble = Integer.parseInt(txtCantDoble.getText().trim());
            int cantSuite = Integer.parseInt(txtCantSuite.getText().trim());

            
            for (int i = 0; i < cantSencilla; i++) {
                alquiler.addRoom(new Habitacion(TipoHabitacion.SENCILLA));
            }
            for (int i = 0; i < cantDoble; i++) {
                alquiler.addRoom(new Habitacion(TipoHabitacion.DOBLE));
            }
            for (int i = 0; i < cantSuite; i++) {
                alquiler.addRoom(new Habitacion(TipoHabitacion.SUITE));
            }

            
            String factura = "=== REGISTRO DEL HOTEL ===\n" +
                             "Huésped: " + usuario.nombre + "\n" +
                             "Habitaciones alquiladas: " + alquiler.getCantidadHabitaciones() + "\n" +
                             "Total de la transacción: $" + alquiler.getTotalPrecio();
            
            JOptionPane.showMessageDialog(this, factura, "Registro Completado", JOptionPane.INFORMATION_MESSAGE);

             JOptionPane.showMessageDialog(this, factura, "Registro Completado", JOptionPane.INFORMATION_MESSAGE);

            // =========================================================================
            // CONEXIÓN FINAL CON EL CONTROLADOR
            // =========================================================================
            // =========================================================================
// CONEXIÓN FINAL CON EL CONTROLADOR
// =========================================================================
controlador.Servicios serviciosControlador = new controlador.Servicios();

try {
    serviciosControlador.alquilar(usuario); // Le pasamos el objeto 'usuario' completo
    JOptionPane.showMessageDialog(this, "¡Datos respaldados con éxito en la base de datos!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
} catch (Exception e) { 
   
    JOptionPane.showMessageDialog(this, "Error al guardar en la base de datos: " + e.getMessage(), "Error de Conexión", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
}

            
            
            
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Asegúrese de ingresar solo números enteros en Edad y Cantidades.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }

      private void actualizarUsuarioPorFormulario() {
       
        String id_actual = JOptionPane.showInputDialog(this, 
                "Ingrese el id_usuario del huésped que desea ACTUALIZAR:", 
                "Actualizar Datos", 
                JOptionPane.QUESTION_MESSAGE);

        if (id_actual == null) return; // Si cancela, salimos limpiamente
        id_actual = id_actual.trim();

        if (id_actual.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un id_usuario válido.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            
            String nuevoNombre = txtNombre.getText().trim();
            String nuevaCedula = txtCedula.getText().trim();
            String nuevaEdadRaw = txtEdad.getText().trim();

           
            if (nuevoNombre.isEmpty() || nuevaCedula.isEmpty() || nuevaEdadRaw.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Escriba los nuevos datos en el formulario antes de actualizar.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int nuevaEdad = Integer.parseInt(nuevaEdadRaw);
            if (nuevaEdad < 18) {
                JOptionPane.showMessageDialog(this, "El huésped debe ser mayor de 18 años.", "Edad insuficiente", JOptionPane.WARNING_MESSAGE);
                return;
            }

            
            Usuario usuarioNuevo = new Usuario(nuevoNombre, nuevaCedula, nuevaEdad);

           
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean exito = usuarioDAO.actualizar(id_actual, usuarioNuevo);

            if (exito) {
                
                String mensajeExito = "Datos actualizados con éxito.";
                if (nuevaCedula.length() >= 4) {
                    String posibleNuevoId = nuevaCedula.substring(nuevaCedula.length() - 4);
                    mensajeExito += "\nNota: Si modificó la cédula, el nuevo ID es: " + posibleNuevoId;
                }
                
                JOptionPane.showMessageDialog(this, mensajeExito, "Éxito", JOptionPane.INFORMATION_MESSAGE);
               
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún registro con el id_usuario: " + id_actual, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en la base de datos: " + ex.getMessage(), "Error Crítico", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Formulario().setVisible(true);
        });
    }
    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
