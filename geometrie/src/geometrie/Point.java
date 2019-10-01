package geometrie;

import java.lang.Math; 

public class Point {
    private int x;
    private int y;

    // ==== Constructors ====

    Point(){
        this.x = 0;
        this.y = 0;
    }

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    // ==== Getters ====

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public String getPosition(){
        return "x : " + this.x + " y : " + this.y;
    }

    // ==== Useful methods ====

    public void moveTo(int new_x, int new_y) {
        this.x = new_x;
        this.y = new_y;
    }

    public void rMoveTo(int rNew_x, int rNew_y) {
        this.x += rNew_x;
        this.y += rNew_y;
    }

    public double distance(Point pt){
        return Math.sqrt((Math.pow((pt.getX() - this.x), 2) + Math.pow((pt.getY() - this.y), 2)));
    }
}