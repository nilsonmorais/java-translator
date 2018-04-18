/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prii.dicionario.frame;

import br.estacio.prii.dicionario.utils.Utils;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author aluno
 */
public class CardLayoutDicionario extends JPanel {
    
    JPanel cards; //a panel that uses CardLayout
    
    final static String BUTTONPANEL = "Cadastrar";
    final static String TEXTPANEL = "Traduzir";

    public CardLayoutDicionario() {
        
        JPanel comboBoxPane = new JPanel(); 
        comboBoxPane.setLayout(new GridBagLayout());
        this.setLayout(new GridBagLayout());
        
        JLabel labelSelectMode = new JLabel("Selecione Operação:");
        
        String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener((ItemEvent e) -> {
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, (String)e.getItem());
        });
       
        comboBoxPane.add(labelSelectMode, Utils.createGridBagConstraints(0, 0, Utils.pad10, null));
        comboBoxPane.add(cb,Utils.createGridBagConstraints(1, 0));
         
        //Create the "cards".
        JPanel cardCadastrar = new FrameCadastrar();
        JPanel cardTraduzir = new FrameTraduzir();
         
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(cardCadastrar, BUTTONPANEL);
        cards.add(cardTraduzir, TEXTPANEL);
        
        this.add(comboBoxPane, Utils.createGridBagConstraints(0, 0, Utils.pad10, null));
        this.add(cards, Utils.createGridBagConstraints(0, 1));

    }
    
    
    
}
