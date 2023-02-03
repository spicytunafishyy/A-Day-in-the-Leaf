import java.util.Random;
import java.awt.*;

public class Pot extends Sprite
{
    private Color color;

    //constructor
    public Pot(int x, int s, Color c){
        super(x, 100, s);

        StdDraw.setPenColor(c);
    }

    @Override
    public void draw()
    {
        StdDraw.filledRectangle(super.getX(), super.getY(), super.getSize() / 2, super.getSize() / 2);
    }

    //check for overlapping
    public boolean overlaps(Pot other){
        //checking top-left vertex
        if (isInside(other.getX() - super.getSize() / 2, other.getY() - super.getSize() / 2))
            return true;
        //checking bottom-left vertex
        else if(isInside(other.getX() - super.getSize() / 2, other.getY() + super.getSize() / 2))
            return true;
        //checking top-right vertex
        else if (isInside(other.getX() + super.getSize() / 2, other.getY() - super.getSize() / 2))
            return true;
        //checking bottom-right vertex
        return isInside(other.getX() + super.getSize() / 2, other.getY() + super.getSize() / 2);
    }

    //used for the overlap method; does the calculation for total area
    public boolean isInside(int x, int y)
    {
        int area = super.getSize() * super.getSize();

        int area1, area2, area3, area4;

        //area from top-left vertex to (x,y)
        area1 = Math.abs(x - (super.getX() - super.getSize() / 2)) * Math.abs(y - (super.getY() - super.getSize() / 2));
        //area from bottom-left vertex to (x,y)
        area2 = Math.abs(x - (super.getX() - super.getSize() / 2)) * Math.abs(y - (super.getY() + super.getSize() / 2));
        //area from top-right vertex to (x,y)
        area3 = Math.abs(x - (super.getX() + super.getSize() / 2)) * Math.abs(y - (super.getY() - super.getSize() / 2));
        //area from bottom-right vertex to (x,y)
        area4 = Math.abs(x - (super.getX() + super.getSize() / 2)) * Math.abs(y - (super.getY() + super.getSize() / 2));

        return area == area1 + area2 + area3 + area4;
    }
}
