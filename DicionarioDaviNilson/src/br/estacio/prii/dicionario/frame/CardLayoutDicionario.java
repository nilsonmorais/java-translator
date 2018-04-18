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

    final static String ACTION1TEXT = "Cadastrar";
    final static String ACTION2TEXT = "Traduzir";
    private final JComboBox comboSelect;
    
    public CardLayoutDicionario() {

        JPanel comboBoxPane = new JPanel();
        comboBoxPane.setLayout(new GridBagLayout());
        this.setLayout(new GridBagLayout());

        JLabel labelSelectMode = new JLabel("Selecione Operação:");

        String comboBoxItems[] = {ACTION1TEXT, ACTION2TEXT};
        comboSelect = new JComboBox(comboBoxItems);
        comboSelect.setEditable(false);
        comboSelect.addItemListener((ItemEvent e) -> {
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, (String) e.getItem());
        });

        comboBoxPane.add(labelSelectMode, Utils.createGridBagConstraints(0, 0, Utils.pad10, null));
        comboBoxPane.add(comboSelect, Utils.createGridBagConstraints(1, 0));

        //Create the "cards".
        JPanel cardCadastrar = new FrameCadastrar();
        JPanel cardTraduzir = new FrameTraduzir();

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(cardCadastrar, ACTION1TEXT);
        cards.add(cardTraduzir, ACTION2TEXT);

        this.add(comboBoxPane, Utils.createGridBagConstraints(0, 0, Utils.pad10, null));
        this.add(cards, Utils.createGridBagConstraints(0, 1, Utils.pad10, null));
        
    }
    public void changeLayoutEvent(String type){
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, type);
        comboSelect.setSelectedItem(type);
    }

    public void toggleLayoutEvent() {
        String selected = comboSelect.getSelectedItem().toString();
        if (selected.equals(ACTION1TEXT)) {
            changeLayoutEvent(ACTION2TEXT);
        } else {
            changeLayoutEvent(ACTION1TEXT);
        }
    }
}
