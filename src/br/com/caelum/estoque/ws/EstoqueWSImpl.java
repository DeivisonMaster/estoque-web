package br.com.caelum.estoque.ws;

import java.util.Arrays;

import javax.jws.WebService;

// endpointInterface = define a classe responsável por disponibilizar o serviço. - serviceName = altera o nome do serviço wsdl
@WebService(endpointInterface = "br.com.caelum.estoque.ws.EstoqueWS", serviceName = "EstoqueWS")
public class EstoqueWSImpl implements EstoqueWS{

	@Override
	public ListaItens todosOsItens(Filtros filtros) {
		System.out.println("Chamando todos os itens");
		
		ListaItens listaItens = new ListaItens();
		listaItens.item = Arrays.asList(geraItem());
		
		return listaItens;
	}

	@Override
	public CadastrarItemResponse cadastrarItem(CadastrarItem parameters, TokenUsuario tokenUsuario)
			throws AutorizacaoFault {
		System.out.println("Chamando cadastrar Item");
		
		CadastrarItemResponse resposta = new CadastrarItemResponse();
		resposta.setItem(geraItem());
		
		return resposta;
	}
	
	
	private Item geraItem() {
		Item item = new Item();
		item.setCodigo("MEA");
		item.setNome("MEAN");
		item.setQuantidade(5);
		item.setTipo("Livro");
		
		return item;
	}

}
