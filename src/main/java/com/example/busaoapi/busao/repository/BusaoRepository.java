package com.example.busaoapi.busao.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.busaoapi.busao.model.Busao;

public interface BusaoRepository extends JpaRepository<Busao, UUID> {
	
}
