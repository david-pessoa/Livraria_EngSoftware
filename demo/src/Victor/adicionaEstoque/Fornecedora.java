import java.util.LinkedList;

public class Fornecedora {
    protected String nome;
    private String CNPJ;
    private String email;
    private String senha;
    private LinkedList<Produtos> produtos;
    private String dados_bancarios;

    public Fornecedora() {
        this("", "", "", "", new LinkedList<Produtos>(), "");
    }

    public Fornecedora(String nome, String CNPJ, String email, String senha, LinkedList<Produtos> produtos,
            String dados_bancarios) {
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.email = email;
        this.senha = senha;
        this.produtos = produtos;
        this.dados_bancarios = dados_bancarios;
    }

    public String getNome() {
        return nome;
    }

    public String listaEstoque() {
        StringBuilder retorno = new StringBuilder();
        for (Produtos produto : produtos) {
            retorno.append("nome: ").append(produto.getLivro().getNome())
                    .append("\nquantidade: ").append(produto.getQuanti())
                    .append("\nem falta?: ").append(produto.falta() ? "SIM" : "NÃO").append("\n\n");
        }
        return retorno.toString();
    }

    public boolean addNoEstoque(String nome, int quant, String data_envio, String data_recebimento) {
        for (Produtos produto : produtos) {
            if (produto.getLivro().getNome().equals(nome)) {
                produto.setQuanti(produto.getQuanti() + quant);
                // talvez uma comunicação aqui com a instituição financeira
                return true;
            }
        }
        return false;
    }

    public boolean addNoEstoque(int id, String nome, float preco, String autor, String categoria, int quant,
            String data_envio, String data_recebimento) {
        Produtos novoProduto = new Produtos(new Livro(id, nome, preco, autor, categoria), quant);
        produtos.add(novoProduto);
        // talvez uma comunicação aqui com a instituição financeira
        return true;
    }

    public String getCPF() {
        return CNPJ;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getDados_bancarios() {
        return dados_bancarios;
    }

    protected boolean ValidaAcesso(String senha_recebida) {
        return this.senha.equals(senha_recebida);
    }
}
