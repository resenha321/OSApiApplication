/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.frc.fernando.OSApiApplication.domain.repository;

import br.frc.fernando.OSApiApplication.domain.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author devsys-a
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    List<Cliente> findByNome (String nome);
    List<Cliente> findByNomeContaining(String nome);
    Cliente findByEmail(String email);
    
}
