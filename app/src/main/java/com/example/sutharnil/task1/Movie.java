package com.example.sutharnil.task1;

public class Movie {

    private  String  title,genre,year;
   private boolean isSelected;
    public Movie()
    {

    }

    public Movie(String title,String genre,String year)
    {
        this.title=title;
        this.genre=genre;
        this.year=year;

    }

    public void setSelected(boolean aBoolean) {
        this.isSelected = aBoolean;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public String getTitle()
    {
        return  title;
    }
    public String getYear()
    {
        return  year;
    }
    public String getGenre()
    {
        return  genre;
    }
    public void setTitle(String name)
    {
        this.title=name;
    }
    public void setYear(String year)
    {
        this.year=year;
    }
    public void setGenre(String genre)
    {
        this.title=genre;
    }

}
