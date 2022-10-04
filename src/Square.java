import java.awt.*;

public class Square implements Shape {
    protected int width;
    protected Color color;
    protected double x;
    protected double y;

    public Square(Point start, int width) {
        this.x = start.x;
        this.y = start.y;
        this.width = width;
        color = Color.BLUE;
    }

    public Point getStart() {
        return new Point((int)x, (int)y);
    }

    public void setStart(Point p){
        x = p.x;
        y = p.y;
    }

    public int getTop(){
        return (int) y;
    }
    public int getBottom(){
        return (int) y + width;
    }
    public int getLeft(){
        return (int) x;
    }
    public int getRight(){
        return (int) x +width;
    }

    public Rectangle getRegion(){
        return  new Rectangle(getTop(),getLeft(), width, width);
    }

    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(getLeft(), getTop(), width, width );
    }

    public void setColor(Color c){
        this.color = c;
    }
}
