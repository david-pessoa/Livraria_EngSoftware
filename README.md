# Participação de cada integrante do grupo:

## David Pessoa - Caso de Uso Realiza Compra

#### `App.java`
David ficou responsável pela parte de validação do acesso do usuário e pelos itens 1 e 2 do menu principal (Buscar Livro no catálogo e Visualizar todos os livros do catálogo, respectivamente)

#### `Controller.java`
David ficou responsável pelos métodos:
* Construtor
* `ValidaAcesso()`
* `showCarrinho()`
* `showCompras()`
* `addNoCarrinho()`
* `removeDoCarrinho()`
* `CompraItemDoCarrinho()`
* `CompraCarrinho()`
* `realizaCompra()`
* `MaisInfoLivro()`
* `buscaLivroNome()`
* `buscaLivroAutor()`
* `getDisponibilidadeLivro()`
* `showCatalogo()`
* `getPrecoLivro()`
* `sleep()`
* `clearScreen()`

#### `Catalogo.java`
David ficou responsável pelos métodos:
 * `getLivros_do_catalogo()`
 * `setUpCatalogo()`
 * `showCatalogo()` e seus auxiliares

#### `Cliente.java`
David ficou responsável pelos métodos:
 * `realizaCompra()`
 * `CompraItemDoCarrinho()`
 * `CompraCarrinho()`
 * `showCarrinho()`
 * `showCompras()`
 * `setUpCadastro()`

#### `Compra.java`
David ficou responsável por construir toda a classe Compra

#### `ItemCarrinho.java`
David ficou responsável por construir toda a classe ItemCarrinho

#### `Livro.java`
David ficou responsável por construir toda a classe Livro

### Classes de Testes

#### `CatalogoTest.java`
David ficou responsável por criar os testes para os métodos:
 * `setUpCatalogo()`
 * `buscaLivroNome()`
 * `buscaLivroAutor()`

#### `ClienteTest.java`
David ficou responsável por criar os testes para os métodos:
 * `setUpCadastro()`
 * `realizaCompra()`

#### `CompraTest.java`
David ficou responsável por criar os testes para o método: `calculaTotalCompra()`

#### `ControllerTest.java`
David ficou responsável por criar os testes para os métodos:
 * `ValidaAcesso()`
 * `buscaLivroNome()`
 * `buscaLivroAutor()`
 * `getDisponibilidade()`

#### `ItemCarrinhoTest.java`
David ficou responsável por criar os testes para o método: `calculaTotalItem()`

#### `LivroTest.java`
David ficou responsável por criar os testes para os métodos getters e construtor

![Frame 4](https://github.com/david-pessoa/Livraria_EngSoftware/assets/104323068/878fabc6-3fbc-4bdc-b47c-ae1e05e8acd0)


## Contribuições de Victor Vaglieri

### Classes e Métodos Implementados

#### App (boundary)
- **Manipulação do carrinho**
  - Implementação de funcionalidades relacionadas à manipulação do carrinho de compras.

#### Catalogo
- **buscaLivroNome**
  - Método para buscar um livro pelo nome.
- **buscaLivroAutor**
  - Método para buscar um livro pelo autor.
- **buscaIDlivro**
  - Método para buscar um livro pelo ID.

#### Cliente
- **addNoCarrinho**
  - Método para adicionar um item ao carrinho.
  - **Testes**: Implementação dos testes para este método.
- **removeDoCarrinho**
  - Método para remover um item do carrinho.
  - **Testes**: Implementação dos testes para este método.
- **realizaCompra**
  - Método para realizar a compra dos itens no carrinho.
  - **Testes**: Implementação dos testes para este método.

#### itemCarrinho
- Implementação completa da classe `itemCarrinho`.
