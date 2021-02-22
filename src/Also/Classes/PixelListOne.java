package Also.Classes;

import java.awt.*;

public class PixelListOne {
    public PixelListOne next =null;
    public int x;
    public int y;


    public PixelListOne(int InX, int InY){
        x=InX;
        y=InY;
    }
    public PixelListOne DoCopy(){
        PixelListOne one=new PixelListOne(x,y);
        return one;
    }


}
