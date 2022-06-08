
public class ArvoreBinaria {
    
	private No raiz; 
    String dados;
	
	//método para inserir um elemento na árvore binária de busca
	public void inserir(Produto produto) {
		if(raiz == null) {
			raiz = new No(produto);
		} else {
			raiz.inserirNo(produto);
		}
	}

    public No pesquisar(int id) {
        No aux = pesquisarProduto(id, this.raiz);
        return aux;
    }

    private No pesquisarProduto(int id, No raiz){
        if(raiz == null){
            return null;
        }
        if(id == raiz.produto.getCodigo()){
            return raiz;
        }
        
        if(id > raiz.produto.getCodigo()){
            return pesquisarProduto(id, raiz.dir);   
        } else {    
            return pesquisarProduto(id, raiz.esq);
        }
    }


    public void listarEmOrdem() {
        this.dados = "";
		listarEmOrdemRecursivo(raiz);
	}

	//método auxiliar para o percurso em-ordem
	private void listarEmOrdemRecursivo(No raiz) {
		if(raiz == null) {
			return;
		}
		
		listarEmOrdemRecursivo(raiz.esq);
        this.dados = this.dados + raiz.produto;
		listarEmOrdemRecursivo(raiz.dir);
	}

    private No maiorValorEsq(No raiz) {
        while (raiz.dir != null) {
            raiz = raiz.dir;
        }
    
        return raiz;
    }

    public void remover(int id) { 
       removerProduto(id, this.raiz);
    }

    private No removerProduto(int id, No raiz) {
        //valor não encontrado
        if (raiz == null) {
            return raiz;
        }

        //encontrar o valor na arvore para realizar a remoção
        if (id < raiz.produto.getCodigo()) {
            raiz.esq = removerProduto(id, raiz.esq);
        } else if (id > raiz.produto.getCodigo()) {
            raiz.dir = removerProduto(id, raiz.dir);
        
        } else { //1. elemento = nó folha (sem filho)
            if (raiz.esq == null && raiz.dir == null) {
                //elemento = raiz
                if(raiz.produto.getCodigo() == this.raiz.produto.getCodigo()){
                    this.raiz = null;
                }
                raiz = null;
                return null;
            } else if (raiz.esq == null || raiz.dir == null) { // 2. elemento possui um filho
                No filho = (raiz.esq != null) ? raiz.esq : raiz.dir;
                
                if(raiz.pai != null) { 
                    filho.pai = raiz.pai;
                } else {
                    filho.pai = null;
                }

                //elemento = raiz
                if(raiz.produto.getCodigo() == this.raiz.produto.getCodigo()){
                    this.raiz = filho;
                }
                
                raiz = null;
                raiz = filho;

            } else { // 3. elemento possui dois filhos
                // encontrar a maior folha da esq
                No maiorValorEsq = maiorValorEsq(raiz.esq);
                
                //dependendo da posicao do maiorValor, limpa esq/dir posicao do seu pai
                //tb liga o filho perdido com o pai do maiorValor 
                if(maiorValorEsq.pai.dir == maiorValorEsq) {
                    maiorValorEsq.pai.dir = null;
                    if(maiorValorEsq.esq != null) {
                        maiorValorEsq.pai.dir = maiorValorEsq.esq;
                        maiorValorEsq.esq.pai = maiorValorEsq.pai;
                    }
                    maiorValorEsq.esq = raiz.esq;
                    maiorValorEsq.dir = raiz.dir;
                } else if (raiz.esq == maiorValorEsq) {
                    maiorValorEsq.pai.esq = null;
                    maiorValorEsq.dir = raiz.dir;
                    if(maiorValorEsq.esq != null) {
                        maiorValorEsq.pai.dir = maiorValorEsq.esq;
                        maiorValorEsq.esq.pai = maiorValorEsq.pai;
                    }
                }
                
                if (raiz.pai != null) {
                    if(raiz == raiz.pai.esq) {
                        raiz.pai.esq = maiorValorEsq;
                    } else {
                        raiz.pai.dir = maiorValorEsq;
                    }
                    maiorValorEsq.pai = raiz.pai;
                } else {
                    maiorValorEsq.pai = null;
                }

                if (raiz.dir != null) {
                    raiz.dir.pai = maiorValorEsq;
                }
                
                if (raiz.esq != null) {
                    raiz.esq.pai = maiorValorEsq;
                }
                
                //elemento = raiz
                if(raiz.produto.getCodigo() == this.raiz.produto.getCodigo()){
                    this.raiz = maiorValorEsq;
                }

                raiz = null;
                raiz = maiorValorEsq;
            
            }
        }
        return raiz;
    }

    public int calcularH() {
        int altura = calcularAltura(raiz);
        return altura;
    }

    private int calcularAltura(No raiz) {
        if(raiz == null) {
			return -1; //valor inicial(árvore vazia)
		} else {
            int alturaEsq, alturaDir;

            alturaEsq = calcularAltura(raiz.esq);
            alturaDir = calcularAltura(raiz.dir);

            if(alturaEsq > alturaDir) {
                return alturaEsq + 1;
            } else {
                return alturaDir + 1;
            }
        }
    }
}
