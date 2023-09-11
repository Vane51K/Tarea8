package edu.pizza.base;

public class Topping {
    private String nombre;
    private double precio;

    public Topping(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}