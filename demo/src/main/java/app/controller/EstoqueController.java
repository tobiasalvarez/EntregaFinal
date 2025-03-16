package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Estoque;
import app.service.EstoqueService;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {
	
	@Autowired 
	private EstoqueService estoqueService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Estoque estoque){
		try {
			String message = this.estoqueService.save(estoque);
			return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(long id){
		try {
			String message = this.estoqueService.delete(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Estoque> findById(long id){
		try {
			Estoque estoque = this.estoqueService.findById(id);
			return new ResponseEntity<>(estoque, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Estoque>> findAll(){
		try {
			List<Estoque> list = this.estoqueService.findAll();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(Estoque estoque, long id){
		try {
			estoque.setId(id);
			String message = this.estoqueService.save(estoque);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	

}
