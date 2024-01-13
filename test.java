import java.awt.Color;

public class test {
    

    public static void main(String[] args){
        Color[][] newTempBoard = new Color[20][10];
        newTempBoard[19][1] = Color.BLACK;
        newTempBoard[18][1] = Color.BLACK;
        newTempBoard[17][1] = Color.BLACK;
        newTempBoard[19][1] = Color.BLACK;
        
        //newTempBoard[19][3] = Color.BLACK;        
        System.out.println(rateBoard(newTempBoard));
    }

    public static int rateBoard(Color[][] newTempBoard){
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
        int blocksAboveHoles = 0;//done
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
                    blocksAboveHoles += blocks;
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
        System.out.println("Blocks above holes: " + blocksAboveHoles);
        System.out.println("lines cleared: " + linesCleared);
        

        //(10 * holes) 
        //(4 * maxHeight)
        //(8 * pillars)
        //(3 * bumpy)
        //(8 * rightBlocks)
        //(8 * blocksAboveHoles)
        //(8/(4-linesCleared))

        return (20 * holes) + (20 * maxHeight) + (3 * bumpy) + (8 * rightBlocks) + (8 * pillars) + (8 * blocksAboveHoles) + (8/(4-linesCleared));
        //return (4 * holes);

        //return 1;
    }
}
