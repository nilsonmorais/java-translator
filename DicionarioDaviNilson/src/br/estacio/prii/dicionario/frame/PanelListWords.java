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

import br.estacio.prii.dicionario.eventos.OnChangeListener;
import br.estacio.prii.dicionario.utils.Utils;
import static br.estacio.prii.dicionario.utils.Utils.getIconForButton;
import java.awt.Color;
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
class PanelListWords extends JPanel  {

    private JScrollPane scrollPanel;
    private JList<String> list;
    private final DefaultListModel listModel = new DefaultListModel();
    private JLabel labelCount = new JLabel();

    public PanelListWords() {
        setBorder(javax.swing.BorderFactory.createTitledBorder("Dicionário"));
        setLayout(new GridBagLayout());
        setPreferredSize(new java.awt.Dimension(400,200));

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setIcon(getIconForButton("Delete24.gif"));
        btnExcluir.addActionListener((ActionEvent e) -> {
            excluirItemAction();
        });

        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx=0;c.gridy=0;c.anchor = GridBagConstraints.LINE_START;
        this.add(CreateListAllWords(), c);
        
        c.gridx=1;c.gridy=0;c.anchor = GridBagConstraints.PAGE_START;
        this.add(btnExcluir, c);
        
        c.gridx=2;c.gridy=0;c.anchor = GridBagConstraints.PAGE_END;
        this.add(labelCount, c);
        
    }

    private JPanel CreateListAllWords() {
        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new GridBagLayout());
        panelContainer.setPreferredSize(new java.awt.Dimension(200,150));

        
        list = new JList(listModel);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Selecionar somente um item
        list.setPrototypeCellValue("XXXXXXXXXXXXXXXXXXXX");
        list.setPreferredSize(new java.awt.Dimension(200,150));

        scrollPanel = new JScrollPane(list);
        scrollPanel.setSize(new Dimension(200, 150));
        scrollPanel.setViewportView(list);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;c.gridy=0;c.anchor=GridBagConstraints.LINE_START;c.fill = GridBagConstraints.BOTH;
        panelContainer.add(list, c);
        
        return panelContainer;
    }

    private void excluirItemAction() {
        int s = list.getSelectedIndex();
        listModel.remove(s);
        updateCounter();
    }

    public void add(String item) {
        listModel.addElement(item);
        updateCounter();
    }

    public void clear() {
        listModel.clear();
    }

    private void updateCounter() {
        StringBuilder result = new StringBuilder("Total de Palavras: ");
        result.append(listModel.getSize());
        labelCount.setText((String) result.toString());
    }


}
