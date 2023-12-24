import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{

    public static boolean up, down, right, left, z;

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        switch(keyCode){
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_Z:
                z = true;
                break;
        } 
        /*
        if(keyCode == KeyEvent.VK_UP){
            up = true;
        }
        if(keyCode == KeyEvent.VK_DOWN){
            down = true;
        }
        if(keyCode == KeyEvent.VK_RIGHT){
            right = true;
        }
        if(keyCode == KeyEvent.VK_LEFT){
            left = true;
        } */
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    
}
