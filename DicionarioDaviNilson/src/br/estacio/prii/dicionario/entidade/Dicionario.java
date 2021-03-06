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

import br.estacio.prii.dicionario.eventos.OnChangeListener;
import br.estacio.prii.dicionario.persistencia.DAO;
import java.util.ArrayList;

/**
 * Classe Dicionario é um objeto abstrato que armazena em memoria todas as traducoes do 
 * dicionario, provê acesso ao dicionario a interface grafica e aciona a classe DAO
 * para executar processos em disco.
 */
public class Dicionario implements Runnable {

    // Objeto único que guarda todas as traduções do app
    private final ArrayList<Traducao> Traducoes = new ArrayList<>();

    // Objecto único que faz as chamadas ao DAO
    private final DAO mainDAO = new DAO();

    private OnChangeListener ocl;

    public enum linguagemType {
        INGLES, PORTUGUES;
    }

    public Dicionario() {
    }

    /**
     * Retorna um ArrayList com todas as entradas do dicionario
     *
     * @return ArrayList
     */
    public ArrayList<Traducao> getDicionario() {
        return Traducoes;
    }

    /**
     * Adiciona uma traducao ao dicionario
     *
     * @param t
     * @throws java.lang.Exception
     */
    public void addTraducaoToDicionario(Traducao t) throws Exception {
        try {
            Traducoes.add(t);
            this.run();
            GravarDados();
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    /**
     * Limpa todas as traducoes do dicionario.
     */
    private void limparDicionario() {
        Traducoes.clear();
    }

    /**
     * Retornas as traducoes do dicionario em formato ArrayList de Strings
     *
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
     * Grava o dicionario em disco usando a classe DAO
     *
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
     *
     * @throws Exception
     */
    public void CarregarDados() throws Exception {
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

    /**
     * Traduz uma palavra
     * @param text Texto a ser traduzido
     * @param linguagemType 
     * @return Palavra traduzida
     * @throws TraducaoException 
     */
    public String traduzirPalavra(String text, linguagemType linguagemType) throws TraducaoException {
        for (Traducao p : Traducoes) {
            if (linguagemType == linguagemType.INGLES){
                if (p.getPalavraInglesString().equals(text.toUpperCase())){
                    return p.getPalavraPortuguesString();
                }
            } 
            if (linguagemType == linguagemType.PORTUGUES){
                if (p.getPalavraPortuguesString().equals(text.toUpperCase())){
                    return p.getPalavraInglesString();
                }
            } 
        }
        throw new TraducaoException("Palavra não encontrada.");
    }

    @Override
    public void run() {
        ocl.OnChange();
    }

    public void addOnChangeListener(OnChangeListener ocl) {
        this.ocl = ocl;
    }

}
