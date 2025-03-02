package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Peca;
import app.service.PecaService;

@RestController
@RequestMapping("/api/peca")
public class PecaController {
	
	@Autowired
	private PecaService pecaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Peca peca){
		try {
			String message = this.pecaService.save(peca);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@RequestBody long id){
		try {
			String message = this.pecaService.delete(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Peca> findById(@PathVariable long id){
		try {
			Peca peca = this.pecaService.findById(id);
			return new ResponseEntity<>(peca, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Peca>> findAll(){
		try {
			List<Peca> lista = this.pecaService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update (@RequestBody Peca peca,@PathVariable long id){
		try {
			peca.setId(id);
			String message = this.pecaService.save(peca);
			return new ResponseEntity<>(message, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByCarrosModeloIgnoreCase")
	public ResponseEntity<Peca> findByCarrosModeloIgnoreCase(@RequestParam String modelo){
		try {
			Peca peca = this.pecaService.findByCarrosModeloIgnoreCase(modelo);
			return new ResponseEntity<>(peca, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByFornecedoresNomeIgnoreCase")
	public ResponseEntity<Peca> findByFornecedoresNomeIgnoreCase(String nome){
		try {
			Peca peca = this.pecaService.findByFornecedoresNomeIgnoreCase(nome);
			return new ResponseEntity<>(peca, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}


}
