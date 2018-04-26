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
import static br.estacio.prii.dicionario.utils.Utils.showDialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author 97836834387
 */
class panelListAllWords extends JPanel {

    private JScrollPane scrollPanel;
    private JList<String> list;
    private DefaultListModel listModel = new DefaultListModel();

    public panelListAllWords() {
        super();
        this.setBorder(javax.swing.BorderFactory.createTitledBorder("Dicionário"));
        this.setLayout(new GridBagLayout());

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setIcon(getIconForButton("Delete24.gif"));
        btnExcluir.addActionListener((ActionEvent e) -> {
            excluirItem();
        });

        this.add(CreateListAllWords(), Utils.createGridBagConstraints(0, 0, Utils.pad20, null));
        this.add(btnExcluir, Utils.createGridBagConstraints(1, 0));
        this.add(new JLabel("Total de Palavras: 10"), Utils.createGridBagConstraints(0, 1, Utils.pad10, GridBagConstraints.HORIZONTAL));
    }

    private JPanel CreateListAllWords() {
        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new GridBagLayout());

        scrollPanel = new JScrollPane();
      
        list = new JList(listModel);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        list.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.setPreferredSize(new Dimension(150, 200));
        scrollPanel.setPreferredSize(new Dimension(150, 200));
        scrollPanel.setViewportView(list);

        panelContainer.add(list, Utils.createGridBagConstraints(0, 0));
        return panelContainer;
    }

    private void excluirItem() {
        showDialog("Item excluido");
    }

    public void add(String item) {
        listModel.addElement(item);
    }

    public void clear() {
        listModel.clear();
    }
    public void refresh() {
        
    }

//    private static class DicListModel {
//        private ArrayList<String> dados;
//        public DicListModel() {
//            dados = new ArrayList<>();
//        }
//        public DicListModel(ArrayList list){
//            dados = list;
//        }
//
//        private void clear() {
//            dados.clear();
//        }
//
//        private void add(String item) {
//            dados.add(item);
//        }
//    }

    

}
