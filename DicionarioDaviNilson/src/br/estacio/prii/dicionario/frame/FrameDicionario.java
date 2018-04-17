/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prii.dicionario.frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

/**
 *
 * @author aluno
 */
public class FrameDicionario extends JFrame {
    public static void main (String[] args){
        
    }

    public FrameDicionario() throws HeadlessException {
        initFrame();
    }

    private void initFrame() {
        setTitle("Dicionário"); // título do Frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); // não permite o redimensionamento
        resizeWindow(this);
        centerWindow(this);
        setLayout(new GridLayout(3, 1));
        createMenus();

    }
    public static void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    public static void resizeWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth() / 2);
        int y = (int) (dimension.getHeight() / 2);
        frame.setSize(x, y);
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
}
