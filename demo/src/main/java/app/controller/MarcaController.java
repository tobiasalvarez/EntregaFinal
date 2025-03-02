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

import app.entity.Marca;
import app.service.MarcaService;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {
	
	@Autowired
	private MarcaService marcaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Marca marca){
		try {
			String message = this.marcaService.save(marca);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@RequestBody long id){
		try {
			String message = this.marcaService.delete(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Marca> findById(@PathVariable long id){
		try {
			Marca marca = this.marcaService.findById(id);
			return new ResponseEntity<>(marca, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Marca>> findAll(){
		try {
			List<Marca> lista = this.marcaService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update (@RequestBody Marca marca,@PathVariable long id){
		try {
			marca.setId(id);
			String message = this.marcaService.save(marca);
			return new ResponseEntity<>(message, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByNomeIgnoreCase")
	public ResponseEntity<Marca> findByNomeIgnoreCase(@RequestParam String nome){
		try {
			Marca marca = this.marcaService.findByNomeIgnoreCase(nome);
			return new ResponseEntity<>(marca, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByCarrosModelo")
	public ResponseEntity<Marca> findByCarrosModelo(@RequestParam String modelo){
		try {
			Marca marca = this.marcaService.findByCarrosModelo(modelo);
			return new ResponseEntity<>(marca, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}


}
