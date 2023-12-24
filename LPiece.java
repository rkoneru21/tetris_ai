import java.awt.Color;

public class LPiece extends Piece{
    
    

    public LPiece(){
        super.create(new Color(210, 90, 19));
    }

    public void setXY(int x, int y){
        //    o
        //    o    <- pivot
        //    o o

        //
        //  o o o
        //  o

        //  o o
        //    o
        //    o

        //      o
        //  o o o
        //

        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y - Block.SIZE;
        b[2].x = b[0].x;
        b[2].y = b[0].y + Block.SIZE;
        b[3].x = b[0].x + Block.SIZE;
        b[3].y = b[0].y + Block.SIZE;
    }

    @Override
    public void getRotation1(int direction){
        //    o
        //    o    <- pivot
        //    o o
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y ;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Block.SIZE;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y + Block.SIZE;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;

        //check for collision

        //call update
        updateXY(true, direction);
    }

    @Override
    public void getRotation2(int direction){
        //
        //  o o o
        //  o

        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x + Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x - Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;

        //check for collision

        //call update
        updateXY(true, direction);
    }

    @Override
    public void getRotation3(int direction){
        //  o o
        //    o
        //    o

        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y + Block.SIZE;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y - Block.SIZE;
        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y - Block.SIZE;

        //check for collision

        //call update
        updateXY(true, direction);
    }

    @Override
    public void getRotation4(int direction){
        //      o
        //  o o o
        //

        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x - Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x + Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y - Block.SIZE;

        //check for collision

        //call update
        updateXY(true, direction);
    }
}
