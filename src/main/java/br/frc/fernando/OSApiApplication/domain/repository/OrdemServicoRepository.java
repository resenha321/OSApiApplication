/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.frc.fernando.OSApiApplication.domain.repository;

import br.frc.fernando.OSApiApplication.domain.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author devsys-a
 */
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>{
    
}
