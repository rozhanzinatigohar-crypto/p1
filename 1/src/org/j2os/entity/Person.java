package org.j2os.entity;

public class Person {
    private int id,salary;
    private String name,family;

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public int getSalary() {
        return salary;
    }

    public Person setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }
}
