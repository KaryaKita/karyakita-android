package com.karyakita.karyakita_android_new.customer.carousel;

public class Item {
    private final int id;
    private final int image;
    private final String name;

    public Item(int id, int image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
