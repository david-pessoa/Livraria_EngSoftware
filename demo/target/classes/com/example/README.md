# `App.java`
Essa classe cumprirá o papel do boundary. Nela, haverá o menu de inicialização

# `Catalogo.java`
Essa classe representará o catálogo da livraria. 
## Atributos
 * `LinkedList<Livro> livros_do_catalogo` --> lista encadeada contendo todos os livros do catálogo

## Métodos
 * `Constutor(LinkedList<Livro>)` --> recebe uma lista encadeada, representando todos os livros do catálogo.
 * `buscaLivroNome(String)` --> recebe uma string com o nome de um livro e retorna o tipo `Livro` caso haja um livro com o nome informado, ou `null`caso contrário.
 * `buscaLivroAutor(String)` --> recebe uma string com o nome do autor de um livro e retorna o tipo `Livro` caso haja um livro com do autor informado, ou `null`caso contrário.

# `Cliente.java`
Essa classe representará os clientes da livraria. 
## Atributos
 * `String nome` --> nome do cliente
 * `String CPF` --> CPF do cliente
 * `String email` --> email do cliente
 * `String senha` --> senha de login do cliente
 * `LinkedList<ItemCarrinho> carrinho` --> carrinho que contém os livros do cliente
 * `LinkedList<Compra> pedidos` --> confere se o login está válido
 
## Métodos
 * `Construtor(String, String, String, String)` --> recebe como parâmetro: o nome, CPF, email e senha do cliente respectivamente
 * getters --> retornam o valor do atributo do objeto
 * setters --> alteram o valor do atributo do objeto com base no parâmetro passado
 * `realizaCompra(Livro, int)` --> adiciona um livro e a sua quantidade à lista de `pedidos` do cliente
 * `addNoCarrinho(Livro livro, int qtde)` --> adiciona um livro e a sua quantidade ao `carrinho` do cliente
 * `ValidaAcesso(String String)` --> recebe como parâmetro o nome e senha do cliente e verifica se estão corretos. Se sim, retorna `true`, caso contrário, retorna `false`.
 * `showCarrinho()` --> exibe os itens no `carrinho` do cliente. (adicionar valor total do carrinho a função)
 * `showCompras()` --> exibe a lista de `pedidos` do cliente. (adicionar valor total da compra a função)

# `Compra.java`
Essa classe representará uma compra realizada por um cliente
## Atributos
 * `int id_compra` --> número de identificação ID da compra
 * `float valor_compra` --> valor total da compra
 * `String data_compra` --> data em que a compra foi efetuada
 * `Livro item` --> item da compra
 * `int quantidade` --> quantidade do livro que foi pedida
 
## Métodos
 * `Construtor(Livro, int)` --> recebe o `Livro` e a quantidade como parâmetros.
 * getters --> retornam o valor do atributo do objeto
 * `geraID()` --> gera um ID aleatório do tipo `int` para a compra
 * `calculaTotalCompra` --> calcula o total do item do pedido (melhorar função)

# `ItemCarrinho.java`
Essa é uma classe auxiliar, para representar os itens que estão no carrinho (cada livro e sua respectiva quantidade)
## Atributos
 * `Livro item` --> livro do carrinho
 * `int quantidade`--> quantidade do livro

## Métodos
 * getters --> retornam o valor do atributo do objeto
 * setters --> alteram o valor do atributo do objeto com base no parâmetro passado
 * `calculaTotalItem()` --> calcula o preço total do item multiplicando o preço do item por sua quantidade no carrinho. A função retorna este resultado no tipo `float`

# `Controller.java`
Essa classe é a intermediária entre `App.java` (Boundary) e as outras classes
## Atributos
 
## Métodos
 * `setUpCatalogo()` --> Extrai as informações dos livros contidas no arquivo binário livros.bin e retorna uma lista encadeada do tipo `LinkedList<Livro>`. Caso o arquivo não consiga ser aberto, será exibida uma mensagem de erro e será retornado `null`.

# `Livro.java`
Essa classe representa todos os livros que estão na livraria
## Atributos
* `int id` --> número de identificação ID do livro
* `String nome` --> nome do livro
* `float preco` --> preço de uma unidade do livro
* `String autor` --> autor do livro
* `String categoria` --> categoria a qual o livro pertence
* `boolean disponivel`--> se `disponivel == true`, então o livro está disponível e pode ser comprado, senão, não poderá ser comprado. (usar esse atributo para o caso de uso realiza reserva)
 
## Métodos
* Getters --> retornam o valor do atributo do objeto
* `geraID()` --> gera um ID aleatório do tipo `int` para a compra


 
