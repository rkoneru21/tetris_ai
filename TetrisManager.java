

//Manages gameplay elements such as drawing the play area and handling gameplay actions

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;

//import javax.sound.sampled.Line;

public class TetrisManager {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 600;
    public static int leftX;
    public static int rightX;
    public static int topY;
    public static int bottomY;
    public static int dropInterval = 60;
    public static Random r;
    public static Boolean[][] board;

    static Piece currentPiece;
    static final int PIECE_START_X = (TetrisPanel.WIDTH/2) - Block.SIZE;
    static final int PIECE_START_Y = 50 + Block.SIZE;

    public TetrisManager(){
        leftX = (TetrisPanel.WIDTH/2) - (WIDTH/2);
        rightX = leftX + WIDTH;
        topY = 50;
        bottomY = topY + HEIGHT;
        r = new Random();
        board = new Boolean[20][10];

        //PIECE_START_X = leftX + (WIDTH/2) - Block.SIZE;
        //PIECE_START_Y = topY + Block.SIZE;

        currentPiece = new LPiece();
        currentPiece.setXY(PIECE_START_X, PIECE_START_Y);
    }

    public void update(){
        currentPiece.update();
    }

    public static void nextPiece(){
        int tnum = r.nextInt(7);
        System.out.println(tnum);
        switch(tnum){
            case 0:
                currentPiece = new LinePiece();
                break;
            case 1:
                currentPiece = new LPiece();
                break;
            case 2:
                currentPiece = new JPiece();
                break;
            case 3:
                currentPiece = new TPiece();
                break;
            case 4:
                currentPiece = new SquarePiece();
                break;
            case 5:
                currentPiece = new SPiece();
                break;
            case 6:
                currentPiece = new ZPiece();
                break;
        }
        currentPiece.setXY(PIECE_START_X, PIECE_START_Y);
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(leftX - 4, topY - 4, WIDTH + 8, HEIGHT + 8);

        int x = rightX + 100;
        int y = bottomY - 200;
        g2.drawRect(x, y, 200, 200);
        g2.setFont(new Font("Arial", Font.PLAIN, 30));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("NEXT", x + 60, y - 20);

        if(currentPiece != null){
            currentPiece.draw(g2);
        }
    }
}
