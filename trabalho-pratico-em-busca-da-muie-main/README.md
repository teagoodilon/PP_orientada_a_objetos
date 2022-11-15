[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=8168190&assignment_repo_type=AssignmentRepo)
## Trabalho de PPOO - Em busca da Muié

Em busca da Muié é um jogo feito para ser apresentado como trabalho final da matéria Práticas de Programação Orientada a Objetos (GAC 106-2022/1).

O jogo consiste em aspirar a Muié que assombra a casa da Rep Cudi.

Para conseguir vencer no jogo você deve usar o Aspirador na Muié que está no Quarto do patinete, mas para isso primeiro você deve encontrar a Toalha no quarto do Diogo. ir ao quarto do Pedro e entrar no banheiro (que só pode ser acessado com o item Toalha), com isso você encontra o item Chave, que é a chave do quarto do Patinete (que é onde a muié está), porém, abrindo o quarto sem o item Aspirador na mochila você perde, para vence-la você deve também pegar o item Aspirador que se encontra na garagem, porém, para conseguir ter força para atacar com o aspirador você deve primeiro comer algum alimento, no mapa temos bolo e macarrao. Assim, abrindo o quarto do patinete você pode usar o aspirador, aspirar a Muié e vencer o jogo.

À princípio teremos 4 personagens no jogo, um personagem na garagem que irá indicar que será preciso comer algo para conseguir atacar com o aspirador, teremos outro personagem indicando que será preciso da toalha para abrir o banheiro e conseguir a chave, um personagem no sotão indicando o morador está longe do seu objetivo e também um personagem que acorda assim que o jogo é finalizado indicando o tempo que foi concluida a missão.

Mapa do jogo: https://lucid.app/lucidchart/1ccc6d05-dedf-49e1-85b5-8444d748ada8/edit?invitationId=inv_3911be20-866c-462f-bc22-9a9e8a9339f3#

Primeira Etapa:

1. Devem existir, no mínimo, dez ambientes.
    - quintal, quartoCaputo, sotao, cozinha, sala, quartoDioguinho,
    salaTrofeu, quartoThiago, quartoHenrique, quartoPatinete, quartoPedro,
    banheiro, garagem;

2. A navegação entre ambientes deve tratar, no mínimo, sete direções (ou formas de movimentação) diferentes.
    - norte, sul, leste, oeste, cima, baixo, portal

3. O jogo deve possuir itens (ou artefatos, ou similares).
    - bolo, faca, macarrao, toalha, chave, aspirador, faca

4. O jogador deve conseguir carregar itens (ou similares), ou seja, pegar um item e levar consigo.
Devem existir itens que o jogador não consegue carregar.  O jogo deve limitar o total de itens que o jogador consegue carregar (seja por peso, ou por
quantidade mesmo).
    - Feito.

5. O jogador deve conseguir usar itens (ou similares), ou seja, poder realizar alguma ação com um item que ele
esteja carregando.
    - bolo: te salva de um ataque da muie se beber antes
    - faca: atacar a muie
    - toalha: permite usar o banheiro
    - chave: permite entrar no quarto
    - aspirador: atacar a muie

6. O jogador deve conseguir largar itens (ou similares), ou seja, deixar em um ambiente um item que até então
ele estava carregando (note que, com isso, um ambiente pode ter mais de um item).
    - Feito
Quando o jogador solta o item, ele fica no ambiente que em ele está e não no ambiente original do item, o jogador pode voltar no ambiente e recuperar o item "largado"
    - Feito

Nosso exemplo de polimorfismo está na superclasse Item e suas subclasses: Comida, Utilitario, Arma. Quando um item é criado seu tipo estático é Item e o dinâmico é alterado para que satisfaça a lógica do jogo.

Sobre a questão de salvamento/carregamento de dados em arquivo, iremos implementar um placar em arquivo de texto com o menor tempo que concluiu a missão principal em menor tempo.

## Informações sobre a Entrega Final

Prencha abaixo os **nomes completos** dos integrantes do grupo que realmente fizeram o trabalho:

- Otávio Augusto Trindade Fonseca
- Pedro Igor Ferreira Martins
- Thiago Odilon de Almeida
- Tulio Oliveira Cruz

### Tabela de Requisitos

**Preencha a coluna _Respostas_** na tabela abaixo.
A coluna _Id_ indica a seção das Instruções do trabalho.


|  Id |  Descrição                                              | Respostas | 
|-----|---------------------------------------------------------|--------------|
| 3.1 | Número de ambientes                                     | (13) |
| 3.2 | Número de direções                                      | (7) |
| 3.3 | Trata itens e há itens que jogador não consegue pegar?  | (sim) |
| 3.4 | Tem máximo de itens que jogador não consegue carregar?  | (sim) |
| 3.5 | Jogador consegue usar itens?                            | (sim) |
| 3.6 | Jogador consegue largar itens?                          | (sim) |
| 3.7 | Jogo tem personagens (além do jogador)?                 | (sim) |
| 3.8 | As duas funcionalidades adicionais implementadas foram: | (Existe um inimigo no ambiente e uma arma para derrotá-lo, saídas que estão bloqueadas e precisam de itens para serem liberadas) |
| 3.9 | As duas palavras de comando adicionais são:             | (atacar, comer) |
| 3.10| Os três passos (resumidos) de missão são:               | (desbloquear passagens, comer alimento para conseguir usar a arma e atacar o inimigo para vencer o jogo) |
| 3.11| Jogo funciona no terminal e na interface gráfica        | (sim) |
| 4.1 | Atende passos obrigatórios do Exercício World of Zuul   | (sim) |
| 4.5 | Só há interação com usuário nas classes Terminal e Tela | (sim) |
| 4.7 | Código usa polimorfismo de método                       | (sim) |
| 4.8 | A alteração de funcionalidade na interface gráfica foi: | (Não fizemos esse) |
| 4.9 | Jogo usa arquivos para:                                 | (Mostrar o menor tempo que o jogador concluiu o jogo) |
| 4.10| Código possui tratamento de exceção                     | (não, mas houve tratamento para que o jogo não feche sem aviso por erro de execução) |
| 4.11| Padrão de projeto implementado:                         | (Singleton) |
| 4.12| Diagrama de classes UML atualizado está na pasta doc?   | (sim) |


