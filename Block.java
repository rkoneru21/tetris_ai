import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Block extends Rectangle{
    public int x, y;
    public static final int SIZE = 30;
    public Color c;
    
    public Block(Color c){
        this.c = c;
    }

    @Override
    public Object clone() {
        Block clonedBlock = (Block) super.clone();
        clonedBlock.c = new Color(this.c.getRGB());
        clonedBlock.x = this.x;
        clonedBlock.y = this.y;
        return clonedBlock;
    }

    public void draw(Graphics2D g2){
        g2.setColor(c);
        g2.fillRect(x, y, SIZE, SIZE);
    }
}
