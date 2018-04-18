/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prii.dicionario.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author aluno
 */
class MenuItemListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        System.out.print(e.getActionCommand() + " MenuItem clicked.");
    }
}
