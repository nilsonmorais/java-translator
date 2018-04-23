/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prii.dicionario.frame;

import br.estacio.prii.dicionario.utils.Utils;
import static br.estacio.prii.dicionario.utils.Utils.getIconForButton;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author 97836834387
 */
class FrameTraduzir extends JPanel {

    public FrameTraduzir() {
        super();
        this.setBorder(javax.swing.BorderFactory.createTitledBorder("Traduzir"));
        this.setLayout(new GridBagLayout());
        
        JTextField textPalavra = new JTextField("",15);
        JTextField textTraducao = new JTextField("",15);
        
        ButtonGroup radioGroup = new ButtonGroup();
        JRadioButton radioIngles = new JRadioButton("Inglês");
        radioIngles.setSelected(true);
        JRadioButton radioPortugues = new JRadioButton("Português");
        radioGroup.add(radioIngles);
        radioGroup.add(radioPortugues);
        
        this.add(new JLabel("Palavra:"), Utils.createGridBagConstraints(0, 0, Utils.pad10, null));
        this.add(textPalavra, Utils.createGridBagConstraints(1, 0));
        

        this.add(new JLabel("Traduzir para:"), Utils.createGridBagConstraints(0, 1, Utils.pad10, null));
        this.add(radioIngles, Utils.createGridBagConstraints(1, 1));
        this.add(radioPortugues, Utils.createGridBagConstraints(2, 1));
        JButton btnTraduzir = new JButton("Traduzir");
        btnTraduzir.setIcon(getIconForButton("Edit24.gif"));
        btnTraduzir.addActionListener((ActionEvent e) -> {
            traduzirItem();
        });
        
        this.add(btnTraduzir, Utils.createGridBagConstraints(3, 1));
        
        this.add(new JLabel("Tradução:"), Utils.createGridBagConstraints(0, 2, Utils.pad10, null));
        this.add(new JLabel("wwwwww"), Utils.createGridBagConstraints(1, 2));
        
        
    }

    private void traduzirItem() {
        JOptionPane.showMessageDialog(null, "Ok.");  //remover esse dialogo depois e adicionar a funçao no lugar
    }

}
