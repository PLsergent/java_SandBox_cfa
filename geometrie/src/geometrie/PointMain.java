package geometrie;

public class PointMain {
    public static void main(String[] args) {
        // Create new points
        Point pt1 = new Point(1, 2);
        Point pt2 = new Point(2, 4);

        // Display positions
        System.out.println(pt1.getPosition());
        System.out.println(pt2.getPosition());

        System.out.println("================");

        // Move points coordonates
        pt1.moveTo(3, 5);
        pt2.rMoveTo(6, 9);

        System.out.println(pt1.getPosition());
        System.out.println(pt2.getPosition());

        System.out.println("================");

        // Display distance
        System.out.println("Distance between both points : " + pt1.distance(pt2));
    }
}