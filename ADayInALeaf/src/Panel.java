import java.awt.*;

public class Panel extends Sprite{
    private Button a = new Button(250, 325, 75, "p","waterclear.png");
    private Button b = new Button(250, 225, 75, "p","towel.png");
    private Button c = new Button(250, 125, 75, "p","spraybottle.png");
    public Panel(int x, int y, int size)
    {
        super(x, y, size);
    }

    @Override
    public void draw()
    {
        StdDraw.setPenColor(140, 221, 255);
        StdDraw.filledRectangle(super.getX(), super.getY(), super.getSize(), super.getSize()*1.1);
        StdDraw.setPenColor(Color.black);
        StdDraw.text(250,450,"Plant Menu");
        StdDraw.text(250, 400, "Here are some options to take care of your plant!");

        StdDraw.setPenColor(Color.black);
        a.draw();

        b.draw();

        c.draw();


    }

    public Button getA(){return a;}

    public Button getB() {
        return b;
    }

    public Button getC() {
        return c;
    }
}