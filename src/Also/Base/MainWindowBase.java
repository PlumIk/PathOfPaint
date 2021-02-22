package Also.Base;

import Also.Classes.StarPar;

import java.awt.*;

public class MainWindowBase {

    public StarPar AboutStar=null;
    private Color ChosenColor=Color.BLACK;
    private int lastX=-1;
    private int lastY=-1;
    private int X=-1;
    private int Y=-1;
    public boolean Error=true;
    private boolean AcCol=false;
    private boolean AcFig=false;

    public int createStar(int InCoal, int InSize, int InType, int InThickness){
        if (InType!=1) {
            if (InCoal < 0||InCoal>360) {
                return 2;
            } else if (InSize <= 0) {
                return 1;
            }
        }
        AboutStar=new StarPar(InSize, InCoal,InType,lastX,lastY,X,Y, InThickness);
        return 0;
    }

    public void NewClick(int x, int y){
        lastX=X;
        lastY=Y;
        X=x;
        Y=y;
        System.out.println(x+"  "+y);
    }

    public Color GetColor(){
        return ChosenColor;
    }

    public void SwapColor(Color InColor){
        ChosenColor=InColor;
    }

    public void SwapColor(int r,int g, int b){
        ChosenColor=new Color(r, g, b);
    }

    public int GetLastX(){
        return lastX;
    }

    public int GetLastY(){
        return lastY;
    }

    public int GetX(){
        return X;
    }

    public int GetY(){
        return Y;
    }

    public void AcceptCol(){
        AcCol=true;
    }

    public void AcceptFig(){
        AcFig=true;
    }

    public boolean GetAcCol(){
        if(AcCol){
            AcCol=false;
            return true;
        }
        return false;
    }

    public boolean GetAcFig(){
        if(AcFig){
            AcFig=false;
            return true;
        }
        return false;
    }
}
