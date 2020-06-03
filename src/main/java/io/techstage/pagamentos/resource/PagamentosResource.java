package io.techstage.pagamentos.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.techstage.pagamentos.model.Pagamento;
import io.techstage.pagamentos.repository.Pagamentos;

@CrossOrigin
@RestController	
@RequestMapping("/pagamentos")
public class PagamentosResource {
  
	@Autowired
	private Pagamentos pagamentos;
	
	@CrossOrigin
	@PostMapping
	public Pagamento adicionar(@Valid @RequestBody Pagamento pagamento) {
		return pagamentos.save(pagamento);
	}
	
	@CrossOrigin
	@GetMapping
	public List<Pagamento> listar() {
		return pagamentos.findAll();
	}
  
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Pagamento> buscar(@PathVariable Long id) {
    Pagamento pagamento = pagamentos.findById(id).get();
    
		if (pagamento == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pagamento);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Pagamento> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Pagamento pagamento) {
				Pagamento existente = pagamentos.findById(id).get();
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(pagamento, existente, "id");
		
		existente = pagamentos.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Pagamento pagamento = pagamentos.findById(id).get();
		
		if (pagamento == null) {
			return ResponseEntity.notFound().build();
		}
		
		pagamentos.delete(pagamento);
		
		return ResponseEntity.noContent().build();
	}
}