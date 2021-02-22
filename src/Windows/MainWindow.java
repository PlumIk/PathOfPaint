package Windows;

import Also.Base.MainWindowBase;
import Also.Classes.BorderTools;
import Also.HepFullFun;
import Also.Threads.CustomColorThread;
import Screen.MyPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends WindowExample {

    private JMenuItem[] menuButtons;
    private JButton[] toolsButtons;
    private MainWindowBase MyBase=new MainWindowBase();
    private JMenu tools;
    private int workTool;
    private MyPanel myPanel;

    private void CreateThis(){
        this.setTitle("Path Of Paint");
        HepFullFun PingSetter=new HepFullFun();
        workTool=1;
        JMenuBar MenuBar=new JMenuBar();
        menuButtons=new JMenuItem[workTool+17];
        menuButtons[0]=new JMenuItem("Help");
        menuButtons[0].addActionListener(e->{ new HelpWindow(); });
        tools=new JMenu("Tools");
        myPanel=new MyPanel(MyBase,this.getWidth(), this.getHeight());
        BorderTools usControl=new BorderTools();
        JToolBar ToolBar=new JToolBar();
        toolsButtons=new JButton[17];
        for(int i=0;i<17;i++){
            int finalI=i;
            toolsButtons[i]=PingSetter.SetButtonIcon(i);
            switch (i){
                case (0):
                    menuButtons[workTool+i]=PingSetter.SetMItemText(i);
                    menuButtons[workTool+i].addActionListener(e -> { myPanel.Clean();
                    });
                    toolsButtons[i].addActionListener(e->{ myPanel.Clean();});
                    tools.add(menuButtons[workTool+i]);
                    break;
                case (2):
                    break;
                case (9):
                    menuButtons[workTool+i]=PingSetter.SetMItemText(i);
                    toolsButtons[i].addActionListener(e->{MyBase.SwapColor(Color.BLACK);
                        usControl.NewCol( toolsButtons[finalI]);});

                    menuButtons[workTool+i].addActionListener(e -> {
                        MyBase.SwapColor(Color.BLACK);
                        usControl.NewCol( toolsButtons[finalI]);

                    });
                    usControl.ChBottomCo= toolsButtons[i];
                    toolsButtons[i].setSelected(true);
                    tools.add(menuButtons[workTool+i]);
                    break;
                case (10):
                    menuButtons[workTool+i]=PingSetter.SetMItemText(i);
                    toolsButtons[i].addActionListener(e->{MyBase.SwapColor(Color.WHITE);
                        usControl.NewCol( toolsButtons[finalI]);});
                    menuButtons[workTool+i].addActionListener(e -> { MyBase.SwapColor(Color.WHITE);
                        usControl.NewCol( toolsButtons[finalI]);});
                    tools.add(menuButtons[workTool+i]);
                    break;
                case (11):
                    menuButtons[workTool+i]=PingSetter.SetMItemText(i);
                    toolsButtons[i].addActionListener(e->{MyBase.SwapColor(Color.RED);
                        usControl.NewCol( toolsButtons[finalI]);});
                    menuButtons[workTool+i].addActionListener(e -> { MyBase.SwapColor(Color.RED);
                        usControl.NewCol( toolsButtons[finalI]);});
                    tools.add(menuButtons[workTool+i]);
                    break;
                case (12):
                    menuButtons[workTool+i]=PingSetter.SetMItemText(i);
                    toolsButtons[i].addActionListener(e->{MyBase.SwapColor(Color.GREEN);
                        usControl.NewCol( toolsButtons[finalI]);});
                    menuButtons[workTool+i].addActionListener(e -> { MyBase.SwapColor(Color.GREEN);
                        usControl.NewCol( toolsButtons[finalI]);});
                    tools.add(menuButtons[workTool+i]);
                    break;
                case (13):
                    menuButtons[workTool+i]=PingSetter.SetMItemText(i);
                    toolsButtons[i].addActionListener(e->{MyBase.SwapColor(Color.BLUE);
                        usControl.NewCol( toolsButtons[finalI]);});
                    menuButtons[workTool+i].addActionListener(e -> { MyBase.SwapColor(Color.BLUE);
                        usControl.NewCol( toolsButtons[finalI]);});
                    tools.add(menuButtons[workTool+i]);
                    break;
                case (14):
                    toolsButtons[i].addActionListener(e->{new CustomColorThread(MyBase).start();
                        System.out.println("Here");
                        usControl.NewCol(toolsButtons[finalI]); });
                    menuButtons[workTool+i]=PingSetter.SetMItemText(i);
                    menuButtons[workTool+i].addActionListener(e -> { new CustomColorThread(MyBase).start();
                        if(MyBase.GetAcCol()) {
                            usControl.NewCol(toolsButtons[finalI]);
                        }});
                    tools.add(menuButtons[workTool+i]);
                    break;
                case (3):
                    menuButtons[workTool+i]=PingSetter.SetMItemText(i);
                    menuButtons[workTool+i].addActionListener(e -> {
                        MyBase.createStar(0,1,finalI,1);
                        usControl.NewAk( toolsButtons[finalI]);
                        myPanel.SameSing();});
                    toolsButtons[i].addActionListener(e->{
                        MyBase.createStar(0,1,finalI,1);
                        usControl.NewAk( toolsButtons[finalI]);
                        myPanel.SameSing();});
                    tools.add(menuButtons[workTool+i]);
                    break;
                default:
                    if (i<9){
                        menuButtons[workTool+i]=PingSetter.SetMItemText(i);
                        menuButtons[workTool+i].addActionListener(e -> { new ChoseWindow(MyBase, finalI,myPanel);
                            usControl.NewAk( toolsButtons[finalI]);});
                        toolsButtons[i].addActionListener(e->{
                            new ChoseWindow(MyBase, finalI,myPanel);
                            usControl.NewAk( toolsButtons[finalI]);});
                        tools.add(menuButtons[workTool+i]);
                    }
                    break;
            }
            if(i!=2&&i<15) {
                ToolBar.add(toolsButtons[i]);
            }
        }



        MenuBar.add(tools);
        add(myPanel);
        menuButtons[0].setSize(40,40);
        MenuBar.add(menuButtons[0]);
        ToolBar.setLayout(new GridLayout(1, 0, 2, 2));
        AddTools(ToolBar);
        AddMenu(MenuBar);
        this.setVisible(true);
    }

    public MainWindow(){
        super();
        CreateThis();
    }

    public MainWindow(int x, int y){
        super();
        if(x>=640&&y>=480){
            this.setSize(x,y);
        }
        CreateThis();
    }


}
