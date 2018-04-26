//    This is free and unencumbered software released into the public domain.
//
//    Anyone is free to copy, modify, publish, use, compile, sell, or
//    distribute this software, either in source code form or as a compiled
//    binary, for any purpose, commercial or non-commercial, and by any
//    means.
//
//    In jurisdictions that recognize copyright laws, the author or authors
//    of this software dedicate any and all copyright interest in the
//    software to the public domain. We make this dedication for the benefit
//    of the public at large and to the detriment of our heirs and
//    successors. We intend this dedication to be an overt act of
//    relinquishment in perpetuity of all present and future rights to this
//    software under copyright law.
//
//    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
//    EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
//    MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
//    IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
//    OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
//    ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
//    OTHER DEALINGS IN THE SOFTWARE.
//
//    For more information, please refer to <http://unlicense.org> 

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
        ButtonGroup radioGroup = new ButtonGroup();
        JRadioButton radioIngles = new JRadioButton("Inglês");
        JRadioButton radioPortugues = new JRadioButton("Português");
        
        JTextField textPalavra = new JTextField("",15);
        JLabel textTraducao = new JLabel("");

    public FrameTraduzir() {
        super();
        this.setBorder(javax.swing.BorderFactory.createTitledBorder("Traduzir"));
        this.setLayout(new GridBagLayout());
        
        radioIngles.setSelected(true);
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
        this.add(textTraducao, Utils.createGridBagConstraints(1, 2));
        //this.add(new JLabel("wwwwww"), Utils.createGridBagConstraints(1, 2));
        
        
    }

    private void traduzirItem() {
        if (radioIngles.isSelected() == true) {
           if (textPalavra.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Por favor insira uma palavra.");
            } else {
                 textTraducao.setText("Traduzido para Inglês: '" + textPalavra.getText() + "'.");
            }
        }
        if (radioPortugues.isSelected() == true) {
            if (textPalavra.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Por favor insira uma palavra.");
            } else {
                textTraducao.setText("Traduzido para Português: '" + textPalavra.getText() + "'.");
            }
        }
    }
}
