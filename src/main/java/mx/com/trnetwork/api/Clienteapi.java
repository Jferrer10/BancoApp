package mx.com.trnetwork.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import mx.com.trnetwork.dto.Cliente;

import mx.com.trnetwork.repository.ClienteRepository;


public class Clienteapi{
	
	
	@Autowired(required = false)
	ClienteRepository clienRepo;

		@RequestMapping(value="/clientes/agregar-cliente", method= RequestMethod.GET)
			public String add() {
				return "agregarClientes";
			}

	@PostMapping("/clientes")
	public ModelAndView cli(Cliente cl) {
		clienRepo.save(cl);
		return new ModelAndView("redirect:/clientes");
	}


}