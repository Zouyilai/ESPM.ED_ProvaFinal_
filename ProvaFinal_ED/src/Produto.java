
public class Produto {
    
	private int codigo; 
	private String nome;
	private double valor;
	private int estoque;

    public Produto(int codigo) {
        this.codigo = codigo;
    }
	
	public Produto(int codigo, String nome, double valor, int estoque) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.estoque = estoque;
	}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }


    @Override
	public boolean equals(Object obj) {
		Produto aux = (Produto) obj; 
		
		if(aux.codigo == codigo) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String dados = "";
		dados += "Código  -> " + this.codigo + "\n";
		dados += "Nome -> " + this.nome + "\n";
		dados += "Valor ->  R$" + this.valor + "\n";
		dados += "Estoque ->  " + this.estoque + "\n";
		dados += "-----------" + "\n";
		return dados;
	}

}
