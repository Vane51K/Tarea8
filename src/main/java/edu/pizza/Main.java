package edu.pizza;

import edu.formularios.frmPizza;
import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;
import edu.pizza.especialidades.PizzaItaliana;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("frmPizza");
        frame.setContentPane(new frmPizza().getjPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Ejemplo de cómo crear una Pizza Margherita
        Pizza pizza = new Pizza("Pizza Margherita", "Pequeña");
        pizza.addTopping(new Topping("Champiñones", 10.0));
        pizza.addTopping(new Topping("Mozzarella", 15.0));
        pizza.addTopping(new Topping("Cebolla", 8.0));
        pizza.addTopping(new Topping("Tomate", 9.0));
        pizza.prepare();

        // Ejemplo de cómo crear una Pizza Italiana
        Pizza pizzaItaliana = new PizzaItaliana("Pizza Italiana", "Mediana", "Salsa de tomate",
                new Topping("Tomato", 12.0), new Topping("Mozzarella", 15.0), new Topping("Basil", 5.0));
        pizzaItaliana.prepare();
    }
}