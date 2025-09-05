package com.example.restaurant.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restaurant.Models.Prato;
import java.util.List;



@Repository
public interface PratoRepository extends JpaRepository< Prato, UUID>{
 Optional<List<Prato>> findByNome(String nome);
}
