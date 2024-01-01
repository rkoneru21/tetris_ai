import java.awt.Color;

public class TPiece extends Piece{

    Color c = new Color(163, 40, 139);

    public TPiece(){
        super.create(c);
    }

    public void solidify(){
        int indexX;
        int indexY;
        for(int i = 0; i < b.length; i++){
            indexX = ((b[i].x - 490) / Block.SIZE);
            indexY = ((b[i].y - 50)/ Block.SIZE) - 1;
            TetrisManager.board[indexY][indexX] = c;
        }
    }

    public void setXY(int x, int y){
        //    o
        //  o O o
        //

        //    o
        //    O o
        //    o

        //   
        //  o O o
        //    o

        //    o
        //  o O
        //    o

        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y - Block.SIZE;
        b[2].x = b[0].x + Block.SIZE;
        b[2].y = b[0].y;
        b[3].x = b[0].x - Block.SIZE;
        b[3].y = b[0].y;
    }

    @Override
    public void getRotation1(int direction){
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Block.SIZE;
        tempB[2].x = b[0].x + Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y;

        //check for collision

        if(!checkRotationCollision()){
            updateXY(true, direction);
        }
    }

    @Override
    public void getRotation2(int direction){
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x + Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y - Block.SIZE;
        tempB[3].x = b[0].x;
        tempB[3].y = b[0].y + Block.SIZE;

        //check for collision

        if(!checkRotationCollision()){
            updateXY(true, direction);
        }
    }

    @Override
    public void getRotation3(int direction){
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y + Block.SIZE;
        tempB[2].x = b[0].x - Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y;

        //check for collision

        if(!checkRotationCollision()){
            updateXY(true, direction);
        }
    }

    @Override
    public void getRotation4(int direction){
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x - Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y + Block.SIZE;
        tempB[3].x = b[0].x;
        tempB[3].y = b[0].y - Block.SIZE;

        //check for collision

        if(!checkRotationCollision()){
            updateXY(true, direction);
        }
    }
    
}
