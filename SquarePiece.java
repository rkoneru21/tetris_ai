import java.awt.Color;

public class SquarePiece extends Piece{
    
    public SquarePiece(){
        super.create(new Color(215, 159, 14));
    }

    public void setXY(int x, int y){
        //  O o
        //  o o 

        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x + Block.SIZE;
        b[1].y = b[0].y;
        b[2].x = b[0].x;
        b[2].y = b[0].y + Block.SIZE;
        b[3].x = b[0].x + Block.SIZE;
        b[3].y = b[0].y + Block.SIZE;
    }

    @Override
    public void getRotation1(int direction){
        
    }

    @Override
    public void getRotation2(int direction){
        
    }

    @Override
    public void getRotation3(int direction){
    }

    @Override
    public void getRotation4(int direction){
    }

}
