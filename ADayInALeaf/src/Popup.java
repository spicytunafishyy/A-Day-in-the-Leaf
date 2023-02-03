import java.awt.*;

public class Popup extends Sprite{
    private int run = 0;
    public Popup(int x, int y, int size)
    {
        super(x, y, size);
    }

    public void setRun() {run = 0;}

    public int getRun() {return run;}

    @Override
    public void draw(){
        StdDraw.setPenColor(140, 221, 255);
        StdDraw.filledRectangle(super.getX(), super.getY(), super.getSize(), super.getSize()/2);
        StdDraw.setPenColor(Color.black);
        StdDraw.text(super.getX(), super.getY()+25, "Water drained, plant dried!");
        StdDraw.text(super.getX(), super.getY(), "Mold can't get you now :D");
        StdDraw.text(super.getX(), super.getY()-25, "You may want to water your plant tho");
        run++;
    }

}
