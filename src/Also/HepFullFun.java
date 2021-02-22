package Also;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class HepFullFun {
    ImageIcon Line;
    ImageIcon Void;
    ImageIcon Eraser;
    ImageIcon Pouring;
    ImageIcon FourStar;
    ImageIcon FiveStar;
    ImageIcon SixStar;
    ImageIcon SevenStar;
    ImageIcon CustomCoalNum;
    ImageIcon Black;
    ImageIcon White;
    ImageIcon Red;
    ImageIcon Green;
    ImageIcon Blue;
    ImageIcon CustomColor;
    ImageIcon Clean;


    {
        try {
            Line= new ImageIcon(ImageIO.read(new File("out/production/png/Line.png")));
            Void= new ImageIcon(ImageIO.read(new File("out/production/png/Void.png")));
            Eraser= new ImageIcon(ImageIO.read(new File("out/production/png/Eraser.png")));
            Pouring= new ImageIcon(ImageIO.read(new File("out/production/png/Pouring.png")));
            FourStar= new ImageIcon(ImageIO.read(new File("out/production/png/FourStar.png")));
            FiveStar= new ImageIcon(ImageIO.read(new File("out/production/png/FiveStar.png")));
            SixStar= new ImageIcon(ImageIO.read(new File("out/production/png/SixStar.png")));
            SevenStar= new ImageIcon(ImageIO.read(new File("out/production/png/SevenStar.png")));
            CustomCoalNum= new ImageIcon(ImageIO.read(new File("out/production/png/EightStar.png")));
            Black=new ImageIcon(ImageIO.read(new File("out/production/png/Black.png")));
            White=new ImageIcon(ImageIO.read(new File("out/production/png/White.png")));
            Red=new ImageIcon(ImageIO.read(new File("out/production/png/Red.png")));
            Green=new ImageIcon(ImageIO.read(new File("out/production/png/Green.png")));
            Blue=new ImageIcon(ImageIO.read(new File("out/production/png/Blue.png")));
            CustomColor=new ImageIcon(ImageIO.read(new File("out/production/png/CustomColor.png")));
            Clean=new ImageIcon(ImageIO.read(new File("out/production/png/Clean.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JMenuItem SetMItemText(int what){
        JMenuItem one=new JMenuItem();
        switch (what){
            case (0):
                one.setIcon(Clean);
                one.setText("Clean");
                break;
            case (1):
                one.setIcon(Line);
                one.setText("Line");
                break;
            case (2):
                one.setIcon(Eraser);
                one.setText("Eraser");
                break;
            case (3):
                one.setIcon(Pouring);
                one.setText("Pouring");
                break;
            case (4):
                one.setIcon(FourStar);
                one.setText("FourStar");
                break;
            case (5):
                one.setIcon(FiveStar);
                one.setText("FiveStar");
                break;
            case (6):
                one.setIcon(SixStar);
                one.setText("SixStar");
                break;
            case (7):
                one.setIcon(SevenStar);
                one.setText("SevenStar");
                break;
            case (8):
                one.setIcon(CustomCoalNum);
                one.setText("EightStar");
                break;
            case (9):
                one.setIcon(Black);
                one.setText("Black");
                break;
            case (10):
                one.setIcon(White);
                one.setText("White");
                break;
            case (11):
                one.setIcon(Red);
                one.setText("Red");
                break;
            case (12):
                one.setIcon(Green);
                one.setText("Green");
                break;
            case (13):
                one.setIcon(Blue);
                one.setText("Blue");
                break;
            case (14):
                one.setIcon(CustomColor);
                one.setText("Custom Color");
                break;
            default:
                one.setIcon(Void);
                break;
        }
        return one;
    }

    public JButton SetButtonIcon( int what){
        JButton one=new JButton();
        switch (what){
            case (0):
                one.setIcon(Clean);
                one.setToolTipText("Clean");
                break;
            case (1):
                one.setIcon(Line);
                one.setToolTipText("Line");
                break;
            case (2):
                one.setIcon(Eraser);
                one.setToolTipText("Eraser");
                break;
            case (3):
                one.setIcon(Pouring);
                one.setToolTipText("Pouring");
                break;
            case (4):
                one.setIcon(FourStar);
                one.setToolTipText("FourStar");
                break;
            case (5):
                one.setIcon(FiveStar);
                one.setToolTipText("Five Star");
                break;
            case (6):
                one.setIcon(SixStar);
                one.setToolTipText("Six Star");
                break;
            case (7):
                one.setIcon(SevenStar);
                one.setToolTipText("Seven Star");
                break;
            case (8):
                one.setIcon(CustomCoalNum);
                one.setToolTipText("Custom coal num");
                break;
            case (9):
                one.setIcon(Black);
                one.setToolTipText("Black");
                break;
            case (10):
                one.setIcon(White);
                one.setToolTipText("White");
                break;
            case (11):
                one.setIcon(Red);
                one.setToolTipText("Red");
                break;
            case (12):
                one.setIcon(Green);
                one.setToolTipText("Green");
                break;
            case (13):
                one.setIcon(Blue);
                one.setToolTipText("Blue");
                break;
            case (14):
                one.setIcon(CustomColor);
                one.setToolTipText("Custom Color");
                break;
            default:
                one.setIcon(Void);
                break;
        }
        return one;
    }
}
