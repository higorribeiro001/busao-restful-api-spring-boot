package com.example.busaoapi.busao.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.busaoapi.busao.model.Busao;
import com.example.busaoapi.busao.repository.BusaoRepository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BusaoService {
	@Autowired
	private BusaoRepository busaoRepository;
	
	public Page<Busao> findAll(int page) {
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size);
		
		return busaoRepository.findAll(pageRequest);
	}
	
	public Optional<Busao> findById(UUID id) {
		return busaoRepository.findById(id);
	}
	
	public Busao save(Busao busao) {
		return busaoRepository.save(busao);
	}
	
	public Busao update(UUID id, Busao busao) {
		if (busaoRepository.existsById(id)) {
			busao.setId(id);
			return busaoRepository.save(busao);
		} else {
			throw new RuntimeException("Busão não encontrado");
		}
	}
	
	public void delete(UUID id) {
		busaoRepository.deleteById(id);;
	}
}
