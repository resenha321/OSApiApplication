/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.frc.fernando.OSApiApplication.api.controller;

import br.frc.fernando.OSApiApplication.domain.model.Cliente;
import br.frc.fernando.OSApiApplication.domain.repository.ClienteRepository;
import br.frc.fernando.OSApiApplication.domain.service.ClienteService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;/**/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import javax.validation.Valid;

/**
 *
 * @author devsys-a
 */
@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes/{clienteID}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteID) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteID);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {

        return clienteService.salvar(cliente);

    }
    @PutMapping("/clientes/{clienteID}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteID,
                                            @RequestBody Cliente cliente){
        
        /// Verifique se o cliente existe
        if (!clienteRepository.existsById(clienteID)) {
        
            return  ResponseEntity.notFound().build();
        }
        
        cliente.setId((clienteID));
        cliente = clienteService.salvar(cliente);
        return  ResponseEntity.ok(cliente);  
    
    }
    @DeleteMapping("/clientes/{clienteID}")
    public ResponseEntity<Void> excluir(@PathVariable Long clienteID){
        // Verifica se cliente existe ou não
        
        if(!clienteRepository.existsById(clienteID)){
            return ResponseEntity.notFound().build();
        }
        
        clienteService.excluir(clienteID);
        return ResponseEntity.noContent().build();
    
    }
  

}
