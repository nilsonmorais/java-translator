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

/**
 * Classe traducao armazena um objeto com dois objetos Palavra.
 *
 */
public class Traducao {

    private Palavra palavraPortugues;
    private Palavra palavraIngles;
    private final String stringSeparator = ";";

    public Traducao() {
    }

    public void setPalavraIngles(String palavraIngles) throws Exception {
        try {
            Palavra p = new Palavra(palavraIngles, Dicionario.linguagemType.INGLES);
            this.palavraIngles = p;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void setPalavraPortugues(String palavraPortugues) throws Exception {
        try {
            Palavra p = new Palavra(palavraPortugues, Dicionario.linguagemType.PORTUGUES);
            this.palavraPortugues = p;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
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

    /**
     * Classe Palavra contem uma String e um linguagemType que especifica a lingua
     * da palavra.
     */
    private class Palavra {

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
        public String toString() {
            return palavra;
        }
    }

}
