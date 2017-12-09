import javax.swing.*;
import java.awt.*;

import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

public class MineSweeper extends JFrame{

    private Game game;

    private JPanel panel;
    private final int COLS = 5;
    private final int ROWS = 5;
    private final int IMG_SIZE = 50;
    private final int PANEL_OFFSET = 5;
    private final int TOTAL_BOMBS = 1;

    public static void main(String[] args) { new MineSweeper(); }

    public MineSweeper() {
        game = new Game(COLS, ROWS, TOTAL_BOMBS);
        game.start();
        setImage();
        iniPanel();
        initFrame();
    }

    private void iniPanel(){
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
//                setStartView(g);
//                for(Box box : Box.values()) {
//                    Coord coord = new Coord(box.ordinal() * IMG_SIZE, 0);
//                    g.drawImage((Image)box.image, coord.x ,coord.y,this);
//                }
                for(Coord coord : Ranges.getAllCoords()){
                    g.drawImage((Image)game.getBox(coord).image, PANEL_OFFSET+coord.x*IMG_SIZE, PANEL_OFFSET+coord.y*IMG_SIZE, this);
                }
            }
        };
        panel.setPreferredSize(new Dimension(
                Ranges.getSize().x * IMG_SIZE,
                Ranges.getSize().y * IMG_SIZE));
        add(panel);
    }

    public void initFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));
        pack();
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
