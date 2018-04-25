/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prii.dicionario.frame;

import br.estacio.prii.dicionario.entidade.Dicionario;
import br.estacio.prii.dicionario.utils.Utils;
import static br.estacio.prii.dicionario.utils.Utils.getIconForButton;
import static br.estacio.prii.dicionario.utils.Utils.showDialog;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author 97836834387
 */
class panelListAllWords extends JPanel {

    private JScrollPane scrollPanel;
    private JList<String> list;

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
        list = new JList<String>();
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        list.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.setPreferredSize(new Dimension(150, 200));
        scrollPanel.setPreferredSize(new Dimension(150, 200));

       list.setModel(new AbstractListModel<String>() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        scrollPanel.setViewportView(list);

        panelContainer.add(list, Utils.createGridBagConstraints(0, 0));
        return panelContainer;
    }

    private void excluirItem() {
        showDialog("Item excluido");
    }

    void add(String item) {
//        listModel.add(item);
    }

}
