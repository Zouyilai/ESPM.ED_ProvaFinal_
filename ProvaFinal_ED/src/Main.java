
import javax.swing.JOptionPane;

public class Main { 
    
	public static void main(String[] args) {
		boolean exit = false;

		while (!exit) {
		    String opcao = JOptionPane.showInputDialog(menu());
		    opcao = opcao.trim();
		    try {
		        switch(opcao) {
					case "1":
						Util.cadastrarProduto();
						break;
					case "2":
						Util.pesquisarProduto();
						break;
					case "3":
						Util.listarProduto();
						break;
					case "4":
						Util.removerProduto();
						break;
		        	case "5":
		        		Util.informarAltura();
						exit = true;
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opção inválida!");
		        }
		    } catch (UnsupportedOperationException e) {
		        e.printStackTrace();
		    }
		}
	}
			
	public static String menu() {
	
		String aux = "";
		aux += "Escolha uma opção:";
		aux += "\n1. Cadastrar produto";
		aux += "\n2. Pesquisar produto";
		aux += "\n3. Listar produtos";
		aux += "\n4. Remover produto";
		aux += "\n5. Encerrar aplicação";
		
		return aux;
	}
}
