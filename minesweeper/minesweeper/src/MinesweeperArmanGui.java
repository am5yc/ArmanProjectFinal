
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arman
 */
public class MinesweeperArmanGui extends JPanel
{
    protected minesweeper game;
    
    private JPanel mainPanel, gamePanel;
    
    private JLabel titleLabel;
    
    private MineTileButtion mineButtions[][] = new MineTileButtion[9][9];
    
    public static void main (String args[])
    {
        JFrame frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MinesweeperArmanGui());
        frame.pack();
        frame.setVisible(true); 
    }

    public MinesweeperArmanGui() 
    {
        this.game = new minesweeper();
        MineTileButtion.setGame(game);
        
        this.mainPanel = new JPanel();
        this.mainPanel.setPreferredSize(new Dimension(400, 500));
        this.mainPanel.setBackground(Color.green);
        add(this.mainPanel);
        titleLabel = new JLabel("Minesweeper", JLabel.CENTER);
        titleLabel.setFont(new Font("Papyrus", Font.ITALIC, 30));
        this.mainPanel.add(titleLabel);
        
        // A panel tile game
        gamePanel = new JPanel();
        gamePanel.setPreferredSize(new Dimension(300, 400));
        gamePanel.setBackground(Color.cyan);
        gamePanel.setLayout(new GridLayout(9, 9));
        
        for (int r = 0; r < this.mineButtions.length; r++) {
            for (int c = 0; c < this.mineButtions[0].length; c++) {
                this.mineButtions[r][c] = new MineTileButtion(r, c);
                this.mineButtions[r][c].addMouseListener(new ClickListner());
                gamePanel.add(this.mineButtions[r][c]);
            } 
        }
        
        this.mainPanel.add(gamePanel);
        redraw();
    }
    
    private void redraw() {
        for (int r = 0; r < mineButtions.length; r++) {
            for (int c = 0; c < mineButtions[0].length; c++) {
                mineButtions[r][c].redraw();
            } 
        }
        
        String status = this.game.getStatus().toLowerCase();
        if (status.contains("win")) {
            //if win
            this.titleLabel.setText("You Won");
        } else if (status.contains("lose")) {
            //if lose
            this.titleLabel.setText("LOL!!! You Are Dead");
        } else if (status.contains("play")) {
            // if game
            this.titleLabel.setText("Minesweeper");
        }
    }
    
    private class ClickListner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            MineTileButtion.mouseClick(e);
            
            //call update code
            redraw();
        }

        @Override
        public void mousePressed(MouseEvent e) {
           //Do nothing
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //Do nothing
        
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //Do nothing
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //Do nothing
        }
        
    }
  
}
