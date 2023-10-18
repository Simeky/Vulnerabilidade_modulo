package com.vulnerabilidade.controllers;

import com.vulnerabilidade.DTOS.request.RelatorioRequestDTO;
import com.vulnerabilidade.DTOS.response.RelatorioResponseDTO;
import com.vulnerabilidade.classes.Relatorio;
import com.vulnerabilidade.repositorios.RelatorioRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("relatorio")
public class RelatorioController {

  @Autowired
  private RelatorioRepositorio repositorio;

  //Create
  @PostMapping("Add_relatorio")
  public Relatorio criar_relatorio(@RequestBody RelatorioRequestDTO data){

    Relatorio relatorio_dados = new Relatorio(data);
    return repositorio.save(relatorio_dados);
    

  }

  //Read
  @GetMapping("relatorios")
  public List<RelatorioResponseDTO> getAll(){

    List<RelatorioResponseDTO> relatorio_list = repositorio.findAll().stream().map(RelatorioResponseDTO::new).toList();
    return relatorio_list;
    
  }

  //Update
  @PutMapping("/{relatorio_id}")
  public ResponseEntity<RelatorioResponseDTO> update_relatorio(@PathVariable Long relatorio_id, @RequestBody RelatorioRequestDTO data) {

    Optional<Relatorio> relatorio_optional = repositorio.findById(relatorio_id);
    if (relatorio_optional.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    Relatorio relatorio = relatorio_optional.get();
    
    relatorio.setRelatorio_necessidades(data.relatorio_necessidades());
    relatorio.setRelatorio_renda(data.relatorio_renda());
    relatorio.setRelatorio_nivel_vulnerabilidade(data.relatorio_nivel_vulnerabilidade());
    relatorio.setRelatorio_data(data.relatorio_data());
    relatorio.setRelatorio_data_visita(data.relatorio_data_visita());
    RelatorioResponseDTO responseDTO = new RelatorioResponseDTO(relatorio);

    return ResponseEntity.ok(responseDTO);
  }

  //Delete
  @DeleteMapping("/{relatorio_id}")
  public ResponseEntity<Void> delete_relatorio(@PathVariable Long relatorio_id) {

  Optional<Relatorio> relatorio_optional = repositorio.findById(relatorio_id);
  if (relatorio_optional.isEmpty()) {
    return ResponseEntity.notFound().build();
  }
  
  repositorio.deleteById(relatorio_id);
  return ResponseEntity.noContent().build();
}

}