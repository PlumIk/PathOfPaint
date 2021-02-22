package Screen;
import Also.Base.MainWindowBase;
import Also.Base.SpanBase;
import Also.Classes.PixelListOne;
import Also.Classes.StarPar;

import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel {
    MainWindowBase windowBase;
    BufferedImage img;

    public MyPanel(MainWindowBase InBase, int x, int y){
        img=new BufferedImage(x,y,BufferedImage.TYPE_INT_RGB);
        Graphics g= img.getGraphics();
        Color newColor = new Color(255, 255 , 255);
        g.setColor(newColor);
        g.fillRect(0, 0, x, y);

        windowBase=InBase;
        addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                windowBase.NewClick(e.getX(), e.getY());
                if(windowBase.AboutStar!=null){
                    windowBase.AboutStar.ReCord(e.getX(), e.getY());
                    SameSing();
                }
            }
        });
        repaint();
    }

    public void Clean(){
        img=new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics g= img.getGraphics();
        Color newColor = new Color(255, 255 , 255);
        g.setColor(newColor);
        g.fillRect(0, 0, img.getWidth(),img.getHeight());
        repaint();
    }

    public void SameSing(){
        StarPar one=windowBase.AboutStar;

        switch (one.getObjType()){
            case (1):
                DoLineTh(one.getX(),one.getY(),one.getLastX(),one.getLastY(),one.GetThickness());
                break;
            case(4):
            case (5):
            case (6):
            case (7):
            case (8):
                DoFigure(one.getX(),one.getY(),one.getCoal(),one.GetSize(),one.GetThickness(),one.GetN() );
                break;
            case (3):
                Pouring(one.getX(),one.getY(),windowBase.GetColor());
            default:
                break;
        }
        repaint();
    }

    public void Pouring(int x, int y, Color InColor){
        Graphics graf= img.getGraphics();
        graf.setColor(InColor);
        Color FullingColor=new Color(img.getRGB(x, y));
        if(FullingColor.equals(InColor)){
            return;
        }
        graf.setColor(windowBase.GetColor());
        PixelListOne one=new PixelListOne(x,y);
        PixelListOne stack=null;
        SpanBase me=new SpanBase();
        boolean DontFind;
        int SubX;
        int SubY;
        while (one!=null){
            graf.fillRect(one.x,one.y,1,1);
            y=one.y;
            x=one.x;
            SubY=y;
            SubX=x+1;
            if(SubX<img.getWidth()) {
                while (new Color(img.getRGB(SubX, SubY)).equals(FullingColor)) {
                    graf.fillRect(SubX, SubY, 1, 1);
                    SubX++;
                    if (SubX >= img.getWidth()) {
                        break;
                    }
                }
            }
            me.one=new PixelListOne(SubX-1,SubY);
            SubX=x-1;
            if(SubX>0) {
                while (new Color(img.getRGB(SubX, SubY)).equals(FullingColor)) {
                    graf.fillRect(SubX, SubY, 1, 1);
                    SubX--;
                    if (SubX < 0) {
                        break;
                    }
                }
            }
            me.two=new PixelListOne(SubX+1,SubY);
            SubY=y+1;
            if(SubY<img.getHeight()){
                DontFind=true;
               // System.out.println("From "+me.two.x+" to "+me.one.x);
                for(SubX=me.two.x;SubX<=me.one.x;SubX++){
                    if((new Color(img.getRGB(SubX, SubY))).equals(FullingColor)&&DontFind){
                        DontFind=false;
                       // System.out.println("Push "+SubX+" "+SubY);
                        if(stack==null){
                            stack=new PixelListOne(SubX,SubY);
                        }
                        else {
                            one=new PixelListOne(SubX,SubY);
                            one.next=stack;
                            stack=one;
                        }
                    }else if(!(new Color(img.getRGB(SubX, SubY)).equals(FullingColor))&&!DontFind){
                        DontFind=true;
                    }
                }
            }

            SubY=y-1;
            if(SubY>0){
                DontFind=true;
                for(SubX=me.two.x;SubX<=me.one.x;SubX++){
                    if(new Color(img.getRGB(SubX, SubY)).equals(FullingColor)&&DontFind){
                        DontFind=false;
                        if(stack==null){
                            stack=new PixelListOne(SubX,SubY);
                        }
                        else {
                            one=new PixelListOne(SubX,SubY);
                            one.next=stack;
                            stack=one;
                        }
                    }else if(!(new Color(img.getRGB(SubX, SubY)).equals(FullingColor))&&!DontFind){
                        DontFind=true;
                    }
                }
            }
            if(stack!=null){
                one=stack;
                stack=stack.next;
            }else{
                one=null;
            }
        }
    }

    private void DoFigure(int x, int y,int coal, int size, int th, int iter){
        double EfCoal=(double)coal+180;
        double CoalStep=360/((double)iter);
        int XNow=x+(int)(size*Math.sin(Math.toRadians(EfCoal)));
        int YNow=y+(int)(size*Math.cos(Math.toRadians(EfCoal)));
        int XLast;
        int YLast;
        for(int i=0;i<iter;i++){
            XLast=XNow;
            YLast=YNow;
            EfCoal+=CoalStep;
            if(EfCoal>=360){
                EfCoal-=360;
            }
            XNow=x+(int)(size*Math.sin(Math.toRadians(EfCoal)));
            YNow=y+(int)(size*Math.cos(Math.toRadians(EfCoal)));
            DoLineTh(XLast,YLast,XNow,YNow,th);

        }

    }

    private void DoLineTh(int x,int y,int ex, int ey, int th){
        DoLine(x,y,ex,ey);
        if(th>1){
            int dx=ex-x;
            int dy=ey-y;
            dx*=sign(dx);
            dy*=sign(dy);
            int where;
            if(dx<dy){
                where=1;
            }else {
                where=2;
            }
            DoLine(x+where%2,y+where/2,ex+where%2,ey+where/2);
            where*=-1;
            DoLine(x+where%2,y+where/2,ex+where%2,ey+where/2);
            if(th>2){
                DoLine(x+2*(where%2),y+2*(where/2),ex+2*(where%2),ey+2*(where/2));
                where*=-1;
                DoLine(x+2*(where%2),y+2*(where/2),ex+2*(where%2),ey+2*(where/2));
            }
        }
    }

    private void DoLine(int x,int y,int ex, int ey){
        Graphics graf= img.getGraphics();
        System.out.println(x+" "+y+"->"+ex+" " +ey);
        graf.setColor(windowBase.GetColor());
        int dx=ex-x;
        int dy=ey-y;
        int sx=sign(dx);
        int sy=sign(dy);
        dx*=sx;
        dy*=sy;
        int MainStep, SecondStep, XStep,YStep;
        if(dx>dy){
            XStep=sx;
            YStep=0;
            MainStep=dx;
            SecondStep=dy;
        }
        else{
            XStep=0;
            YStep=sy;
            MainStep=dy;
            SecondStep=dx;
        }
        int error=MainStep;
        graf.drawLine  (  x,  y, x, y);
        for(int i=0;i<MainStep;i++){
            error-=2*SecondStep;
            if(error<0){
                error+=2*MainStep;
                x+=sx;
                y+=sy;
            }
            else{
                x+=XStep;
                y+=YStep;
            }
            graf.drawLine  (  x,  y, x, y);
        }

    }

    private int sign(int one){
        if(one<0){
            return -1;
        }
        return 1;
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0,0,this);
    }
}
