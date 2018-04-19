/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prii.dicionario.frame;

import br.estacio.prii.dicionario.utils.Utils;
import static br.estacio.prii.dicionario.utils.Utils.getIconForButton;
import java.awt.GridBagLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author 97836834387
 */
class FrameCadastrar extends JPanel {

    public FrameCadastrar() {
        super();
        
        this.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar"));
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
        
        this.add(radioIngles, Utils.createGridBagConstraints(2, 0, Utils.pad10, null));
        this.add(radioPortugues, Utils.createGridBagConstraints(3, 0, Utils.pad10, null));
        
        
        this.add(new JLabel("Tradução:"), Utils.createGridBagConstraints(0, 1, Utils.pad10, null));
        this.add(textTraducao, Utils.createGridBagConstraints(1, 1));
        
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setIcon(getIconForButton("Save24.gif"));
        
        this.add(btnCadastrar, Utils.createGridBagConstraints(0, 2, Utils.pad20, null));
    }
    
}
