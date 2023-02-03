public class HomeScreen extends Sprite{

    private Button start = new Button(250, 225, 75, "t", "Let's Grow!");
    private Button archive = new Button(250, 125, 75, "t", "My Plants");
    private Button c = new Button(250, 325, 75, "t", "Change Background");


    public HomeScreen(int x, int y, int size)
    {
        super(x, y, size);
    }

    public Button getArchive() {
        return archive;
    }

    public Button getStart() {
        return start;
    }

    public Button getC() { return c;}

    public void draw(){
        StdDraw.setPenColor(140, 221, 255);
        StdDraw.filledRectangle(250,250,250,250);
        start.draw();
        archive.draw();
        c.draw();
    }
}
