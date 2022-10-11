import java.awt.*;

public class Circle implements Shape {
    protected int radius;
    protected Color color;
    protected double x;
    protected double y;

    public Circle(Point center) {
        this.x = center.x;
        this.y = center.y;
        color = Color.BLUE;
    }

    public Point getCenter() {
        return new Point((int)x, (int)y);
    }

    public void setRadius(int r){
        this.radius = r;
    }

    public int getRadius(){ return this.radius; }

    public void setCenter(Point p){
        x = p.x;
        y = p.y;
    }

    public int getTop(){
        return (int) y -radius;
    }
    public int getBottom(){
        return (int) y + radius;
    }
    public int getLeft(){
        return (int) x - radius;
    }
    public int getRight(){
        return (int) x +radius;
    }

    public Rectangle getRegion(){
        return  new Rectangle(getTop(),getLeft(), 2*radius, 2 *radius);
    }

    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(getLeft(), getTop(), radius*2, radius*2 );
        g.setColor(Color.black);
        g.drawOval(getLeft(), getTop(), radius*2, radius*2);
    }

    public boolean isInside(Point p){
        Point center = new Point((int)x,(int)y);
        return p.distance(center)<radius;
    }

    public void setColor(Color c){
        this.color = c;
    }

}
