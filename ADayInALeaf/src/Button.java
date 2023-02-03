import java.awt.*;

public class Button extends Sprite
{
    private String filename;
    String textOrPic;
    public Button(int x, int y, int size, String t, String file)
    {
        super(x, y, size);
        filename=file;
        textOrPic=t;
    }

    @Override
    public void draw()
    {
        StdDraw.setPenColor(20, 185, 255);
        StdDraw.filledRectangle(super.getX(), super.getY(), super.getSize(), super.getSize()/2);
        if (textOrPic.equalsIgnoreCase("p")){
            StdDraw.picture(super.getX(), super.getY(), filename, 50, 50);
        }
        else{
            StdDraw.setPenColor(Color.black);
            StdDraw.text(super.getX(), super.getY(), filename);
        }
    }
}