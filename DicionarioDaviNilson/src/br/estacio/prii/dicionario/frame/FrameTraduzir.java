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

import br.estacio.prii.dicionario.entidade.Dicionario;
import br.estacio.prii.dicionario.entidade.TraducaoException;
import br.estacio.prii.dicionario.utils.Utils;
import static br.estacio.prii.dicionario.utils.Utils.getIconForButton;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Panel que contem os componentes graficos para tradução
 */
class FrameTraduzir extends JPanel {

    ButtonGroup radioGroup = new ButtonGroup();
    JRadioButton radioIngles = new JRadioButton("Inglês");
    JRadioButton radioPortugues = new JRadioButton("Português");
    JLabel labelResultado = new JLabel(" ");
    JTextField textPalavra = new JTextField("", 25);

    public FrameTraduzir() {
        this.setBorder(javax.swing.BorderFactory.createTitledBorder("Traduzir"));
        this.setLayout(new GridBagLayout());
        setPreferredSize(new java.awt.Dimension(400, 200));

        radioIngles.setSelected(true);
        radioGroup.add(radioIngles);
        radioGroup.add(radioPortugues);

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = Utils.pad10;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx=1;c.weighty=1;
        this.add(new JLabel("Palavra:"), c);
        c.gridx = 1;
        c.gridy = 0;
        textPalavra.setSize(200, 25);
        this.add(textPalavra, c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(new JLabel("Traduzir do:"), c);
        c.gridx = 1;
        c.gridy = 1;
        this.add(radioIngles, c);
        c.gridx = 2;
        c.gridy = 1;
        this.add(radioPortugues, c);

        JButton btnTraduzir = new JButton("Traduzir");
        btnTraduzir.setIcon(getIconForButton("Edit24.gif"));
        btnTraduzir.addActionListener((ActionEvent e) -> {
            traduzirItem();
        });

        c.gridx = 0;
        c.gridy = 2;
        c.fill=GridBagConstraints.NONE;
        this.add(btnTraduzir, c);

        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.CENTER;
        this.add(labelResultado, c);

    }

    /**
     * Chama metodo do dicionario para traduzir a palavra inserida na GUI.
     */
    private void traduzirItem() {
        try {
            if (radioIngles.isSelected()) {
                if (textPalavra.getText().isEmpty()) {
                    Utils.showDialog("Por favor insira uma palavra.");
                } else {
                    String traducao = FrameDicionario.mainDicionario.traduzirPalavra(textPalavra.getText(), Dicionario.linguagemType.INGLES);
                    labelResultado.setText("Palavra em Português: '" + traducao + "'.");
                }
            }
            if (radioPortugues.isSelected()) {
                if (textPalavra.getText().isEmpty()) {
                    Utils.showDialog("Por favor insira uma palavra.");
                } else {
                    String traducao = FrameDicionario.mainDicionario.traduzirPalavra(textPalavra.getText(), Dicionario.linguagemType.PORTUGUES);
                    labelResultado.setText("Palavra em Inglês: '" + traducao + "'.");
                }
            }
        } catch (TraducaoException e) {
            Utils.showDialog(e.getMessage());
        }
    }
}
