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
class FrameCadastrar extends JPanel {
        ButtonGroup radioGroup = new ButtonGroup();
        JRadioButton radioIngles = new JRadioButton("Inglês");
        JRadioButton radioPortugues = new JRadioButton("Português");
        
        JTextField textPalavra = new JTextField(null,15);
        JTextField textTraducao = new JTextField(null,15);
        
    public FrameCadastrar() {
        super();
        
        this.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar"));
        this.setLayout(new GridBagLayout());
        
        radioIngles.setSelected(true);
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
        btnCadastrar.addActionListener((ActionEvent e) -> {
            cadastrarItem();
        });
        
        this.add(btnCadastrar, Utils.createGridBagConstraints(0, 2, Utils.pad20, null));
    }

    private void cadastrarItem() {
        if (radioIngles.isSelected() == true) {
            if (textPalavra.getText().isEmpty() || textTraducao.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Por favor insira uma palavra e uma tradução.");
            } else {
                JOptionPane.showMessageDialog(null, "Palavra em Inglês cadastrada: '" + textPalavra.getText() +"'.\n"
                    + "Tradução: '" + textTraducao.getText() + "'.");
            }
        }
        if (radioPortugues.isSelected() == true) {
            if (textPalavra.getText().isEmpty() || textTraducao.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Por favor insira uma palavra e uma tradução.");
            } else {
                JOptionPane.showMessageDialog(null, "Palavra em Português cadastrada: '" + textPalavra.getText() +"'.\n"
                    + "Tradução: '" + textTraducao.getText() + "'.");
            }
        }
    }
}
