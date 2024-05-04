# `App.java`
Essa classe cumprirá o papel do boundary. Nela, haverá o menu de inicialização

# `Catalogo.java`
Essa classe representará o catálogo da livraria. 
## Atributos
 * `int num_total_livros` --> número total de livros no catálogo
 * `int quant_de_categorias` --> quantidade de categorias presentes no catálogo
 * `String[] categorias` --> lista contendo todas as categorias
 * `Livro[] livros` --> lista contendo todos os livros do catálogo

## Métodos
<!--Por favor, deêm nomes melhores a esses métodos! O que cada um deles faz? O nome deve tentar refletir/explicar isso-->
 * `buscaLivro(String)` --> ... retorna um objeto tipo Livro[]
 * `buscaLivron(String)` --> ... retorna um objeto tipo Livro[]
 * `buscaLivroa(String)` --> ... retorna um objeto tipo Livro[]

# `Cliente.java`
Essa classe representará os clientes da livraria. 
## Atributos
 * `String nome` --> nome do cliente
 * `String CPF` --> CPF do cliente
 * `String email` --> email do cliente
 * `String senha` --> senha de login do cliente
 * `Livro[] carrinho` --> carrinho que contém os livros do cliente
 * `boolean valida_login` --> confere se o login está válido
 
## Métodos
 * getters --> retornam o valor do atributo do objeto
 * setters --> alteram o valor do atributo do objeto com base no parâmetro passado
 * `ValidaAcesso(String)` --> Valida o acesso a conta do cliente durante o login por meio da senha passada como parâmetro

# `Compra.java`
Essa classe representará uma compra realizada por um cliente
## Atributos
 * `int id_compra` --> número de identificação ID da compra
 * `float valor_compra` --> valor total da compra
 * `String data_compra` --> data em que a compra foi efetuada
 
## Métodos
 * `calculaTotalCompra` --> calcula o total da compra, retorna um float (melhorar essa função)

# `Controller.java`
Essa classe é a intermediária entre `App.java` (Boundary) e as outras classes
## Atributos
 
## Métodos

# `Livro.java`
Essa classe representa todos os livros que estão na livraria
## Atributos
* `int id` --> número de identificação ID do livro
* `String nome` --> nome do livro
* `float preco` --> preço de uma unidade do livro
* `String autor` --> autor do livro
* `String categoria` --> categoria a qual o livro pertence
 
## Métodos
* Getters --> retornam o valor do atributo do objeto


 
