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

package br.estacio.prii.dicionario.persistencia;

import java.io.*;
import java.util.ArrayList;

/**
 * Classe DAO para acesso ao filesystem. Comunicação feita só via ArrayLyst
 */
public class DAO {

    private final String filePath = "banco.txt";

    public DAO() {
    }

    /**
     * Recebe uma ArrayList com uma lista de Strings para gravar no arquivo
     * @param dic ArrayList 
     * @throws java.io.IOException 
     * @throws Exception 
     */
    public void gravarDados(ArrayList dic) throws IOException, Exception {
        try {
            BufferedWriter arq = new BufferedWriter(
                    new FileWriter(new File(filePath))
            );

            for (int i = 0; i < dic.size(); i++) {
                arq.write((String) dic.get(i));
                arq.newLine();
            }
            arq.close();

        } catch (IOException e) {
            //TODO: Melhorar as exceptions.
            throw new Exception(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Lê o arquivo em disco e retorna em formato ArrayList
     * @return ArrayList
     * @throws Exception 
     * @throws java.io.IOException 
     */
    public ArrayList lerDados() throws Exception, IOException {
        try {
            BufferedReader arq = new BufferedReader(
                    new FileReader(new File(filePath))
            );

            ArrayList<String> dados = new ArrayList<>();
            String str;

            str = arq.readLine();
            while (str != null) {
                dados.add(str);
                str = arq.readLine();
            }
            arq.close();
            return dados;
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
