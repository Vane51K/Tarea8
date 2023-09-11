package edu.pizza.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza {
    private final String name;
    private String tamaño; // Agregamos el atributo tamaño
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String name, String tamaño, Topping... toppings) {
        this.name = name;
        this.tamaño = tamaño;
        Collections.addAll(this.toppings, toppings);
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping(int index) {
        toppings.remove(index);
    }

    public List<Topping> getToppings() {
        return Collections.unmodifiableList(toppings);
    }

    public String getName() {
        return name;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public double calcularPrecio() {
        double precioBase = 10.0;

        if (tamaño.equals("Mediana")) {
            precioBase *= 1.2;
        } else if (tamaño.equals("Grande")) {
            precioBase *= 1.35;
        }

        double precioTotal = precioBase;

        for (Topping topping : toppings) {
            precioTotal += topping.getPrecio();
        }

        return precioTotal;
    }

    public void prepare() {
        System.out.println("Preparing..... " + name);
        System.out.println("Size: " + tamaño);
        System.out.println("Adding toppings:");
        for (Topping topping : toppings) {
            System.out.println("- " + topping.getNombre());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total Price: $" + calcularPrecio());
        System.out.println("The Pizza is ready!");
    }
}