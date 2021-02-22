package Screen;

import Also.Base.MainWindowBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class ExamplePanel extends JPanel {
    BufferedImage img;

    public ExamplePanel(){

        img=new BufferedImage(40,40,BufferedImage.TYPE_INT_RGB);
        Graphics g= img.getGraphics();
        Color newColor = new Color(255, 255 , 255);
        g.setColor(newColor);
        g.fillRect(0, 0, 30, 30);
        repaint();
    }

    public void SwapColor(int red,int green,int blue){
        Graphics g= img.getGraphics();
        Color newColor = new Color(red, green , blue);
        g.setColor(newColor);
        g.fillRect(0, 0, 30, 30);
        repaint();
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0,0,this);
    }
}
