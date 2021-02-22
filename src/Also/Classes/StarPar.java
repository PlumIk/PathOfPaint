package Also.Classes;

import java.awt.*;

public class StarPar {
    private int Coal;
    private int objType;
    private int lastX;
    private int lastY;
    private int X;
    private int Y;
    private int Thickness;
    private int Size;
    private int N;

    public int SetN(int InN){
        if(InN>0&&InN<100) {
            N = InN;
            return 1;
        }
        return 0;
    }

    public StarPar(int InSize, int InCoal, int InType, int InLastX, int InLastY, int InX, int InY, int InThickness)
    {
        Size=InSize;
        Thickness=InThickness;
        Coal=InCoal;
        objType=InType;
        lastX=InLastX;
        lastY=InLastY;
        X=InX;
        Y=InY;
        N=InType;
    }

    public void ReCord(int x, int y){
        lastX=X;
        lastY=Y;
        X=x;
        Y=y;
    }
    public int GetN(){return N;}
    public int GetThickness(){return Thickness;}
    public int GetSize(){return Size;}
    public int getCoal(){return Coal;}
    public int getObjType(){return objType;}
    public int getLastX(){return lastX;}
    public int getLastY(){return lastY;}
    public int getX(){return X;}
    public int getY(){return Y;}


}
