import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Tetris{
    public static boolean isEnabled;
    public static void main(String args[]){
        isEnabled = false;
        JFrame window = new JFrame("Tetris");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        JButton button = new JButton("Enable Tetris AI");
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(isEnabled){
                    isEnabled = false;
                } else if(isEnabled == false){
                    isEnabled = true;
                }
                if(isEnabled)
                {
                    button.setText("Disable Tetris AI");
                } else
                {
                    button.setText("Enable Tetris AI");
                }
            }
        });
        TetrisPanel panel = new TetrisPanel();
        panel.add(button);
        button.setLocation(TetrisManager.rightX + 200, TetrisManager.topY + 200);
        
        window.add(panel);
        window.pack();
        

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        panel.launch();

    }

}
