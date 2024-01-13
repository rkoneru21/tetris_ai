import java.awt.Color;

public class SquarePiece extends Piece{

    Color c = new Color(215, 159, 14);
    public static int rotations = 1;
    public SquarePiece(){
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

    @Override
    public SquarePiece clone(){
        SquarePiece newPiece = new SquarePiece();
        newPiece.b = new Block[4];
        newPiece.tempB = new Block[4];

        for (int i = 0; i < 4; i++) {
            newPiece.b[i] = (Block) this.b[i].clone();
            newPiece.tempB[i] = (Block) this.tempB[i].clone();
        }


        return newPiece;
        
    }

}
