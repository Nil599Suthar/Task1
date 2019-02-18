package com.example.sutharnil.task1;

public class Actor {

    private  String  actor_name,actor_genre;
  private   int Image_id;
    private  String height,weight;
    public void Actor(){

    }

    public Actor(String name, String genre, int Id, String height, String weight )
    {
        this.actor_name=name;
        this.actor_genre=genre;
        this.Image_id=Id;
        this.height=height;
        this.weight=weight;

    }

    public void setActor_name(String name)    {
        this.actor_name=name;
    }
    public void setImage_id(int image_id)
    {
        this.Image_id=image_id;
    }
    public void setGenre(String genre)
    {
        this.actor_genre=genre;
    }
    public void setHeight(String height)
    {
        this.height=height;
    }
    public void setWeight(String weight)
    {
        this.weight=weight;
    }

    public String getActor_name()
    {
        return  actor_name;
    }
    public int getImage_id()
    {
        return  Image_id;
    }
    public String getGenre()
    {
        return  actor_genre;
    }
    public String getHeight()
    {
        return  height;
    }
    public String getWeight()
    {
        return  weight;
    }
}
