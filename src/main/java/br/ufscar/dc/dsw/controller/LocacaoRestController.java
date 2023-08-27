package br.ufscar.dc.dsw.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;

@RestController
public class LocacaoRestController {

	@Autowired
	private ILocacaoService service;

	
	@GetMapping(path = "/api/locacoes")
	public ResponseEntity<List<Locacao>> lista() {
		List<Locacao> lista = service.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

	
	@GetMapping(path = "/api/locacoes/{id}")
	public ResponseEntity<Locacao> lista(@PathVariable("id") long id) {
		Locacao locacao = service.buscarPorId(id);
		if (locacao == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(locacao);
	}

    @GetMapping("/api/locacoes/clientes/{id}")
    public ResponseEntity<List<Locacao>> listaLocacoesDoCliente(@PathVariable Long id) {
        List<Locacao> locacoes = service.buscarTodosPorIdCliente(id);
        return ResponseEntity.ok(locacoes);
    }

    @GetMapping("/api/locacoes/locadora/{id}")
    public ResponseEntity<List<Locacao>> listaLocacoesDaLocadora(@PathVariable Long id) {
        List<Locacao> locacoes = service.buscarTodosPorIdLocadora(id);
        return ResponseEntity.ok(locacoes);
    }
	
}