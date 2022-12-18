package com.example.android_application_onepiece;

public class DataModel {
    String name;
    String type;
    String description;
    int id_;
    int image;

    public DataModel(String name,String type, String version, int id_, int image)
    {
        this.name = name;
        this.type = type;
        this.description = version;
        this.id_ = id_;
        this.image = image;
    }

    public String getName() {return name;}
    public String getType() {return type;}
    public String getVersion() {return description;}
    public int getId_()  {return id_;}
    public int getImage() {return image;}
}
