
public class No {
      
    No pai;
	Produto produto;
	No esq;
	No dir;
	
	public No(Produto produto) {
		this.produto = produto;
	}
	
	public void inserirNo (Produto p) {
		if(p.getCodigo() > produto.getCodigo()) {
			if(dir == null) {
				dir = new No(p);
                dir.pai = this;
			} else {
				dir.inserirNo(p);
			}
		} else {
			if(p.getCodigo() < produto.getCodigo()) {
				if(esq == null) {
					esq = new No(p);
                    esq.pai = this;
				} else {
					esq.inserirNo(p);
				}
			}
		}
	}

    
}
