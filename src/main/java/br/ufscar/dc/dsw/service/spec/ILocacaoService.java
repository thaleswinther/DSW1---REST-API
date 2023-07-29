package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Locacao;
//import br.ufscar.dc.dsw.domain.Locadora;
//import br.ufscar.dc.dsw.domain.Cliente;

public interface ILocacaoService {

	Locacao buscarPorId(Long id);

	List<Locacao> buscarTodosPorIdCliente(Long id);

	List<Locacao> buscarTodosPorIdLocadora(Long id);

	
	void salvar(Locacao locacao);
}