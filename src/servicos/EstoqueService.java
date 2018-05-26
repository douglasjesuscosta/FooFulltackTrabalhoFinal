package servicos;

import java.util.ArrayList;
import java.util.List;

import modelos.Produto;
import modelos.ProdutoUnidade;

public class EstoqueService {

	private List<Produto> produtos;
	
	public EstoqueService() {
		this.produtos = new ArrayList<Produto>();
	}
	
	public void adicionarProduto(Produto produto) {
		this.produtos.add(produto);
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public boolean verificarCodigo(int codigo) {
		
		for (Produto produto : produtos) {
			if(produto.getCodigo() == codigo) 
				return true;
		}
		
		return false;
	}
	
	public Produto getProdutoByCodigoBarra(String codigoBarra) { 
		Produto produtoSelecionado = null;
		for (Produto produto : produtos) {
			if(codigoBarra.equals(produto.getCodigoBarra())) {
				produtoSelecionado = produto;
			}
		}
		
		return produtoSelecionado;
	}

	public Produto getProduto(int codProduto) {
		
		Produto produto = null;
		
		for (Produto p : produtos) {
			if(p.getCodigo() == codProduto)
				produto = p;
		}
		return produto;
	}

	public boolean verificarQuantidade(int codProduto, int qntProduto) {
		
		for (Produto produto : produtos) {
			if(produto.getCodigo() == codProduto) {
				ProdutoUnidade produtoUnidade = (ProdutoUnidade) produto;
				if(produtoUnidade.getQuantidade() >= qntProduto)
					return true;
			}
		}
		return false;
	}
}
