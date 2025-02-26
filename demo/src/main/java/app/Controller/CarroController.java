package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Carro;
import app.Service.CarroService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/carro")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@PostMapping("/save")
	public ResponseEntity<String>save(@RequestBody Carro carro){
		try {
			String message = this.carroService.save(carro);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (Exception e) {
			String erro = e.getMessage();
			System.out.println(erro);
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String>delete(@PathVariable long id){
		try {
			String message = this.carroService.delete(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Carro>findById(@PathVariable long id){
		try {
			Carro carro = this.carroService.findById(id);
			return new ResponseEntity<>(carro, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
	

	@GetMapping("/findAll")
	public ResponseEntity<List<Carro>>findAll(){
		try {
			List<Carro> list = this.carroService.findAll();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String>update(@RequestBody Carro carro,@PathVariable long id){
		try {
			carro.setId(id);
			String message = this.carroService.save(carro);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	}

	


