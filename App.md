# Projeto:
* Dicionário Inglês-Português *

# Estrutura do Projeto:

Nome do Projeto: DicionarioAluno1Aluno2Aluno3

```
br.estacio.prii.dicionario.entidade
    * Palavra.java
        - palavraIngles: String    
        - palavraPortugues: String
    * Dicionario.java
        - palavras: ArrayList<Palavra>
        - arquivo: String

br.estacio.prii.dicionario.frame
    * FrameDicionario.java

br.estacio.prii.dicionario.main
    * DicionarioInglesPortugues.java

br.estacio.prii.dicionario.persistencia
    ...
```

### Barra de Menu:

- Arquivo
    - Sobre...
    - Sair

- Dicionário
    - Salvar
    - Carregar

- Operação
    - Cadastrar
    - Traduzir




### Conteúdo do Frame:

(JComboBox) Operação: Cadastrar/Traduzir
(JTextField) Palavra: [ ], Tradução: [ ]
(JRadioButton) Inglês, Português
(JButton) Cadastrar, Traduzir, Excluir, Sair
(JList) Palavras com Tradução
