package com.karyakita.karyakita_android_new.customer.carousel;

import com.karyakita.karyakita_android_new.R;

import java.util.Arrays;
import java.util.List;

public class Carousel {

    public Carousel() {
    }

    public static Carousel get() {
        return new Carousel();
    }

    public List<Item> getData() {
        return Arrays.asList(
                new Item(1, R.drawable.image_carousel_1, "Image Carousel 1"),
                new Item(2, R.drawable.image_carousel_2, "Image Carousel 2"),
                new Item(3, R.drawable.image_carousel_3, "Image Carousel 3"),
                new Item(4, R.drawable.image_carousel_4, "Image Carousel 4"));
    }
}
