import java.awt.*;

public class Plant extends Sprite{

    private double health = 500;
    private Pot pot;
    private double water;
    private double increment = 0;
    private int waterThreshold;
    private boolean disease;
    private int size;

    private boolean[] diseaseCauses;

    //constructor
    public Plant(int x, int y, int size, int w, int wt, boolean d){
        super(x, y, size);
        water=w;
        disease=d;
        waterThreshold=wt;
        diseaseCauses = new boolean[3];
        pot = new Pot(100, 100,  new Color(31, 56, 219));
    }

    @Override
    public void draw()
    {
        //if plant is healthy
        if (!disease){
            StdDraw.picture(super.getX(), super.getY(), "betterzz.png", super.getSize(), super.getSize());
        }
        else if (disease){
            StdDraw.picture(super.getX(), super.getY(), "diseasedzz.png", super.getSize(), super.getSize());
        }
        pot.draw();
    }

    //getters
    public double getWater(){return water;}
    public boolean hasDisease(){return disease;}
    public Pot getPot(){return this.pot;}
    public String toString(){
        return this.health + "\n" + this.water + "\n" + this.waterThreshold + "\n" + this.disease;
    }
    public double getHealth(){return health;}
    public double getIncrement() { return increment;}

    //setters
    public void waterPlant(){water += 10;}
    public void grow(){super.setSize(super.getSize() + 1);}
    public void drainWater(){water -= 10;}
    public void setHealth(int health) {
        this.health = health;
    }
    public void setIncrement(double increment){ this.increment = increment;}

    //become diseased with the following three
    public void updateHealth(){
        if (water > waterThreshold + 10){  //1.) if water level is higher than needed
            diseaseCauses[0] = true;
            diseaseCauses[1] = false;
            diseaseCauses[2] = false;
            disease = true;

            health -= Math.abs(water - waterThreshold) + increment;
        }
        else if (water < waterThreshold - 10){     //2.) if water level is lower than needed
            diseaseCauses[0] = false;
            diseaseCauses[1] = true;
            diseaseCauses[2] = false;
            disease=true;

            health -= Math.abs(water - waterThreshold) + increment;
        }
        else {  //if the water levels are within acceptable range, then we increase health
            disease = false;
            health += 1 + increment;
        }

        water -= 0.1 + increment;
    }


    //3.) if plant size is larger than pot size (needs transplant - new pot)

    //actions for taking care of the plant


}
