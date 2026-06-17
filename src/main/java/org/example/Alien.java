package org.example;

import jakarta.persistence.*;

@Entity
//@Entity(name = "alien_table")
@Table(name = "alien_table")
public class Alien {
    @Id
    private int id;
    @Column(name = "alien_name")
    private String name;
    @Transient
    private String tech;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
