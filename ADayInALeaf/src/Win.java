import java.awt.*;

public class Win extends Sprite
{
    public Win(int x, int y, int size)
    {
        super(x, y, size);
    }

    @Override
    public void draw()
    {
        StdDraw.setPenColor(236, 231, 241);
        StdDraw.filledRectangle(250, 250, 250, 250);

        StdDraw.setPenColor( 35, 32, 45);
        Font font = new Font("SansSerif", Font.BOLD, 60);
        StdDraw.setFont(font);
        StdDraw.text(250, 400,"You Win!");

        StdDraw.setPenColor(60, 112, 152);
        font = new Font("SansSerif", Font.PLAIN, 18);
        StdDraw.setFont(font);
        StdDraw.text(250, 325, "Congratulations! You've successfully managed");
        StdDraw.text(250, 300, "to not kill this plant! Caring for a plant");

        StdDraw.text(250, 275, "is a lot like caring for a person, give them the right");
        StdDraw.text(250, 250, "nutrients and time and care");
        StdDraw.text(250, 225, "and they can grow healthy and strong,");

        font = new Font("SansSerif", Font.ITALIC, 24);
        StdDraw.setFont(font);
        StdDraw.text(250, 190, "and that includes YOU!");


        font = new Font("SansSerif", Font.PLAIN, 18);
        StdDraw.setFont(font);
        StdDraw.text(250, 150, "Even if you're staying up all night to code, remember");
        StdDraw.text(250, 125, "to drink water, touch grass, and go outside!");
    }
}
