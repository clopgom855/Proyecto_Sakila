package UI;

import javax.swing.*;

public class VentanaSimple extends JFrame {
    public VentanaSimple() {
        // Establecer el título de la ventana
        super("Ventana Simple");

        // Crear un botón
        JButton boton = new JButton("Haz clic aquí");

        // Agregar el botón a la ventana
        add(boton);

        // Establecer el tamaño de la ventana
        setSize(400, 300);

        // Establecer la operación de cierre por defecto
        setDefaultCloseOperation(EXIT_ON_CLOSE);

      // Mostrar la ventana
        setVisible(true);
}
}
/*
 * 
 * 
    }
 */