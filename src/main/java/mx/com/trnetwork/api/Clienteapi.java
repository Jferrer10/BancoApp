package mx.com.trnetwork.api;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import mx.com.trnetwork.dto.Cliente;

import mx.com.trnetwork.repository.ClienteRepository;

@RestController 
@RequestMapping("/clientes")
public class Clienteapi{
	
	
	@Autowired(required = false)
	ClienteRepository clienRepo;

	@GetMapping
    public List<Cliente> getUsers() {
        return (List<Cliente>) clienRepo.findAll();
    }
	
	@GetMapping("/{id}")
	public Optional<Cliente> getProveeId(@PathVariable long id) {
	 System.out.println(clienRepo.findById(id));
		return clienRepo.findById(id);
 	} 
	
		
	@PostMapping("/agregar")
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienRepo.save(cliente);
    }

	@PutMapping("/editar/{id}")
	public Cliente UpdateCliente(@PathVariable long id,@RequestBody Cliente cliente) {
		clienRepo.findById(id);
		return clienRepo.save(cliente);
	}
	
	@DeleteMapping("/borra/{id}")
	public void deleteId(@PathVariable long id) {
	 clienRepo.deleteById(id);
	}
	
	@DeleteMapping("/borratodos")
	public void deleteAll() {
	clienRepo.deleteAll();
	
	}

}