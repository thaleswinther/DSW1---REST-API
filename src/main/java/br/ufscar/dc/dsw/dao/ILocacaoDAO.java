package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Locacao;
//import br.ufscar.dc.dsw.domain.Cliente;
//import br.ufscar.dc.dsw.domain.Locadora;

@SuppressWarnings("unchecked")
public interface ILocacaoDAO extends CrudRepository<Locacao, Long>{

	Locacao findById(long id);

	List<Locacao> findAll();

	List<Locacao> findAllBycliente_id(Long cliente_id);

	List<Locacao> findAllBylocadora_id(Long locadora_id);
	
	Locacao save(Locacao locacao);
}