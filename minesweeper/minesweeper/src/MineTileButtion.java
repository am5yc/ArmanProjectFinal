
import java.awt.Button;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arman
 */
public class MineTileButtion extends Button 
{
    private static final ImageIcon flag = new ImageIcon (MinesweeperArmanGui.class.getResource("flag.jpg"));
    private static final ImageIcon mine = new ImageIcon (MinesweeperArmanGui.class.getResource("mine.jpg"));
    private static final ImageIcon minex = new ImageIcon (MinesweeperArmanGui.class.getResource("minex.jpg"));
    private static final ImageIcon minered = new ImageIcon (MinesweeperArmanGui.class.getResource("minered.jpg"));

    private int row;
    private int col;
    
    private static minesweeper game;

    public MineTileButtion(int row, int col)
    {
        super();
        this.row = row;
        this.col = col;
    }

    public static void setGame(minesweeper game) {
        MineTileButtion.game = game;
    }
    
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    public void redraw() {
        switch (game.getBoard(this.row, this.col)) {
            case ' ' :
                //If blank
                this.setEnabled(false);
                this.setBackground(Color.WHITE);
                break;
            case '1' :
                this.setEnabled(false);
                this.setLabel("1");
                this.setBackground(Color.BLUE);
                break;
            case '2' :
                this.setEnabled(false);
                this.setLabel("2");
                this.setBackground(Color.GREEN);
                break;
            case '3' :
                this.setEnabled(false);
                this.setLabel("3");
                this.setBackground(Color.RED);
                break;
            case '4' :
                this.setEnabled(false);
                this.setLabel("4");
                this.setBackground(Color.ORANGE);
                break;
            case '5' :
                this.setEnabled(false);
                this.setLabel("5");
                this.setBackground(Color.PINK);
                break;
            case '6' :
                this.setEnabled(false);
                this.setLabel("6");
                this.setBackground(Color.PINK);
                break;
            case '7' :
                this.setEnabled(false);
                this.setLabel("7");
                this.setBackground(Color.PINK);
                break;
            case '8' :
                this.setEnabled(false);
                this.setLabel("8");
                this.setBackground(Color.PINK);
                break;
            case 'X' :
                //If closed
                this.setEnabled(true);
                this.setLabel("");
                this.setBackground(Color.GRAY);
                break;
            case '?' :
                //if Question
                this.setEnabled(true);
                this.setLabel("?");
                this.setBackground(Color.LIGHT_GRAY);
                break;
            case '*' :
                // If mine
                this.setEnabled(false);
                this.setLabel("*");
                this.setBackground(Color.BLACK);
                break;
            case 'F' :
                //if flag
                this.setEnabled(true);
                this.setLabel("F");
                this.setBackground(Color.LIGHT_GRAY);
                break;
                
        }
    }

    public static void mouseClick(MouseEvent event) {
        MineTileButtion click = (MineTileButtion) event.getSource();
        
        if (event.getButton() == 1)
        {
            //If Primary
            game.markTile(click.getRow(), click.getCol(), 0);
            //Open the tile
        } else if (event.getButton() == 3) {
            //If second
            switch (game.getTiles(click.getRow(), click.getCol())) {
                case 1 :
                    //If closed
                    game.markTile(click.getRow(), click.getCol(), 3);
                    break;
                case 3 :
                    //If flag
                    game.markTile(click.getRow(), click.getCol(), 2);
                    break;
                case 2 :
                    //If question
                    game.markTile(click.getRow(), click.getCol(), 1);
                    break;
            }
        }
    }
}
