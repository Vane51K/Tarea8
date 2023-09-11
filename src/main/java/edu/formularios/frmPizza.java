package edu.formularios;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class frmPizza implements ActionListener {
    private JPanel JPanelPrincipal;
    private JComboBox<Topping> comboBoxToppings;
    private JTextField txtPizza;
    private JButton agregarIngredienteButton;
    private JLabel lblTotal;
    private JList<String> lista1;
    private JButton btnprepararpizza;
    private JComboBox<String> comboBoxTamaño;
    private JLabel txtTamañoSelec;
    private JLabel txtListo; // JLabel para mostrar el mensaje "Pizza Preparada Disfrutala!"
    private DefaultListModel<String> modeloLista = new DefaultListModel<>();

    private List<Topping> ingredientes = new ArrayList<>();
    private double precioTotal = 0.0; // Variable para llevar el registro del precio total

    public frmPizza() {
        cargarToppings();

        comboBoxTamaño.addItem("Pequeña"); // Pequeña (valor por defecto)
        comboBoxTamaño.addItem("Mediana"); // Mediana
        comboBoxTamaño.addItem("Grande"); // Grande

        agregarIngredienteButton.addActionListener(this);

        btnprepararpizza.addActionListener(e -> {
            String tamaño = (String) comboBoxTamaño.getSelectedItem();
            Pizza pizza = new Pizza(txtPizza.getText(), tamaño);
            Topping topi;

            for (int i = 0; i < lista1.getModel().getSize(); i++) {
                String nombreIngredienteSeleccionado = lista1.getModel().getElementAt(i);
                Topping ingrediente = encontrarToppingPorNombre(nombreIngredienteSeleccionado);
                pizza.addTopping(ingrediente);
            }

            // Calcular el precio total
            double precioPizza = pizza.calcularPrecio();
            precioTotal += precioPizza;

            // Mostrar el precio total en el JLabel lblTotal
            lblTotal.setText(String.valueOf(precioTotal));

            pizza.prepare();

            // Mostrar el mensaje de que la pizza está preparada
            txtListo.setText("Pizza Preparada Disfrutala!");
        });
    }

    private Topping encontrarToppingPorNombre(String nombre) {
        for (Topping ingrediente : ingredientes) {
            if (ingrediente.getNombre().equals(nombre)) {
                return ingrediente;
            }
        }
        return null;
    }

    private void cargarToppings() {
        ingredientes.add(new Topping("Champiñones", 10.0));
        ingredientes.add(new Topping("Tomate", 11.0));
        ingredientes.add(new Topping("Cebolla", 6.0));
        ingredientes.add(new Topping("Chucho", 9.0));
        ingredientes.add(new Topping("Salchica", 15.0));
        ingredientes.add(new Topping("Anchoas", 18.0));

        DefaultComboBoxModel<Topping> model = new DefaultComboBoxModel<>(ingredientes.toArray(new Topping[0]));
        comboBoxToppings.setModel(model);
    }

    public JPanel getjPanelPrincipal() {
        return JPanelPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarIngredienteButton) {
            Topping ingrediente = (Topping) comboBoxToppings.getSelectedItem();
            modeloLista.addElement(ingrediente.getNombre()); // Agrega el nombre del Topping
            lista1.setModel(modeloLista);
        }
    }
}

