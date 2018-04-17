package br.com.ideiasaleatorias.eleicaoonline.daos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ideiasaleatorias.eleicaoonline.models.VoteTicket;

@Repository
public interface VoteTicketDao extends CrudRepository<VoteTicket, Integer>{

	Optional<VoteTicket> findByUserNumber(String userNumber);

}
