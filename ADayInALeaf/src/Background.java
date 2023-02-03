public class Background extends HomeScreen
{
    private String background = "plantBG6.PNG";

    public Background(int x, int y, int size)
    {
        super(x, y, size);
    }

    public String getBackground(){ return background;}
    public void setBackground(String bg) { background = bg;}


    @Override
    public void draw()
    {
        StdDraw.setPenColor(140, 221, 255);
        StdDraw.filledRectangle(250,250,250,250);
    }
}
