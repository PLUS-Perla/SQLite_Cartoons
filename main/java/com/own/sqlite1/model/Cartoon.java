package com.own.sqlite1.model;

/**
 * Created by Elena Alvarado on 08/04/2018.
 */

public class Cartoon {

    private String idCartoon;
    private String name;
    private String type;
    private String language;
    private String author;
    private int capitulos;
    private int year;

    public Cartoon(String idCartoon, String name, String type, String language, String author, int capitulos, int year) {

    }

    public Cartoon() {
        this("","","","", "",0,0);
    }


    public void setIdCartoon(String idCartoon) {
        this.idCartoon = idCartoon;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getIdCartoon() {return idCartoon;}

    public String getType() {return type;}

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Cartoon{" +
                "idCartoon='" + idCartoon + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", language=" + language +
                ", author=" +author +
                ", capitulos=" + capitulos +
                ", year=" + year +
                '}';
    }

}
