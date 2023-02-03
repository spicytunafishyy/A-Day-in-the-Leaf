import java.awt.*;
import java.util.*;

class Main {
  private static ArrayList<Sprite> sprites = new ArrayList<>();

  public static void main(String[] args) {
    drawBG(500);
    run(500);
  }

  public static void drawBG(int size)
  {
    StdDraw.setCanvasSize(size, size);
    StdDraw.setXscale(0, size);
    StdDraw.setYscale(0, size);
  }

  public static void drawSprites()
  {
    for (Sprite sprite: sprites)
      sprite.draw();
  }

  public static void checkSprites()
  {
    int i = 0;

    while (i < sprites.size()) {
      if (sprites.get(i).getClass() == Water.class && ((Water) sprites.get(i)).getRun() == 15)
        sprites.remove(i);  //removes any Water sprites that have fallen 15 "steps"
      else if (sprites.get(i).getClass() == Popup.class && ((Popup) sprites.get(i)).getRun() == 30)
        sprites.remove(i);
      else
        i++;
    }
  }

  public static void run(int size) {
    int r = 0;
    int direction = 1;
    boolean clicked = false;

    Panel p = new Panel(250, 250, 200);

    Plant tuna = new Plant(125, 200, 200, 50, 50, false);

    HomeScreen susdri = new HomeScreen(250, 250, 100);
    sprites.add(susdri);

    Button returnHome = new Button(100, 450, 75, "t", "Return Home");

    Background bg = new Background(250, 250, 100);

    while (true) {
      StdDraw.picture(size / 2, size / 2, bg.getBackground(), size, size);  //draws the background
      drawSprites();  //draws all the Sprites in the sprites array
      checkSprites(); //checks if any sprites need to be removed after a specified time (like Water)

      if(sprites.contains(tuna)) {
        tuna.updateHealth();  //updates the health based on conditions (like too much water or too little)

        tuna.setIncrement(tuna.getIncrement() + 0.01); //increasingly deteriorates/increases health/water

        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(100, 400, 50, 20);
        StdDraw.filledRectangle(300, 400, 50, 20);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(100, 400, "Health: " + (int) tuna.getHealth());
        StdDraw.text(300, 400, "Water: " + (int) tuna.getWater());
      }


      //if health gets to max, then the player wins
      if (tuna.getHealth() >= 1000){
        sprites.clear();
        Win w = new Win(250, 250, 250);
        w.draw();
      }

      //home screen. if start ("let's grow!) button is clicked, remove it and start the growing process
      if (susdri.getStart().isClicked() && sprites.contains(susdri)){
        sprites.remove(susdri);
        sprites.add(returnHome);
        sprites.add(tuna);
      }
      //if b (plant archive) is clicked, open up plant archive (diff plants and info on care tips)

      //if c (change background) is clicked, then first clear the homescreen off the array
      if (susdri.getC().isClicked() && sprites.contains(susdri)){
        sprites.remove(susdri);

        if(bg.getBackground().equals("bg4.png"))
          bg.setBackground("plantBG6.PNG");
        else if(bg.getBackground().equals("plantBG6.PNG"))
          bg.setBackground("bg4.png");

        sprites.add(returnHome);
        sprites.add(tuna);
      }

      //if the pot/plant is clicked, open up the menu
      if (sprites.contains(tuna)) {
        if ((tuna.isClicked() || tuna.getPot().isClicked()) && !clicked) {
          clicked = true;
          sprites.add(p);
        }
      }

      /**actual game stuff here now.**/


      //if return home clicked
      if (returnHome.isClicked()){
        sprites.remove(returnHome);
        sprites.remove(bg);
        sprites.remove(tuna);
        sprites.add(susdri);
      }

      /**
       * first button in popup, to water plant
       * adds one water
       * potential fixes: more droplets?
       * **/
      if (p.getA().isClicked() && sprites.contains(p)){
        sprites.remove(p);

        Water w = new Water(100, 300, 10, 5);
        sprites.add(w);
        tuna.waterPlant();
        tuna.setIncrement(0);
      }

      if (p.getB().isClicked() && sprites.contains(p)){
        sprites.remove(p);

        tuna.drainWater();

        Popup i = new Popup(250, 250, 200);
        sprites.add(i);
        tuna.setIncrement(0);
      }

      /**
       * issue: clicks out when clicking in box. - NO NEED TO RESOLVE FOR HACKATHON
       * **/
      if (sprites.contains(tuna)){
        if (StdDraw.isMousePressed() && !tuna.isClicked() && !tuna.getPot().isClicked() && clicked)
        {
          clicked = false;
          sprites.remove(p);
        }
      }

      /** THIS WHOLE SECTION NEEDS WORK!!!!!
       *  essentially this is the second button on the plant menu
       *  this button would drain the plant of its water (aka reset water = 0)
       *  the function to reset is alr written. but the graphic with popup are a little finnicky
       * **/
//            Popup i = new Popup(250, 250, 200);
//            if ((p.getB().isClicked())){
//                sprites.remove(p);
//                //add a popup message saying the pot has been drained of any excess water and that the soil is dry
//                sprites.add(i);
//                tuna.drainWater();
//            }
//            else if (StdDraw.isMousePressed() && !i.isClicked()){
//                sprites.remove(i);
//            }

      if ((p.getC().isClicked())){
        sprites.remove(p);
      }

      r += direction; //this is just for swaggy rgb background
      if (r == 255 || r == 0)
        direction *= -1;

      StdDraw.show(100);
      StdDraw.clear(new Color(r, r / 2, 50)); //after clearing the screen, we color it the new color
    }
  }

}