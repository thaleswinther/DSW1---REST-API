package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Locacao;


public interface ILocacaoService {

	Locacao buscarPorId(Long id);

	List<Locacao> buscarTodosPorIdCliente(Long id);

	List<Locacao> buscarTodosPorIdLocadora(Long id);

	List<Locacao> buscarTodos();

	
	void salvar(Locacao locacao);
}