
import javax.swing.JOptionPane;

public class Util { 
    
    static ArvoreBinaria arvore = new ArvoreBinaria();

    public static void cadastrarProduto() {
        
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto: "));

        if(arvore.pesquisar(codigo) == null){
            String nome = JOptionPane.showInputDialog("Informe o nome do produto: ");
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do produto: "));
            if (valor > 0){
                int estoque = Integer.parseInt(JOptionPane.showInputDialog("Informe o estoque do produto: "));
                if(estoque > 0){
                    Produto produto = new Produto(codigo, nome, valor, estoque);
                    arvore.inserir(produto);
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso :)");
                } else {
                    JOptionPane.showMessageDialog(null, "A quantidade de estoque deve ser maior que zero!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "O valor deve ser maior que zero!");
            }   
        } else {
            JOptionPane.showMessageDialog(null, "Produto(código) existente!");
        }
    }

    public static void pesquisarProduto() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto: "));

        if(arvore.pesquisar(codigo) == null){
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
        } else {
            JOptionPane.showMessageDialog(null, "---------Produto---------\n"+arvore.pesquisar(codigo).produto);
        }
    }

    public static void listarProduto() {
        arvore.listarEmOrdem();
        JOptionPane.showMessageDialog(null, "---------Produtos---------\n"+arvore.dados);
    }

    public static void removerProduto() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto: "));

        if(arvore.pesquisar(codigo) == null){
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
        } else {
            arvore.remover(codigo);
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
        }

    }

    public static void informarAltura() {
        int altura = arvore.calcularH();
        JOptionPane.showMessageDialog(null, "Aplicação Finalizada!\nAltura da árvore = "+altura+"\n(-1 indica que a árvore está vazia)");
    } 
}
