package Also.Threads;

import Also.Base.CustomColorBase;
import Also.Base.MainWindowBase;
import Windows.CustomColor;

public class CustomColorThread extends Thread{
    CustomColor Window;
    MainWindowBase ColBase;
    public CustomColorBase myBase=new CustomColorBase();
    boolean Error=false;


    public CustomColorThread(MainWindowBase inBase){
        ColBase=inBase;
        Window=new CustomColor();
        Window.setVisible(true);
    }

    @Override
    public void run(){
        while (!Window.end&&!Error){
           myBase.SwapColor(Window.RedSlider.getValue(),Window.GreenSlider.getValue(),Window.BlueSlider.getValue());
           Window.Example.SwapColor(myBase.red,myBase.green,myBase.blue);
           Window.repaint();
            try {
                sleep(10);
            } catch (InterruptedException e) {
                Error=true;
            }
        }
        if(!Error&&!Window.err){
            ColBase.AcceptCol();
            ColBase.SwapColor(myBase.red,myBase.green,myBase.blue);
        }
        Window.setVisible(false);

    }
}
