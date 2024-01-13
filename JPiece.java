import java.awt.Color;

public class JPiece extends Piece{

    Color c = new Color(58, 65, 198);
    public static int rotations = 4;

    public JPiece(){
        super.create(c);
    }

    public void solidify(){
        int indexX;
        int indexY;
        for(int i = 0; i < b.length; i++){
            indexX = ((b[i].x - 490) / Block.SIZE);
            indexY = ((b[i].y - 50)/ Block.SIZE) - 1;
            TetrisManager.board[indexY][indexX] = c;
            TetrisManager.tempBoard[indexY][indexX] = c;
        }
    }

    @Override
    public int getNumRotations(){
        return 4;
    }

    

    

    public void setXY(int x, int y){
        //    o
        //    o
        //  o o

        //  o
        //  o o o
        //

        //    o o
        //    o
        //    o

        //
        //  o o o
        //      o

        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y - Block.SIZE;
        b[2].x = b[0].x;
        b[2].y = b[0].y + Block.SIZE;
        b[3].x = b[0].x - Block.SIZE;
        b[3].y = b[0].y + Block.SIZE;
    }

    @Override
    public void getRotation1(int direction){
        //    o
        //    o    <- pivot
        //  o o 
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Block.SIZE;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y + Block.SIZE;
        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;

        //check for collision

        if(!checkRotationCollision()){
            updateXY(true, direction);
        }
    }

    @Override
    public void getRotation2(int direction){
        //  o
        //  o o o
        //  

        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x + Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x - Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y - Block.SIZE;

        //check for collision

        if(!checkRotationCollision()){
            updateXY(true, direction);
        }
    }

    @Override
    public void getRotation3(int direction){
        //    o o
        //    o
        //    o

        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y + Block.SIZE;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y - Block.SIZE;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y - Block.SIZE;

        //check for collision

        if(!checkRotationCollision()){
            updateXY(true, direction);
        }
    }

    @Override
    public void getRotation4(int direction){
        //      
        //  o o o
        //      o

        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x - Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x + Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;

        //check for collision

        if(!checkRotationCollision()){
            updateXY(true, direction);
        }
    }

    @Override
    public JPiece clone(){
        JPiece newPiece = new JPiece();
        newPiece.b = new Block[4];
        newPiece.tempB = new Block[4];

        for (int i = 0; i < 4; i++) {
            newPiece.b[i] = (Block) this.b[i].clone();
            newPiece.tempB[i] = (Block) this.tempB[i].clone();
        }


        return newPiece;
        
    }

}
