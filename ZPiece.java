import java.awt.Color;

public class ZPiece extends Piece{

    public ZPiece(){
        super.create(new Color(197, 11, 59));
    }

    public void setXY(int x, int y){
        //
        //  o O
        //    o o

        //    o
        //  o O
        //  o

        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x - Block.SIZE;
        b[1].y = b[0].y;
        b[2].x = b[0].x;
        b[2].y = b[0].y + Block.SIZE;
        b[3].x = b[0].x + Block.SIZE;
        b[3].y = b[0].y + Block.SIZE;
    }

    @Override
    public void getRotation1(int direction){
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x - Block.SIZE;
        tempB[1].y = b[0].y;
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
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Block.SIZE;
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
        getRotation1(direction);
    }

    @Override
    public void getRotation4(int direction){
        getRotation2(direction);
    }
    
}
