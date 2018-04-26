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
import br.estacio.prii.dicionario.entidade.Traducao;
import br.estacio.prii.dicionario.utils.Utils;
import static br.estacio.prii.dicionario.utils.Utils.getIconForButton;
import static br.estacio.prii.dicionario.utils.Utils.showDialog;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
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

    ButtonGroup radioGroup = new ButtonGroup();

    private final JRadioButton radioIngles = new JRadioButton("Inglês");
    private final JRadioButton radioPortugues = new JRadioButton("Português");
    private final JTextField textPalavra = new JTextField("", 15);
    private final JTextField textTraducao = new JTextField("", 15);

    public FrameCadastrar() {
        super();

        this.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar"));
        this.setLayout(new GridBagLayout());

        ButtonGroup radioGroup = new ButtonGroup();
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
            try {
                cadastrarItem();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        this.add(btnCadastrar, Utils.createGridBagConstraints(0, 2, Utils.pad20, null));
    }

    private void cadastrarItem() {
        try {
            String sPalavra = textPalavra.getText();
            String sTraducao = textTraducao.getText();
            Traducao t = new Traducao();
            if (radioIngles.isSelected()) {
                t.setPalavraIngles(sPalavra);
                t.setPalavraPortugues(sTraducao);
            } else {
                t.setPalavraIngles(sTraducao);
                t.setPalavraPortugues(sPalavra);
            }
            FrameDicionario.mainDicionario.addTraducaoToDicionario(t);
            FrameDicionario.refreshList();
            Utils.showDialog("Item Cadastrado "+t.toString());
        } catch (Exception exception) {
            showDialog(exception.getMessage());
        }
    }
}
