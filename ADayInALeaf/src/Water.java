public class Water extends Sprite
{
    private int velocity;

    private int run;

    public Water(int x, int y, int size, int velocity)
    {
        super(x, y, size);
        this.velocity = velocity;
        run = 0;
    }

    @Override
    public void draw()
    {
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(super.getX(), super.getY(), super.getSize() / 2, super.getSize() / 2);
        step();
    }

    public int getVelocity() {return velocity;}

    public void setVelocity(int velocity) {this.velocity = velocity;}


    public int getRun() { return run;}

    public void step()
    {
        super.setY(super.getY() - velocity);
        velocity += 1;
        run++;
    }
}
