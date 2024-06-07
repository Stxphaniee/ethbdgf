package org.poo.laboratorio;

public class Empleado {
    private String name;
    private int age;
    private double salary;

    public Empleado(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}