public abstract class Sprite
{
    private int x;
    private int y;
    private int size;
    public Sprite(int x, int y, int size)
    {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public abstract void draw();    //requires all classes that inherit/extends this class to have a draw() method

    public boolean isClicked()
    {
        if (StdDraw.isMousePressed())
            return (StdDraw.mouseX() >= x - size / 2.0 && StdDraw.mouseX() <= x + size / 2.0 && StdDraw.mouseY() >= y - size / 2.0 && StdDraw.mouseY() <= y + size / 2.0);
        return false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getSize(){ return this.size;}

    public void setSize(int size) { this.size = size;}

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
