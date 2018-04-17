/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prii.dicionario.main;

import br.estacio.prii.dicionario.frame.FrameDicionario;


/**
 *
 * @author Nilson Morais / Davi Morais
 */
public class DicionarioInglesPortugues {
    
    public DicionarioInglesPortugues() {
        final FrameDicionario fd;
        fd = new FrameDicionario();
        fd.setVisible(true);
    }
    public static void main(String[] args) {
        DicionarioInglesPortugues dic = new DicionarioInglesPortugues();
    }
    
   
}
