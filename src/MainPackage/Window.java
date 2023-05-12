package MainPackage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public abstract class Window extends dataHandling implements MouseListener {
    IconsAndColors ic = new IconsAndColors() ;
    LoginPage l;
    Register r;
    HomePage h;
    GameStart g;
    ChessBoard c;
    GameLauncher gL;
    History hist;
    String test = "ss";
    public JFrame frame;
    public int width = ic.width, height = ic.height;
    //int u = width/1440;
    protected    JLayeredPane  base;


    protected ImageIcon backG_image;
    protected JButton backBtn;
    public User mainUser;

    private int refDim = 1440;
    protected JLabel backG;

    protected void initialize(){
        initializeWindow();
        System.out.println(test);
        setupWindow();
        putBackG();
        frame.setVisible(true);
    }

    public void initializeWithUser(User mainUser)
    {
        this.mainUser=mainUser;
        initialize();
    }
    abstract protected void setupWindow();

    protected void initializeWindow() {
        frame = new JFrame();
        frame.setSize(width , height);
        frame.setTitle("Chess game");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        base = new JLayeredPane();
        frame.add(base);
    }
     public void setBackG(String fileName){
         backG_image = new ImageIcon(fileName);
         System.out.println("ss");
     }
    public void setBackG(String fileName, int ref){ //overloading for diffrent dimensions
        backG_image = new ImageIcon(fileName);
        System.out.println("backg window");
        refDim = ref;
    }
    protected void putBackG(){
        backG = new JLabel(ic.resizeWithRatio(backG_image, refDim));
        if(refDim==870)
            backG.setBounds(-10,-5,width,height);
        else
            backG.setBounds(0,0,width,height);
        base.add(backG, Integer.valueOf(0));
        refDim = 1440;
    }

    public abstract void setBtns();
    public JTextField createTextField(String placeHolder , int size)
    {
        JTextField textField = new JTextField(placeHolder);

        //Function to retrieve data from text field
        // A function to check if value changed and user pressed enter




        //text field design Login 40 size
        //Reg 50 size
        textField.setFont(new Font("Space Grotesk", Font.PLAIN, size*width/1440));
        textField.setBackground(ic.white);
        textField.setForeground(ic.mainColor);
        textField.setOpaque(true);
        textField.setBorder(BorderFactory.createEmptyBorder());

        return textField;
    }
    public JPasswordField createPassField(){
       JPasswordField passField = new JPasswordField("password",8);

        //text field design
        passField.setFont(new Font("Space Grotesk", Font.PLAIN, 40*width/1440));
        passField.setBackground(ic.white);
        passField.setForeground(ic.mainColor);
        passField.setOpaque(true);
        passField.setBorder(BorderFactory.createEmptyBorder());

        return passField;
    }

    protected   JLabel createLabel(String text, int s){
        JLabel label = new JLabel(text);
        label.setFont(new Font("Space Grotesk", Font.BOLD, s *width/1440));
        label.setForeground(ic.white);
        return label;
    }

    protected JButton createButton(String name, int btn){
        JButton button = new JButton(name);
        button.setFocusable(false);

        //design//
        button.setFont(new Font("Space Grotesk", Font.BOLD, 36*width/1440));
        ImageIcon pinkBtn = new ImageIcon("src/Mat/Buttons/pinkBtn.png");
        ImageIcon whiteBtn = new ImageIcon("src/Mat/Buttons/whiteBtn.png");
        ImageIcon homeBtn = new ImageIcon("src/Mat/Buttons/pinkBtn2.png");

        switch (btn) {
            case 1 -> {
                button.setIcon(ic.resizeWithRatio(pinkBtn));
                button.setForeground(ic.white);
            }
            case 2 -> {
                button.setIcon(ic.resizeWithRatio(whiteBtn));
                button.setForeground(ic.mainColor);
            }
            case 3 ->{
                button.setFont(new Font("Space Grotesk", Font.BOLD, 55*width/1440));
                button.setIcon(ic.resizeWithRatio(homeBtn));
                button.setForeground(ic.white);
            }
        }
        button.setBackground(ic.black);//any color. Just to be transparent
        button.setOpaque(false);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);

        button.setBorder(BorderFactory.createEmptyBorder());
        button.addMouseListener(this);

        return button;
    }
    //Salah method (OverLoading)
    protected JButton createButton(String name,String ref, String filename, int x , int y,String color) {
        JButton temp = new JButton(name);
        temp.setName(ref);
        temp.setFocusable(false);
        temp.setFont(new Font("Space Grotesk Light",Font.BOLD,20 *width/870));
        temp.setBackground(Color.red);
        temp.setForeground(Color.decode(color));
        ImageIcon temp1 = new ImageIcon(filename);//src/Mat/Buttons/resignBtn.png
        Image btnBG = temp1.getImage().getScaledInstance(75 *width/870,35 *width/870,Image.SCALE_SMOOTH);
        temp.setIcon(new ImageIcon (btnBG));
        temp.setHorizontalTextPosition(JButton.CENTER);
        temp.setVerticalTextPosition(JButton.CENTER);
        temp.setOpaque(false);
        temp.setBorder(BorderFactory.createEmptyBorder());
        temp.setBounds(x,y,75 *width/870,35 *width/870);
        return temp;
    }
    protected void set_backBtn(){
        ImageIcon backImg = new ImageIcon("src/Mat/Buttons/backBtn.png");
        backBtn = new JButton(ic.resizeWithRatio(backImg));
        backBtn.setOpaque(false);
        backBtn.setFocusable(false);
        backBtn.setBorderPainted(false);
        backBtn.setBackground(ic.mainColor);

        backBtn.addMouseListener(this);
        backBtn.setBounds(46*width/1440,39*height/1024,65*width/1440,65*height/1024);

        base.add(backBtn, Integer.valueOf(1));

    }
}