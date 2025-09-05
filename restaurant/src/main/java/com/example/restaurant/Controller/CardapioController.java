package com.example.restaurant.Controller;

import java.util.Optional;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.DTO.PratoRequestDTO;
import com.example.restaurant.DTO.PratoResponseDTO;
import com.example.restaurant.Service.PratoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/pratos")
public class CardapioController {

    public PratoService pratoService;

    public CardapioController(PratoService pratoService) {
        this.pratoService = pratoService;
    }

    @PostMapping
    public ResponseEntity<PratoResponseDTO> criarPrato(@RequestBody PratoRequestDTO pratoRequestDTO){
        PratoResponseDTO responseDTO = pratoService.criarPrato(pratoRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PratoResponseDTO>> listarTodosPratos(){
        List<PratoResponseDTO> pratos = pratoService.listarTodosPratos();

        return ResponseEntity.ok(pratos);
    }
@GetMapping("/nome/{nomePrato}")
public ResponseEntity<PratoResponseDTO> buscarPratoPeloNome(@PathVariable String nome){
    Optional<PratoResponseDTO> prato = pratoService.encontrarPratoPeloNome(nome);

    return prato.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
}

@PutMapping("/nome/{nomePrato}")
public ResponseEntity<PratoResponseDTO> atualizarPratoPeloNome(@PathVariable String nome , @RequestBody PratoRequestDTO pratoRequestDTO){
   Optional <PratoResponseDTO> pratoAtualizado = pratoService.atualizarPratoPeloNome(nome,pratoRequestDTO);

   return pratoAtualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

}

@DeleteMapping("/{id}")
public ResponseEntity<Void>deletarPratoPeloId(@PathVariable UUID id){

    try{
        pratoService.removerPratoPeloId(id);
        return ResponseEntity.noContent().build();
    }catch(RuntimeException e){
        return ResponseEntity.notFound().build();
    }

    
    
}

}
