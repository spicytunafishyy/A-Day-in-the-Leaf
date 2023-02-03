import java.awt.*;

public class GameOver extends Sprite{

    private Button a = new Button(250, 225, 75, "t", "Try Again!");

    public GameOver(int x, int y, int size)
    {
        super(x, y, size);
    }


    public Button getA() {
        return a;
    }

    public void draw(){
        StdDraw.setPenColor(140, 221, 255);
        StdDraw.filledRectangle(super.getX(),super.getY(),super.getSize(),super.getSize()/2);
        StdDraw.picture(250,400, "trollface.png");
        StdDraw.setPenColor(Color.black);
        StdDraw.text(250,250, "GAME OVER!");
        a.draw();

    }
}
