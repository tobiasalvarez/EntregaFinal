package app.controller;

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

import app.entity.Comanda;
import app.entity.Marca;
import app.service.ComandaService;

@RestController
@RequestMapping("/comandas")
public class ComandaController {

    @Autowired
    private ComandaService comandaService;

    @GetMapping
    public List<Comanda> listarTodas() {
        return comandaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comanda> buscarPorId(@PathVariable Long id) {
    		try {
    			Comanda comanda = this.comandaService.;
    			return new ResponseEntity<>(comanda, HttpStatus.OK);
    		} catch (Exception e) {
    			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    		}
    	}
    	
    

    @PostMapping
    public Comanda criar(@RequestBody Comanda comanda) {
        return comandaService.salvar(comanda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        comandaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
