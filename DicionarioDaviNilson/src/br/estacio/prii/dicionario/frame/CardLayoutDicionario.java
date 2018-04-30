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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author aluno
 */
public class CardLayoutDicionario extends JPanel {

    JPanel cards; //a panel that uses CardLayout

    final static String ACTION1TEXT = "Cadastrar";
    final static String ACTION2TEXT = "Traduzir";
    private final JComboBox comboSelect;
    
    public CardLayoutDicionario() {
        JPanel comboBoxPane = new JPanel();
        comboBoxPane.setLayout(new GridBagLayout());
        this.setLayout(new GridBagLayout());

        JLabel labelSelectMode = new JLabel("Selecione Operação:");

        String comboBoxItems[] = {ACTION1TEXT, ACTION2TEXT};
        comboSelect = new JComboBox(comboBoxItems);
        comboSelect.setEditable(false);
        comboSelect.addItemListener((ItemEvent e) -> {
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, (String) e.getItem());
        });

        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;c.gridy=0;c.insets = Utils.pad10;
        comboBoxPane.add(labelSelectMode, c);
        c.gridx=1;c.gridy=0;c.insets = Utils.pad10;
        comboBoxPane.add(comboSelect, c);

        //Create the "cards".
        JPanel cardCadastrar = new FrameCadastrar();
        JPanel cardTraduzir = new FrameTraduzir();

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(cardCadastrar, ACTION1TEXT);
        cards.add(cardTraduzir, ACTION2TEXT);

        this.add(comboBoxPane, Utils.createGridBagConstraints(0, 0, Utils.pad10, null));
        this.add(cards, Utils.createGridBagConstraints(0, 1, Utils.pad10, null));
        
    }
    /**
     * Muda o card pelo parametro passado.
     * @param type Tipo do card
     */
    public void changeLayoutEvent(String type){
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, type);
        comboSelect.setSelectedItem(type);
    }

    /**
     * Alterna entre os cards.
     */
    public void toggleLayoutEvent() {
        String selected = comboSelect.getSelectedItem().toString();
        if (selected.equals(ACTION1TEXT)) {
            changeLayoutEvent(ACTION2TEXT);
        } else {
            changeLayoutEvent(ACTION1TEXT);
        }
    }
}
