import java.util.LinkedList;

public class Cliente {
    protected String nome;
    private String CPF;
    private String email;
    private String senha;
    private LinkedList<ItemCarrinho> carrinho; // Alterado para usar ItemCarrinho
    private LinkedList<Compra> pedidos;

  // isso pode tirar
    public Cliente() {
        this("", "", "", "", new LinkedList<ItemCarrinho>(), new LinkedList<Compra>());
    }

  // isso pode tirar
    public Cliente(String nome, String CPF, String email, String senha, LinkedList<ItemCarrinho> carrinho, LinkedList<Compra> pedidos) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.senha = senha;
        this.carrinho = carrinho;
        this.pedidos = pedidos;
    }

  // feito pelo Victor
    public boolean adicionarNoCarrinho(Livro livro, int quant) {
        if (quant <= 0) {
            return false;
        }
        carrinho.add(new ItemCarrinho(livro, quant));
        return true;
    }

  // feito pelo Victor
    public boolean removerDoCarrinho(Livro livro) {
        if (livro == null) {
            return false;
        }
        for (ItemCarrinho item : carrinho) {
            if (item.getLivro().equals(livro)) {
                carrinho.remove(item);
                return true;
            }
        }
        return false;
    }

  // caso precise (pra mim tira)
    public boolean editarCarrinho(Livro livro, int quant) {
        if (livro == null || quant <= 0) {
            return false;
        }
        for (ItemCarrinho item : carrinho) {
            if (item.getLivro().equals(livro)) {
                item.setQuantidade(quant);
                return true;
            }
        }
        return false;
    }

  // feito pelo victor que comprar tudo do carrinho
    public void compraCarrinho() {
        for (ItemCarrinho item : carrinho) {
            Compra compra = new Compra(item.getLivro(), item.getQuantidade());
            pedidos.addFirst(compra);
        }
        carrinho.clear();
    }

    public void realizaCompra(Livro livro, int qtde) {
        Compra compra = new Compra(livro, qtde);
        pedidos.addFirst(compra);
    }

  // isso pode tirar era para o terminal
    public String[] getCarrinho() {
        String[] resposta = new String[carrinho.size()];
        int i = 0;
        for (ItemCarrinho item : carrinho) {
            resposta[i] = "nome: " + item.getLivro().getNome() + " | quant: " + item.getQuantidade();
            i++;
        }
        return resposta;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

  // preciso disso no teste
    public LinkedList<Compra> getPedidos() {
        return pedidos;
    }

  // preciso disso no teste
    public LinkedList<ItemCarrinho> getListaCarrinho() {
        return carrinho;
    }

    protected boolean ValidaAcesso(String senha) {
        return this.senha.equals(senha);
    }
}
