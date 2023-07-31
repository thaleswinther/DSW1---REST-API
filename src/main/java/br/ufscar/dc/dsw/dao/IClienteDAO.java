package br.ufscar.dc.dsw.dao;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.domain.Cliente;
//import br.ufscar.dc.dsw.domain.Usuario;

@SuppressWarnings("unchecked")
public interface IClienteDAO extends CrudRepository<Cliente, String>{


	Cliente findById(long id);

	Cliente findByCPF(String CPF);

	Cliente findByEmail(String email);

	List<Cliente> findAll();
	
	Cliente save(Cliente cliente);

	void deleteById(Long id);
}