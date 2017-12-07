import javax.swing.*;
import java.awt.*;

import sweeper.Box;

public class MineSweeper extends JFrame{

    private JPanel panel;
    private final int COLS = 15;
    private final int ROWS = 1;
    private final int IMG_SIZE = 50;
    private final int PANEL_OFFSET = 5;

    public static void main(String[] args) { new MineSweeper(); }

    public MineSweeper() {
        setImage();
        iniPanel();
        initFrame();
    }

    private void iniPanel(){
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                //setStartView(g);
                for(Box box : Box.values()) {
                    g.drawImage((Image)box.image, box.ordinal() * IMG_SIZE,0,this);
                }
            }
        };
        panel.setPreferredSize(new Dimension(COLS*IMG_SIZE, ROWS*IMG_SIZE));
        add(panel);
    }

    public void initFrame(){
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void setImage(){
        for(Box box : Box.values()){
            box.image = getImage(box.name());
        }
    }

    private Image getImage(String imageName) {
        String filePath = "img/"+imageName.toLowerCase()+".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filePath));
        return icon.getImage();
    }

    public void setStartView(Graphics g){
        Image closedImage = getImage("closed");
        Integer filledY=0;
        while(filledY<ROWS*IMG_SIZE){
            Integer filledX=0;
            while(filledX<COLS*IMG_SIZE){
                g.drawImage(closedImage, PANEL_OFFSET+filledX,PANEL_OFFSET+filledY,this);
                filledX+=IMG_SIZE;
            }
            filledY+=IMG_SIZE;
        }
    }

}
