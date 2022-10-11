import java.awt.*;

public class Triangle implements Shape {

    Point middleCorner;
    boolean pointingUp;
    int width;

    Color color;

    public Triangle(Point middleCorner, int width, boolean pointingUp){
        this.middleCorner = middleCorner;
        this.pointingUp = pointingUp;
        this.width = width;
        this.color = Color.red;
    }
    @Override
    public void paint(Graphics g) {
        int halfWidth = (int)Math.floor((double)width/2);
        int heightY = (pointingUp? halfWidth*2 : -(halfWidth * 2));
        Point p1 = middleCorner;
        Point p2 = new Point((int) (p1.getX()-halfWidth), (int) (p1.getY() + heightY));
        Point p3 = new Point((int) (p1.getX()+halfWidth), (int) (p1.getY() + heightY));
        int[] x = new int[]{(int) p1.getX(), (int) p2.getX(), (int) p3.getX()};
        int[] y = new int[]{(int) p1.getY(), (int) p2.getY(), (int) p3.getY()};

        g.setColor(color);
        g.fillPolygon(x, y, 3);
        g.setColor(Color.black);
        g.drawPolygon(x, y, 3);
    }

    public void setColor(Color c){
        this.color = c;
    }
}
