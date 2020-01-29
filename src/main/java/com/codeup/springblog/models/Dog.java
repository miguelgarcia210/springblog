package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private long id;
    @Column(nullable = false, columnDefinition = "TINYINT(3) UNSIGNED")
    private long age;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(columnDefinition = "CHAR(2) DEFAULT 'XX'")
    private String resideState;

    public  Dog() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAge() {
        return this.age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return this.resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}
