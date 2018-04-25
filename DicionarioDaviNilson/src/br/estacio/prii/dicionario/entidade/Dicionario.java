/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prii.dicionario.entidade;

import br.estacio.prii.dicionario.persistencia.DAO;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Dicionario {

    private ArrayList<Traducao> TodasPalavras = new ArrayList<>();

    public void parseTraducao(String input) throws Exception {
        String[] dados;
        Traducao t = new Traducao();
        dados = input.split(t.getStringSeparator());
        t.setPalavraIngles(dados[0]);
        t.setPalavraPortugues(dados[1]);
    }

    public ArrayList<Traducao> getDicionario() {
        return TodasPalavras;
    }

    public void addTraducao(Traducao t) {
        TodasPalavras.add(t);
    }

    public static class Traducao {

        private Palavra palavraPortugues;
        private Palavra palavraIngles;
        private final String stringSeparator = ";";

        private Traducao(String palavra, linguagemType lingua) throws Exception {
            if (lingua.equals(linguagemType.INGLES)) {
                setPalavraIngles(palavra);
                setPalavraPortugues(TraduzirPalavra(getPalavraIngles(), linguagemType.PORTUGUES));
            } else {
                setPalavraPortugues(palavra);
                setPalavraIngles(TraduzirPalavra(getPalavraPortugues(), linguagemType.INGLES));
            }
        }

        public Traducao() {
        }
        public void setPalavraIngles(String palavraIngles) throws Exception {
            try {
                Palavra p = new Palavra(palavraIngles, linguagemType.INGLES);
                this.palavraIngles = p;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void setPalavraPortugues(String palavraPortugues) {
            try {
                Palavra p = new Palavra(palavraPortugues, linguagemType.PORTUGUES);
                this.palavraPortugues = p;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        private String TraduzirPalavra(Palavra palavra, linguagemType linguagemType) {
            return "";
        }

        public Palavra getPalavraIngles() {
            return palavraIngles;
        }

        public Palavra getPalavraPortugues() {
            return palavraPortugues;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getPalavraIngles().toString());
            sb.append(this.stringSeparator);
            sb.append(this.getPalavraPortugues().toString());
            return sb.toString();
        }

        public String getStringSeparator() {
            return stringSeparator;
        }

    }

    public enum linguagemType {
        INGLES, PORTUGUES;
    }

    public Dicionario() {

    }

    public void CriarTraducao(Palavra nova, linguagemType lingua) {

    }

    public ArrayList dicToString() {
        ArrayList<String> result = new ArrayList<>();

        for (Traducao p : TodasPalavras) {
            result.add(p.toString());
        }
        return result;
    }

    public void GravarDados() {
        DAO d = new DAO();
        d.gravarDados(this.dicToString());
    }

}
