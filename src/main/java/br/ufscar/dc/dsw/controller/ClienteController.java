package br.ufscar.dc.dsw.controller;

import java.time.LocalDate;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.service.spec.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;


	@GetMapping("/cadastrar")
	public String cadastrar(Cliente cliente) {
		return "cliente/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("clientes", clienteService.buscarTodos());
		return "cliente/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr, BCryptPasswordEncoder encoder) {

		if (result.hasErrors()) {
			return "cliente/cadastro";
		}

    
        // Verifica se a data de nascimento é válida e não é futura
		try {
			LocalDate dataNascimento = LocalDate.parse(cliente.getDataNascimento());
			LocalDate dataAtual = LocalDate.now();
			if (dataNascimento.isAfter(dataAtual)) {
				result.rejectValue("dataNascimento", "error.cliente", "A data de nascimento não pode ser futura");
				return "cliente/cadastro";
			}
		} catch (Exception e) {
			result.rejectValue("dataNascimento", "error.cliente", "Data de nascimento inválida");
			return "cliente/cadastro";
		}

		cliente.setPassword(encoder.encode(cliente.getPassword()));
		clienteService.salvar(cliente);
		attr.addFlashAttribute("success", "cliente.create.success");
		return "redirect:/clientes/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cliente", clienteService.buscarPorId(id));
		return "cliente/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr, BCryptPasswordEncoder encoder) {

		if (result.getFieldErrorCount() > 1 || result.getFieldError("CPF") == null) {
			System.out.println("\n\n\nTHALES WINTHER\n\n\n");
			return "cliente/cadastro";
		}

		cliente.setPassword(encoder.encode(cliente.getPassword()));
		clienteService.salvar(cliente);

		attr.addFlashAttribute("success", "cliente.edit.success");
		return "redirect:/clientes/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		clienteService.excluir(id);
		attr.addFlashAttribute("success", "cliente.delete.success");
		return "redirect:/clientes/listar";
	}
}
