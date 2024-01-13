

//Manages gameplay elements such as drawing the play area and handling gameplay actions

import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
    public static Color[][] board;
    public static Color[][] tempBoard;
    public static ArrayList<Piece> nextPieces;
    public Piece next;
    public static int score;
    int lit = 0;
    public TetrisAI ai;
    

    static Piece currentPiece;
    static final int PIECE_START_X = (TetrisPanel.WIDTH/2) - Block.SIZE;
    static final int PIECE_START_Y = 50 + Block.SIZE;

    public TetrisManager(){
        leftX = (TetrisPanel.WIDTH/2) - (WIDTH/2);
        rightX = leftX + WIDTH;
        topY = 50;
        bottomY = topY + HEIGHT;
        r = new Random();
        board = new Color[20][10];
        tempBoard = new Color[20][10];
        nextPieces = new ArrayList<>();
        ai = new TetrisAI();

        //PIECE_START_X = leftX + (WIDTH/2) - Block.SIZE;
        //PIECE_START_Y = topY + Block.SIZE;
        
        nextPieces.add(new LPiece());
        nextPieces.add(new LinePiece());
        nextPieces.add(new SquarePiece());
        nextPieces.add(new SPiece());
        nextPieces.add(new ZPiece());
        nextPieces.add(new TPiece());
        nextPieces.add(new JPiece());
        //Collections.shuffle(nextPieces);
        nextPiece();
        currentPiece.setXY(PIECE_START_X, PIECE_START_Y);
    }

    public boolean isRowEmpty(int index){
        if(board[index][9] != null){
            for(int j = 0; j < 9; j++){
                if(board[index][j] == null){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void update(){
        //check for full rows
        int count = 0;
        
        
        if(Tetris.isEnabled){
            ai.nextMove();
        }


        //clear full rows
        for(int i = board.length - 1; i > 1; i--){
			if(isRowEmpty(i)){
                count++;
				for(int j = i; j > 1; j--){
					for(int k = 0; k < board[0].length; k++){
						board[j][k] = board[j-1][k];
						board[j-1][k] = null;
                        tempBoard[j][k] = tempBoard[j-1][k];
						tempBoard[j-1][k] = null;
					}
				}
                i++;
			}
		}

        switch(count){
            case 0:
                break;
            case 1:
                score += 40;
                break;
            case 2:
                score += 100;
                break;
            case 3:
                score += 300;
                break;
            case 4:
                score += 1200;
                break;
        }


        currentPiece.update();
    }

    public static void nextPiece(){
        if(nextPieces.size() == 2){
            ArrayList<Piece> extra = new ArrayList<>();
            extra.add(new LPiece());
            extra.add(new LinePiece());
            extra.add(new SquarePiece());
            extra.add(new SPiece());
            extra.add(new ZPiece());
            extra.add(new TPiece());
            extra.add(new JPiece());
            Collections.shuffle(extra);
            nextPieces.addAll(extra);
        }
        currentPiece = nextPieces.get(0);
        nextPieces.remove(0);
        /*
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
        */
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
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != null){
                    g2.setColor(board[i][j]);
                    g2.fillRect(490 + ((j) * Block.SIZE), 50 + (i * Block.SIZE), Block.SIZE, Block.SIZE);
                }
            }
        }
        next = nextPieces.get(0);
        next.setXY(rightX + 175, topY + 500);
        next.draw(g2);
        if(currentPiece != null){
            currentPiece.draw(g2);
        }
        g2.setColor(Color.WHITE);
        g2.drawString("Score:", leftX - 200, topY + 25);
        String sco = String.valueOf(score);
        g2.drawString(sco, leftX - 200, topY + 75);

    }
}
