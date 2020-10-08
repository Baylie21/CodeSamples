//Imports
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Main_Display extends JFrame
{
//    //Nested die class.
//    private class Die {
//        private int val;
//
//        public Die()
//        {
//            roll();
//        }
//
//        public void roll(){
//            Random rand = new Random();
//            val = rand.nextInt(6) + 1;
//        }
//
//        public String getVal(){
//            return val + "";
//        }
//    }

    //If the button is hovered.
    private boolean hover = false;


    //Dice
    private Die_A die1 = new Die_A();



    public Main_Display(){
        //Initial shat.
        super("Dice");
        setSize(300, 130);

        //Create a new MouseAdapter
        MouseAdapter listen = new MouseAdapter(){
            public void mouseMoved(MouseEvent e){
                /*
                 * Only repaint when necessary to prevent excessive repaints that look really bad.
                 */

                //If hover was previously false.
                if(!hover){
                    //Check to see if the mouse is now inside the button.
                    if(e.getX() >= 50 && e.getX() <= 125 && e.getY() >= 50 && e.getY() <= 95){
                        //Set hovered to true, set the cursor to the hand, and repaint.
                        hover = true;
                        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                        repaint();
                    }
                }
                else{
                    //If the mouse is now outside the button.
                    if(!(e.getX() >= 50 && e.getX() <= 125 && e.getY() >= 50 && e.getY() <= 95)){
                        //Set hovered to false, set the cursor to the default one, and repaint.
                        hover = false;
                        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

                        repaint();
                    }
                }
            };

            public void mouseClicked(MouseEvent e){
                if(hover){
                    die1.getRoll();
                    repaint();
                }
            }
        };

        //Make sure we add the listener.
        addMouseMotionListener(listen);
        addMouseListener(listen);
    }

    public void paint(Graphics g){
        //Make sure we're using Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        //Anti alias graphics.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Set the font.
        g2d.setFont(new Font("Arial", Font.PLAIN, 28));

        //Paint the background.
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        //Paint the button.
        //Determine what color the button should be based on whether it is hovered or not.
        g2d.setColor(hover ? Color.gray : Color.black);
        g2d.fillRect(50, 50, 75, 45);

        //Paint Dice
        g2d.setColor(Color.black);
        g2d.drawRect(135, 50, 45, 45);
        g2d.drawRect(190, 50, 45, 45);
        g2d.drawRect(245, 50, 45, 45);

        //Text will be painted later as Trebuchet MS needs to be loaded.
        g2d.setColor(Color.white);
        g2d.drawString("Roll", 65, 80);

        //Paint die values.
        g2d.setColor(Color.black);
        g2d.drawString(String.valueOf(die1.getRoll()), 150, 82);
        g2d.drawString(String.valueOf(die1.getRoll()), 205, 82);
        g2d.drawString(String.valueOf(die1.getRoll()), 260, 82);
    }

    public static void main(String[] args){
        //Instantiate a new pair of Dice and set them to visible.
        new Main_Display().setVisible(true);
    }

}