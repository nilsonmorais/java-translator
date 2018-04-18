/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prii.dicionario.frame;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import br.estacio.prii.dicionario.utils.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author aluno
 */
public class FrameDicionario extends JFrame {

    final static String APPTITLE = "Dicionário";
    private final CardLayoutDicionario cardLayoutDicionario = new CardLayoutDicionario();

    public FrameDicionario() throws HeadlessException {
        super();
        initFrame();
    }

    private void initFrame() {
        setFrameOptions();
        createMenus();
        addComponents();
    }

    private void createMenus() {
        final MenuBar menuBar = new MenuBar();

        //Menu Arquivo
        Menu fileMenu = new Menu("Arquivo");

        MenuItem sobreMenuItem = new MenuItem("Sobre");
        sobreMenuItem.setActionCommand("Sobre");
        MenuItem sairMenuItem = new MenuItem("Sair");
        sairMenuItem.setActionCommand("Sair");

        //Menu Dicionario
        Menu fileDic = new Menu("Dicionário");

        MenuItem salvarMenuItem = new MenuItem("Salvar");
        salvarMenuItem.setActionCommand("Salvar");
        MenuItem carregarMenuItem = new MenuItem("Carregar");
        carregarMenuItem.setActionCommand("Carregar");

        //Menu Operações
        Menu fileOp = new Menu("Operação");

        MenuItem cadastrarMenuItem = new MenuItem("Cadastrar");
        cadastrarMenuItem.setActionCommand("Cadastrar");
        cadastrarMenuItem.addActionListener((ActionEvent e) -> {
            cardLayoutDicionario.changeLayoutEvent(cadastrarMenuItem.getActionCommand());
        });
        MenuItem traduzirMenuItem = new MenuItem("Traduzir");
        traduzirMenuItem.setActionCommand("Traduzir");
        traduzirMenuItem.addActionListener((ActionEvent e) -> {
            cardLayoutDicionario.changeLayoutEvent(traduzirMenuItem.getActionCommand());
        });

        //EventListener
        MenuItemListener menuItemListener = new MenuItemListener();
        sobreMenuItem.addActionListener(menuItemListener);
        sairMenuItem.addActionListener(menuItemListener);
        salvarMenuItem.addActionListener(menuItemListener);
        carregarMenuItem.addActionListener(menuItemListener);
        cadastrarMenuItem.addActionListener(menuItemListener);
        traduzirMenuItem.addActionListener(menuItemListener);

        //Adicionar filhos
        fileMenu.add(sobreMenuItem);
        fileMenu.add(sairMenuItem);

        fileDic.add(salvarMenuItem);
        fileDic.add(carregarMenuItem);

        fileOp.add(cadastrarMenuItem);
        fileOp.add(traduzirMenuItem);

        //Adicionar pais
        menuBar.add(fileMenu);
        menuBar.add(fileDic);
        menuBar.add(fileOp);

        this.setMenuBar(menuBar);
    }

    private JToolBar createToolbar() {
        final JToolBar toolBar = new JToolBar();
        toolBar.setBorderPainted(false);
        toolBar.setFloatable(false);

        JButton btnChange = Utils.createButtonWithIcon("Operação", "Refresh24.gif");
        JButton btnAbout = Utils.createButtonWithIcon("Sobre", "About24.gif");
        ActionListener btnChangeAction = (ActionEvent e) -> {
            cardLayoutDicionario.toggleLayoutEvent();
        };
        btnChange.addActionListener(btnChangeAction);

        toolBar.add(btnChange);
        toolBar.addSeparator(new Dimension(2, 0));
        toolBar.add(btnAbout);

        return toolBar;
    }

    private void setFrameOptions() {
        setTitle(APPTITLE); // título do Frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); // não permite o redimensionamento
    }

    private void addComponents() {
        Container pane = this.getContentPane();

        pane.setLayout(new GridBagLayout());
        pane.add(createToolbar(), Utils.createGridBagConstraints(0, 0, null, null));
        pane.add(cardLayoutDicionario, Utils.createGridBagConstraints(0, 1, null, null));
        pane.add(new panelListAllWords(), Utils.createGridBagConstraints(0, 2, Utils.pad10, null));
        
        pack();
    }

}
