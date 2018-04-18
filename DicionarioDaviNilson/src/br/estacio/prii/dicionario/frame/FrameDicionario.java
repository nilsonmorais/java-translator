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

/**
 *
 * @author aluno
 */
public class FrameDicionario extends JFrame {

    final static String APPTITLE = "Dicionário";

    public FrameDicionario() throws HeadlessException {
        initFrame();
    }

    private void initFrame() {
        setFrameOptions();
        createMenus();
        addComponents();
        pack();
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
        MenuItem traduzirMenuItem = new MenuItem("Traduzir");
        traduzirMenuItem.setActionCommand("Traduzir");

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

    private CardLayoutDicionario createCardLayout() {
        CardLayoutDicionario cl = new CardLayoutDicionario();
        return cl;
    }

    private JToolBar createToolbar() {
        final JToolBar toolBar = new JToolBar();
        toolBar.setBorderPainted(false);
        toolBar.setFloatable(false);

        JButton btnChange = Utils.createButtonWithIcon("Operação", "Undo24.gif");
        ActionListener btnChangeAction = null;
        btnChange.addActionListener(btnChangeAction);

        toolBar.add(btnChange);
        toolBar.addSeparator(new Dimension(2, 0));

        return toolBar;
    }

    private void setFrameOptions() {
        setTitle(APPTITLE); // título do Frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); // não permite o redimensionamento
        Utils.centerWindow(this);

    }

    private void addComponents() {
        Container pane = this.getContentPane();

        pane.setLayout(new GridBagLayout());
        pane.add(createToolbar(), Utils.createGridBagConstraints(0, 0, null, null));
        pane.add(createCardLayout(), Utils.createGridBagConstraints(0, 1, null, null));
    }

}
