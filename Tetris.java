import javax.swing.JFrame;

public class Tetris{

    public static void main(String args[]){
        JFrame window = new JFrame("Tetris");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
        TetrisPanel panel = new TetrisPanel();
        window.add(panel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        panel.launch();

    }

}
