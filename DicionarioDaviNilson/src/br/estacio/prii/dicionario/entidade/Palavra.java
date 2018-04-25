/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prii.dicionario.entidade;

/**
 *
 * @author aluno
 */
public class Palavra {

    private String palavra;
    private Dicionario.linguagemType linguagem;

    public Palavra(String palavra, Dicionario.linguagemType linguagemType) throws Exception {
        if (checkPalavra(palavra)) {
            setPalavra(palavra, linguagemType);
        } else {
            throw new Exception("Palavra não pode ser vazia");
        }
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra, Dicionario.linguagemType linguagemType) throws Exception {
        if (checkPalavra(palavra)) {
            this.palavra = palavra.trim().toUpperCase();
            this.linguagem = linguagemType;
        } else {
            throw new Exception("Palavra inválida");
        }
    }

    public Boolean checkPalavra(String palavra) {
        return !(palavra.equals("") || palavra.isEmpty());
    }
    @Override
    public String toString(){
        return palavra;
    }
}
