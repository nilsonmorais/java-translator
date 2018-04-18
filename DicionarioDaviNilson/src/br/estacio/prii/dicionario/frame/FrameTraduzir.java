/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prii.dicionario.frame;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author 97836834387
 */
class FrameTraduzir extends JPanel {

    public FrameTraduzir() {
        this.setBorder(javax.swing.BorderFactory.createTitledBorder("Traduzir"));

        this.add(new JTextField("TextField", 20));
    }

}
