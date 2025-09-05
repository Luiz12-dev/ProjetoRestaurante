package com.example.restaurant.Service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.restaurant.DTO.PratoRequestDTO;
import com.example.restaurant.DTO.PratoResponseDTO;
import com.example.restaurant.Models.Prato;
import com.example.restaurant.Repository.PratoRepository;

@Service
public class PratoService {

    public PratoRepository pratoRepository;

    public PratoService(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }





   public PratoResponseDTO criarPrato(Prato prato){

    Prato pratoSalvo = pratoRepository.save(prato);

    PratoResponseDTO responseDTO = new PratoResponseDTO(
        pratoSalvo.getId(),
        pratoSalvo.getNome(),
        pratoSalvo.getPreco(),
        pratoSalvo.isDisponivel()
        
    );

    return responseDTO;
}

//Nesse caso como poder ou nao encontrar usamos o map e o optional
public Optional<PratoResponseDTO> encontrarPratoPeloNome(String nomePrato){
  Optional<Prato> pratoEncontrado = pratoRepository.findByNome(nomePrato);
  
    return pratoEncontrado.map(prato -> {
        return new PratoResponseDTO(
            prato.getId(),
            prato.getNome(),
            prato.getPreco(),
            prato.isDisponivel()
            
        );
    });


} 

public Optional<PratoResponseDTO> atualizarPratoPeloNome( String nomePrato, PratoRequestDTO pratoDto){
    Optional<Prato> pratoEncontrado = pratoRepository.findByNome(nomePrato);
    
    if(pratoEncontrado.isPresent()){
          Prato prato = pratoEncontrado.get();

        prato.setNome(pratoDto.getNome());
        prato.setPreco(pratoDto.getPreco());
        prato.setDisponivel(pratoDto.isDisponivel());

      Prato pratoAtualizado=pratoRepository.save(prato);

      PratoResponseDTO responseDTO = new PratoResponseDTO(
        pratoAtualizado.getId(),
        pratoAtualizado.getNome(),
        pratoAtualizado.getPreco(),
        pratoAtualizado.isDisponivel()
      );
      return Optional.of(responseDTO);
       
    }else{
         System.out.println("Prato nao encontrado");
        return Optional.empty();
    }
}
public void removerPrato(UUID id){
    if(!pratoRepository.existsById(id)){
        System.out.println("Id do prato nao encontrado !");
    }else{
        pratoRepository.deleteById(id);
        
    }

}


}
