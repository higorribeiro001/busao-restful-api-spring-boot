package com.example.busaoapi.busao.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.busaoapi.busao.model.Busao;
import com.example.busaoapi.busao.service.BusaoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/busao")
public class BusaoController {
	@Autowired
	BusaoService busaoService;
	
	@GetMapping
	public Page<Busao> getAll(@RequestParam(required=true) int page) {
		return busaoService.findAll(page); // lembra que começa pela pagina 0
	}
	
	@PostMapping
	public ResponseEntity<Busao> save(@RequestBody Busao busao) {
		return new ResponseEntity<Busao>(busaoService.save(busao), HttpStatus.CREATED); 
	}
	
	@GetMapping("/{id}")
	public Optional<Busao> getById(@PathVariable UUID id) {
		return busaoService.findById(id);
	}
	
	@PutMapping("/{id}")
	public Busao update(@PathVariable UUID id, @RequestBody Busao busao) {
		return busaoService.update(id, busao);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable UUID id) {
		busaoService.delete(id);
	}
}
