public class Clientes {
  private Cliente[] clientes;
  private int num_clientes;

  public Clientes(Cliente[] clientes) {
    this.clientes = clientes;
    this.num_clientes = clientes.length;
  }

  public Clientes() {
    this(null);
  }

  // pode melhorar como dito no controller
  public Cliente acessaCliente(String nome) {
    for (int i = 0; i < num_clientes; i++) {
      if (clientes[i].getNome().equals(nome)) {
        return clientes[i];
      }
    }
    return null;
  }

  public String buscaCliente(String username) {
    for (int i = 0; i < num_clientes; i++) {
      if (clientes[i].nome == username) {
        return clientes[i].nome;
      }
    }
    return "";
  }

  public boolean ValidaAcesso(String username, String senha) {
    for (int i = 0; i < num_clientes; i++) {
      if (clientes[i].nome == username) {
        return clientes[i].ValidaAcesso(senha);
      }
    }
    return false;
  }

}