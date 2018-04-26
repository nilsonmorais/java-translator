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

package br.estacio.prii.dicionario.entidade;

import br.estacio.prii.dicionario.persistencia.DAO;
import java.util.ArrayList;

/**
 *
 */
public class Dicionario {

    // Objeto único que guarda todas as traduções do app
    private final ArrayList<Traducao> Traducoes = new ArrayList<>();
    
    // Objecto único que faz as chamadas ao DAO
    private final DAO mainDAO = new DAO();

    public enum linguagemType {
        INGLES, PORTUGUES;
    }
    
    public Dicionario() {
    }

    /**
     * Cria uma entrada de tradução no dicionario tendo como entrada uma string 
     * 
     * @param input 
     * @throws Exception 
     */
    public void parseTraducao(String input) throws Exception {
        String[] dados;
        Traducao t = new Traducao();
        dados = input.split(t.getStringSeparator());
        t.setPalavraIngles(dados[0]);
        t.setPalavraPortugues(dados[1]);
    }

    /**
     * Retorna um ArrayList com todas as entradas do dicionario
     * @return ArrayList
     */
    public ArrayList<Traducao> getDicionario() {
        return Traducoes;
    }

    /**
     * Adiciona uma traducao ao dicionario
     * @param t 
     */
    public void addTraducaoToDicionario(Traducao t) {
        Traducoes.add(t);
    }

    /**
     * Limpa todas as traducoes do dicionario.
     */
    private void limparDicionario() {
        Traducoes.clear();
    }

    /**
     * Retornas as traducoes do dicionario em formato ArrayList de Strings
     * @return ArrayList
     */
    public ArrayList getDicionarioString() {
        ArrayList<String> result = new ArrayList<>();

        for (Traducao p : Traducoes) {
            result.add(p.toString());
        }
        return result;
    }

    /**
     * Grava o dicionario 
     * @throws Exception 
     */
    public void GravarDados() throws Exception {
        try {
            mainDAO.gravarDados(this.getDicionarioString());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Carrega traducoes no dicionario pelo arquivo do disco
     * @throws Exception 
     */
    public void LerDados() throws Exception {
        try {
            limparDicionario();
            ArrayList<String> result = mainDAO.lerDados();
            for (int i = 0; i < result.size(); i++) {
                Traducao t = new Traducao();
                String[] input = result.get(i).split(t.getStringSeparator());
                t.setPalavraIngles(input[0]);
                t.setPalavraPortugues(input[1]);
                addTraducaoToDicionario(t);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
