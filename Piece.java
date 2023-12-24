import java.awt.Color;
import java.awt.Graphics2D;

public class Piece {
    
    public Block[] b = new Block[4];
    public Block[] tempB = new Block[4];
    int num = 0;
    int state;

    public void create(Color c){
        b[0] = new Block(c);
        b[1] = new Block(c);
        b[2] = new Block(c);
        b[3] = new Block(c);
        tempB[0] = new Block(c);
        tempB[1] = new Block(c);
        tempB[2] = new Block(c);
        tempB[3] = new Block(c);
        this.state = 1;
    }

    public void setXY(int x, int y){

    }

    public void updateXY(boolean passedCollision, int direction){
        if (passedCollision) {
            b[0].x = tempB[0].x;
            b[0].y = tempB[0].y;
            b[1].x = tempB[1].x;
            b[1].y = tempB[1].y;
            b[2].x = tempB[2].x;
            b[2].y = tempB[2].y;
            b[3].x = tempB[3].x;
            b[3].y = tempB[3].y;
            if(direction == 1){
                if(state == 4){
                    state = 1;
                } else {
                    state++;
                }
            } else{
                if(state == 1){
                    state = 4;
                } else {
                    state --;
                }
            }
        }
    }
    public void getRotation1(int direction){}
    public void getRotation2(int direction){}
    public void getRotation3(int direction){}
    public void getRotation4(int direction){}
    public boolean checkLeftCollision(){
        for(int i = 0; i < b.length; i++){
            if(b[i].x == TetrisManager.leftX){
                return true;
            }
        }
        return false;
    }

    public boolean checkRightCollision(){
        for(int i = 0; i < b.length; i++){
            if(b[i].x == TetrisManager.rightX - Block.SIZE){
                return true;
            }
        }
        return false;
    }

    public boolean checkDownCollision(){
        for(int i = 0; i < b.length; i++){
            if(b[i].y + Block.SIZE == TetrisManager.bottomY){
                return true;
            }
        }
        return false;
    }

    public void checkRotationCollision(){

    }
    public void update(){

        if(InputHandler.up){
            switch(state){
                case 1:
                    getRotation2(1);
                    break;
                case 2:
                    getRotation3(1);
                    break;
                case 3:
                    getRotation4(1);
                    break;
                case 4:
                    getRotation1(1);
                    break;
            }
            InputHandler.up = false;
        }
        if(InputHandler.z){
            switch(state){
                case 1:
                    getRotation4(-1);
                    break;
                case 2:
                    getRotation1(-1);
                    break;
                case 3:
                    getRotation2(-1);
                    break;
                case 4:
                    getRotation3(-1);
                    break;
            }
            InputHandler.z = false;
        }
        if(InputHandler.down){
            if(!checkDownCollision()){
                b[0].y += Block.SIZE;
                b[1].y += Block.SIZE;
                b[2].y += Block.SIZE;
                b[3].y += Block.SIZE;
            }

            num = 0;
            InputHandler.down = false;
        }
        if(InputHandler.right){
            if(!checkRightCollision()){
                b[0].x += Block.SIZE;
                b[1].x += Block.SIZE;
                b[2].x += Block.SIZE;
                b[3].x += Block.SIZE;

                
            }
            InputHandler.right = false;
        }
        if(InputHandler.left){
            if(!checkLeftCollision()){
                b[0].x -= Block.SIZE;
                b[1].x -= Block.SIZE;
                b[2].x -= Block.SIZE;
                b[3].x -= Block.SIZE;

                
            }
            InputHandler.left = false;
        }

        if(checkDownCollision()){
            
            TetrisManager.nextPiece();
        }



        num++;
        if(num == TetrisManager.dropInterval && !checkDownCollision()){
            b[0].y += Block.SIZE;
            b[1].y += Block.SIZE;
            b[2].y += Block.SIZE;
            b[3].y += Block.SIZE;
            num = 0;
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(b[0].c);
        g2.fillRect(b[0].x, b[0].y, Block.SIZE, Block.SIZE);
        g2.fillRect(b[1].x, b[1].y, Block.SIZE, Block.SIZE);
        g2.fillRect(b[2].x, b[2].y, Block.SIZE, Block.SIZE);
        g2.fillRect(b[3].x, b[3].y, Block.SIZE, Block.SIZE);
    }
}
