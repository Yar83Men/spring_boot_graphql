package com.graph_ql.model;

public class Movie {
    private Integer id;
    private String name;
    private Ganre ganre;

    public Movie(Integer id, String name, Ganre ganre) {
        this.id = id;
        this.name = name;
        this.ganre = ganre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ganre getGanre() {
        return ganre;
    }

    public void setGanre(Ganre ganre) {
        this.ganre = ganre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ganre=" + ganre +
                '}';
    }
}
