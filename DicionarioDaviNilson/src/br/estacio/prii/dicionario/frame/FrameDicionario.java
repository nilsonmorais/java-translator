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
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import br.estacio.prii.dicionario.utils.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Frame Dicionario é o frame principal da Aplicacao
 */
public class FrameDicionario extends JFrame {

    final static String APPTITLE = "Dicionário";

    private final CardLayoutDicionario cardLayoutDicionario = new CardLayoutDicionario();
    final static String ABOUTTEXT = "Trabalho de Programação II.\n"
            + "Tradutor Inglês/Português.\n"
            + "Equipe:\n"
            + "Davi Morais (201703123451)\n"
            + "Nilson Morais (201007055561)\n";
    private final FrameListaPalavras listaDicionario = new FrameListaPalavras();
    public static Dicionario mainDicionario = new Dicionario();

    public FrameDicionario() throws HeadlessException {
        super();

        // Cria um listener para atualizar a lista sempre que houver mudanças no
        // Objeto Dicionario
        mainDicionario.addOnChangeListener(() -> {
            PopularLista();
        });

        initFrame();
        carregarDicionarioAction();
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
        sobreMenuItem.addActionListener((ActionEvent e) -> {
            showAboutDialog();
        });
        MenuItem sairMenuItem = new MenuItem("Sair");
        sairMenuItem.setActionCommand("Sair");
        sairMenuItem.addActionListener((ActionEvent e) -> {
            if (JOptionPane.showConfirmDialog(null,
                    "Tem certeza que deseja sair?",
                    "Confirme a saída.",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        //Menu Dicionario
        Menu fileDic = new Menu("Dicionário");

        MenuItem salvarMenuItem = new MenuItem("Salvar");
        salvarMenuItem.setActionCommand("Salvar");
        salvarMenuItem.addActionListener((ActionEvent ae) -> {
            salvarDicionarioAction();
        });
        MenuItem carregarMenuItem = new MenuItem("Carregar");
        carregarMenuItem.setActionCommand("Carregar");
        carregarMenuItem.addActionListener((ActionEvent ae) -> {
            carregarDicionarioAction();
        });

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
        final JToolBar toolBar = new JToolBar("Toolbar",JToolBar.HORIZONTAL);
        toolBar.setBorderPainted(false);
        toolBar.setFloatable(false);

        JButton btnChange = Utils.createButtonWithIcon("Operação", "Refresh24.gif");
        JButton btnAbout = Utils.createButtonWithIcon("Sobre", "About24.gif");
        ActionListener btnChangeAction = (ActionEvent e) -> {
            cardLayoutDicionario.toggleLayoutEvent();
        };
        ActionListener btnAboutAction = (ActionEvent e) -> {
            showAboutDialog();
        };

        btnAbout.addActionListener(btnAboutAction);
        btnChange.addActionListener(btnChangeAction);

        toolBar.add(btnChange);
        toolBar.add(btnAbout);

        return toolBar;
    }

    private void setFrameOptions() {
        setTitle(APPTITLE); // título do Frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); // não permite o redimensionamento
        setLocationRelativeTo(null);
    }

    private void addComponents() {
        Container pane = this.getContentPane();

        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 0;c.gridy = 0;c.fill = GridBagConstraints.HORIZONTAL;c.weightx=1;c.weighty=1;c.anchor=GridBagConstraints.PAGE_START;
        pane.add(createToolbar(),c);
        c.gridx = 0;c.gridy = 1;c.anchor = GridBagConstraints.CENTER;
        pane.add(cardLayoutDicionario,c);
        c.gridx = 0;c.gridy = 2;c.anchor = GridBagConstraints.PAGE_END;c.insets = Utils.pad10;
        pane.add(listaDicionario,c);
        pack();
    }

    private void showAboutDialog() {
        JOptionPane.showMessageDialog(null, ABOUTTEXT);
    }

    /**
     * Carrega um ArrayList com Traducoes do dicionario e adiciona a JList
     */
    public void PopularLista() {
        ArrayList<Traducao> all = mainDicionario.getDicionario();
        listaDicionario.clear();
        for (int i = 0; i < all.size(); i++) {
            listaDicionario.add(all.get(i).toString());
        }
    }

    /**
     * Aciona gravacao do Dicionario
     */
    private void salvarDicionarioAction() {
        try {
            mainDicionario.GravarDados();
        } catch (Exception e) {
            Utils.showDialog(e.getMessage());
        }
    }

    /**
     * Faz o dicionario carregar os dados
     */
    private void carregarDicionarioAction() {
        try {
            // Carrega traducoes no objeto Dicionario
            mainDicionario.CarregarDados();
            PopularLista();
        } catch (Exception e) {
            Utils.showDialog(e.getMessage());
        }
    }
}
