package br.com.ideiasaleatorias.eleicaoonline.daos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ideiasaleatorias.eleicaoonline.models.Vote;
import br.com.ideiasaleatorias.eleicaoonline.models.VoteId;

@Repository
public interface VoteDao extends CrudRepository<Vote, VoteId>{

	Optional<Vote> findByVoteIdTicketUserNumber(String ticketCode);

}
