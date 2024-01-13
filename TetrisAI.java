import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
//import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class TetrisAI {
    private ArrayList<Integer> nextMoves;
    Robot r;
    private Color[][] newTempBoard;
    int down = 0;

    public TetrisAI(){
        nextMoves = new ArrayList<>();
        newTempBoard = new Color[20][10];
        //nextMoves.add(37);
        //nextMoves.add(37);
        //nextMoves.add(37);
        //nextMoves.add(32);
        try {
            r = new Robot();
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void nextMove(){
        long startTime = System.nanoTime();
        copyBoard();
        /*
        for(int i= 0; i < newTempBoard.length; i++){
            for(int j = 0; j < newTempBoard[0].length; j++){
                if(newTempBoard[i][j] == null){
                    System.out.print("- ");
                } else{
                    System.out.print("o ");
                }
            }
            System.out.println();
        }
        */
        if(this.nextMoves.size() == 0){
            this.addNextMoves();
        }
        /*
        for(Integer i: nextMoves){
            System.out.println(i);
        }*/
        
        //System.out.println("iytyu");
        r.keyPress(nextMoves.get(0));
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.keyRelease(nextMoves.remove(0)); 
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;
        System.out.println(duration);

    }

    public void addNextMoves(){
        Piece curr = TetrisManager.currentPiece.clone();
        int smallestScore = 100000000;
        ArrayList<Integer> moves = new ArrayList<>();
        int temp;
        //copyBoard();

        //System.out.println(TetrisManager.currentPiece.getNumRotations() +" ojoi");
        for(int i = 1; i <= TetrisManager.currentPiece.getNumRotations(); i++){
            if(i == 1){
                curr.getRotation1(1);
            }else if(i == 2){
                curr.getRotation2(1);
            }else if(i == 3){
                curr.getRotation3(1);
            } else{
                curr.getRotation4(1);
            }

            int leftRemaining = (curr.getLeftX() - TetrisManager.leftX)/Block.SIZE;
            int rightRemaining = ((TetrisManager.rightX - curr.getRightX())/Block.SIZE) - 1;

            //System.out.println(leftRemaining);
            
            int indexX;
            int indexY;
            //check all left
            for(int j = 1; j <= leftRemaining; j++){
                //System.out.println(j);
                copyBoard();
                
                //move the piece to position
                curr.b[0].x -= (Block.SIZE);
                curr.b[1].x -= (Block.SIZE);
                curr.b[2].x -= (Block.SIZE);
                curr.b[3].x -= (Block.SIZE);
                while(!checkTempDownCollision(curr)){
                    curr.b[0].y += Block.SIZE;
                    curr.b[1].y += Block.SIZE;
                    curr.b[2].y += Block.SIZE;
                    curr.b[3].y += Block.SIZE;
                    down++;
                }
                
                for(int s = 0; s < curr.b.length; s++){
                    indexX = ((curr.b[s].x - 490) / Block.SIZE);
                    indexY = ((curr.b[s].y - 50)/ Block.SIZE) - 1;
                    newTempBoard[indexY][indexX] = Color.BLACK;
                }
                //rate board
                temp = rateBoard();
                //if board rating is smaller, make it the new smallest
                if(temp < smallestScore){
                    smallestScore = temp;
                    moves.removeAll(moves);
                    for(int h = 0; h < i - 1; h++){
                        moves.add(38);
                    }
                    for(int g = 0; g < j; g++){
                        moves.add(37);
                    }
                    moves.add(32);
                }

                for(int t = 0; t < down; t++){
                    curr.b[0].y -= Block.SIZE;
                    curr.b[1].y -= Block.SIZE;
                    curr.b[2].y -= Block.SIZE;
                    curr.b[3].y -= Block.SIZE;
                }
                down = 0;
            }
            for(int v = 0; v < leftRemaining; v++){
                curr.b[0].x += (Block.SIZE);
                curr.b[1].x += (Block.SIZE);
                curr.b[2].x += (Block.SIZE);
                curr.b[3].x += (Block.SIZE);
            }

            //check center
            
            copyBoard();

            //move the piece to position
            while(!checkTempDownCollision(curr)){
                curr.b[0].y += Block.SIZE;
                curr.b[1].y += Block.SIZE;
                curr.b[2].y += Block.SIZE;
                curr.b[3].y += Block.SIZE;
                down++;
            }
            
            for(int s = 0; s < curr.b.length; s++){
                indexX = ((curr.b[s].x - 490) / Block.SIZE);
                indexY = ((curr.b[s].y - 50)/ Block.SIZE) - 1;
                newTempBoard[indexY][indexX] = Color.BLACK;
            }
            //rate board
            temp = rateBoard();
            //if board rating is smaller, make it the new smallest
            if(temp < smallestScore){
                smallestScore = temp;
                moves.removeAll(moves);
                for(int h = 0; h < i - 1; h++){
                    moves.add(38);
                }
                moves.add(32);
            }

            for(int t = 0; t < down; t++){
                curr.b[0].y -= Block.SIZE;
                curr.b[1].y -= Block.SIZE;
                curr.b[2].y -= Block.SIZE;
                curr.b[3].y -= Block.SIZE;
            }
            down = 0;
            
            //check all right
            for(int k = 0; k < rightRemaining; k++){
                //System.out.println(j);
                copyBoard();
                
                //move the piece to position
                curr.b[0].x += (Block.SIZE);
                curr.b[1].x += (Block.SIZE);
                curr.b[2].x += (Block.SIZE);
                curr.b[3].x += (Block.SIZE);
                while(!checkTempDownCollision(curr)){
                    curr.b[0].y += Block.SIZE;
                    curr.b[1].y += Block.SIZE;
                    curr.b[2].y += Block.SIZE;
                    curr.b[3].y += Block.SIZE;
                    down++;
                }
                //int indexX;
                //int indexY;
                for(int s = 0; s < curr.b.length; s++){
                    indexX = ((curr.b[s].x - 490) / Block.SIZE);
                    indexY = ((curr.b[s].y - 50)/ Block.SIZE) - 1;
                    newTempBoard[indexY][indexX] = Color.BLACK;
                }
                //rate board
                temp = rateBoard();
                //if board rating is smaller, make it the new smallest
                if(temp < smallestScore){
                    smallestScore = temp;
                    moves.removeAll(moves);
                    for(int h = 0; h < i - 1; h++){
                        moves.add(38);
                    }
                    for(int g = 0; g < k; g++){
                        moves.add(39);
                    }
                    moves.add(32);
                }

                for(int t = 0; t < down; t++){
                    curr.b[0].y -= Block.SIZE;
                    curr.b[1].y -= Block.SIZE;
                    curr.b[2].y -= Block.SIZE;
                    curr.b[3].y -= Block.SIZE;
                }
                down = 0;
            }
            for(int v = 0; v < rightRemaining; v++){
                curr.b[0].x -= (Block.SIZE);
                curr.b[1].x -= (Block.SIZE);
                curr.b[2].x -= (Block.SIZE);
                curr.b[3].x -= (Block.SIZE);
            }

            nextMoves.addAll(moves);
        }

    }

    public int rateBoard(){
        //penalize holes
        //penalize height
        //penalize 3 tall pillars(more than 1)
        //penalize bumpiness
        //penalize blocks in the rightmost column
        //penalize blocks above holes
        //penalize clearing 1, 2 or 3 lines
        //reward tetris's
        int holes = 0; //done
        int maxHeight = 0; //done
        int pillars = 0; //done
        int bumpy = 0; //done
        int rightBlocks = 0; //done
        //int blocksAboveHoles = 0;//done
        int linesCleared = 0; //done
        int[] colHeights = new int[10];

        
        boolean first;
        for(int i = 0; i < newTempBoard[0].length; i++){
            int holesInCol = 0;
            first = true;
            for(int j = 0; j < newTempBoard.length; j++){
                
                if(newTempBoard[j][i] != null && first){
                    colHeights[i] = 20-j;
                    if((20-j) > maxHeight){
                        maxHeight = 20-j;
                    }
                    first = false;
                }

                if(!first && newTempBoard[j][i] == null){
                    holes++;
                    holesInCol++;
                    int blocks = (colHeights[i] - (20-j) - (holesInCol - 1));
                    //blocksAboveHoles += blocks;
                }

                if(i == 9 && newTempBoard[j][i] != null){
                    rightBlocks++;
                }
            }
        }

        for(int i = 0; i < colHeights.length - 2; i++){
            bumpy += Math.abs(colHeights[i] - colHeights[i + 1]);
            if(i == 0){
                if(colHeights[i] - colHeights[i + 1] <= -3){
                    pillars++;
                }
            } else {
                if(colHeights[i-1] - colHeights[i] >= 3 && colHeights[i+1] - colHeights[i] >= 3){
                    pillars++;
                }
            }
        }
        
        System.out.println("holes: " + holes);
        System.out.println("max Height: " + maxHeight);
        System.out.println("Pillars: " + pillars);
        System.out.println("Bumpiness: " + bumpy);
        System.out.println("right blocks: " + rightBlocks);
        //System.out.println("Blocks above holes: " + blocksAboveHoles);
        System.out.println("lines cleared: " + linesCleared);
        

        //(10 * holes) 
        //(4 * maxHeight)
        //(8 * pillars)
        //(3 * bumpy)
        //(8 * rightBlocks)
        //(8 * blocksAboveHoles)
        //(8/(4-linesCleared))

        return (20 * holes) + (20 * maxHeight) + (3 * bumpy) + (8 * rightBlocks) + (8 * pillars)  + (8/(4-linesCleared));
        //return (4 * holes);

        //return 1;
    }

    public boolean isRowEmpty(int index){
        if(newTempBoard[index][9] != null){
            for(int j = 0; j < 9; j++){
                if(newTempBoard[index][j] == null){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    

    public void copyBoard(){
        for(int i = 0; i < TetrisManager.tempBoard.length; i++){
            for(int j = 0; j < TetrisManager.tempBoard[0].length; j++){
                if(TetrisManager.tempBoard[i][j] != null){
                    newTempBoard[i][j] = new Color(TetrisManager.tempBoard[i][j].getRGB());
                } else {
                    newTempBoard[i][j] = TetrisManager.tempBoard[i][j];
                }
            }
        }
    }

    public boolean checkTempDownCollision(Piece curr){
        int index;
        int indexX;
        for(int i = 0; i < curr.b.length; i++){
            index = (curr.b[i].y / Block.SIZE) - 1;
            indexX = ((curr.b[i].x - 490) / Block.SIZE);
            if(curr.b[i].y  == TetrisManager.bottomY){
                return true;
            }
            for(int j = 0; j < TetrisManager.tempBoard[0].length; j++){
                if(TetrisManager.tempBoard[index][indexX] != null){
                    return true;
                }
            }
        }
        

        return false;
    }

     
    
}
