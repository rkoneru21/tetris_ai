import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TetrisPanel extends JPanel implements Runnable{

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    final int FPS = 60;
    Thread gameThread;
    TetrisManager manager;

    public TetrisPanel(){
        super();

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        //setLayout(null);
        
        
        this.addKeyListener(new InputHandler());
        this.setFocusable(true);
        manager = new TetrisManager();
    }

    public void launch(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double d = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){

            currentTime = System.nanoTime();

            d += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(d >= 1){
                update();
                repaint();
                d--;
            }
        }
    }

    private void update(){
        manager.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        manager.draw(g2);
    }
}
