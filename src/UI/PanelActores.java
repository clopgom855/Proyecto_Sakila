package UI;

import javax.swing.*;

import controlador.Controlador;
import entidades.Actor;

import java.awt.*;

public class PanelActores extends JPanel {
    private Controlador controlador;
    private JTable tablaActores;

    public PanelActores(Controlador controlador) {
        this.controlador = controlador;

        // Establecer el layout del panel
        setLayout(new BorderLayout());

        // Crear la tabla para mostrar la lista de actores
        tablaActores = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaActores);
        add(scrollPane, BorderLayout.CENTER);

        // Crear un panel con botones para agregar, actualizar y eliminar actores
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        JButton botonAgregar = new JButton("Agregar");
        panelBotones.add(botonAgregar);

        JButton botonActualizar = new JButton("Actualizar");
        panelBotones.add(botonActualizar);

        JButton botonEliminar = new JButton("Eliminar");
        panelBotones.add(botonEliminar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    public void botonAgregarActorPresionado(Actor a) {
        // Llamar al método correspondiente en el controlador para agregar un nuevo actor a la base de datos
        controlador.guardaActor(a);
    }
}