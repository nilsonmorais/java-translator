/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prii.dicionario.persistencia;

import br.estacio.prii.dicionario.entidade.Dicionario;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author 97836834387
 */
public class DAO {

    private final String filePath = "banco.txt";

    public DAO() {
    }

    public void gravarDados(ArrayList dic) {
        try {
            BufferedWriter arq = new BufferedWriter(
                new FileWriter(new File(filePath))
            );
            
            for (int i = 0; i < dic.size(); i++) {
                arq.write((String) dic.get(i));
                arq.newLine();
            }
            arq.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void lerDados() {
        try {
            BufferedReader arq = new BufferedReader(
                new FileReader(new File(filePath))
            );
            
            String dados[];
            String str;
            Dicionario dic = new Dicionario();
            
            str = arq.readLine();
            while (str != null) {
                dic.parseTraducao(str);
                str = arq.readLine();
            }
            arq.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    void lerBiblioteca() throws FileNotFoundException {
//        FileInputStream arquivo = new FileInputStream(filePath);
//        ObjectInputStream input = new ObjectInputStream(arquivo);
//        bib = (Biblioteca) input.readObject();
//    }
//
//    void gravarBiblioteca() throws FileNotFoundException {
//        FileOutputStream arquivo = new FileOutputStream(filePath);
//        ObjectOutputStream output = new ObjectOutputStream(arquivo);
//        output.writeObject(bib);
//        output.flush();
//        output.close();
//    }

}
