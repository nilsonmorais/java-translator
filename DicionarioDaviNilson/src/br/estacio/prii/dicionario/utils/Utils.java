/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prii.dicionario.utils;

import br.estacio.prii.dicionario.frame.FrameDicionario;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author 97836834387
 */
public class Utils {

    /**
     *
     * @param x     Specify the row from left to right starting from zero. 
     * @param y     Specify the column from top to bottom starting from zero. 
     * @param ins   External padding of the component.(Top, Left, Bottom, Right)
     * @param fill  How to resize the component. The values for fill property are: NONE, VERTICAL, HORIZONTAL, VERTICAL and BOTH.
     * @return
     */
    public static GridBagConstraints createGridBagConstraints(int x, int y, java.awt.Insets ins, Integer fill) {
        return _createGridBagConstraints(x, y, ins, fill);
    }
    /**
     *
     * @param x     Specify the row from left to right starting from zero. 
     * @param y     Specify the column from top to bottom starting from zero. 
     * @return
     */
    public static GridBagConstraints createGridBagConstraints(int x, int y) {
        return _createGridBagConstraints(x, y, null, null);
    }
    
    private static GridBagConstraints _createGridBagConstraints(int x, int y, java.awt.Insets ins, Integer fill) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.insets = ins == null ? new Insets(0, 0, 0, 0) : ins;
        c.fill = fill == null ? GridBagConstraints.HORIZONTAL : fill;
        return c;
    }

    public static Dimension getWindowDimensions() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth() / 2);
        int y = (int) (dimension.getHeight() / 2);
        return new Dimension(x, y);
    }

    /**
     * 
     * @param frame  The object to centralize
     */
    public static void centerWindow(JFrame frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    /**
     * 
     * @param label Tooltip for the icon
     * @param icon  The icon filename, ex: Add24.gif
     * @return 
     */
    public static JButton createButtonWithIcon(String label, String icon) {
        JButton button = new JButton();
        button.setBorderPainted(false);
        //button.setText(label);
        button.setToolTipText(label);
        if (icon != null) {
            button.setIcon(getIconForButton("New24.gif"));
        }
        return button;
    }
    private static ImageIcon getIconForButton(String iconName) {
        String urlString = "/toolbarButtonGraphics/general/" + iconName;
        URL url = Utils.class.getClass().getResource(urlString);
        return new ImageIcon(url);
    }
    public static Insets pad10 = new Insets(10, 10, 10, 10);
    public static Insets pad20 = new Insets(20, 20, 20, 20);
}
