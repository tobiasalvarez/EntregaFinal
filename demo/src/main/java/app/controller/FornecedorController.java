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

import app.entity.Fornecedor;
import app.service.FornecedorService;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Fornecedor fornecedor){
		try {
			String message = this.fornecedorService.save(fornecedor);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			String erro = e.getMessage();
			System.out.println(erro);
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@RequestBody long id){
		try {
			String message = this.fornecedorService.delete(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Fornecedor> findById(@PathVariable long id){
		try {
			Fornecedor fornecedor = this.fornecedorService.findById(id);
			return new ResponseEntity<>(fornecedor, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Fornecedor>> findAll(){
		try {
			List<Fornecedor> list = this.fornecedorService.findAll();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update (@RequestBody Fornecedor fornecedor,@PathVariable long id){
		try {
			fornecedor.setId(id);
			String message = this.fornecedorService.save(fornecedor);
			return new ResponseEntity<>(message, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByPecasNome")
	public ResponseEntity<Fornecedor> findByPecasNome(@RequestParam String nome){
		try {
			Fornecedor fornecedor = this.fornecedorService.findByPecasNome(nome);
			return new ResponseEntity<>(fornecedor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByEmail")
	public ResponseEntity<Fornecedor> findByEmail(@RequestParam String email){
		try {
			Fornecedor fornecedor = this.fornecedorService.findByEmail(email);
			return new ResponseEntity<>(fornecedor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
