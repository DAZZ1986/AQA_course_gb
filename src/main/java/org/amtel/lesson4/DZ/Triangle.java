package org.amtel.lesson4.DZ;

public class Triangle {

    int base;
    int height;


    public Triangle(int b, int h) {
        this.base = b;
        this.height = h;
    }




    //Площадь треугольника вычисляется по формуле = (width*height)/2
    public int triangleArea() {
        return (base * height) / 2;
    }

}
