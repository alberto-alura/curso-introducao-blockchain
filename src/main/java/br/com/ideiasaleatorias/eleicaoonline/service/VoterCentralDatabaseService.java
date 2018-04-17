package br.com.ideiasaleatorias.eleicaoonline.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.ideiasaleatorias.eleicaoonline.daos.VoteDao;
import br.com.ideiasaleatorias.eleicaoonline.daos.VoteTicketDao;
import br.com.ideiasaleatorias.eleicaoonline.models.Candidate;
import br.com.ideiasaleatorias.eleicaoonline.models.VoteTicket;
import br.com.ideiasaleatorias.eleicaoonline.models.VoterIdentity;

@Service
@Qualifier("centralizado")
public class VoterCentralDatabaseService implements VoterService {
	
	@Autowired
	private VoteTicketDao voteTicketDao;
	@Autowired
	private VoteDao voteDao;

	@Override
	public void execute(Candidate candidate,VoterIdentity voterIdentity){
		
		Optional<VoteTicket> possibleTicket = voteTicketDao.findByUserNumber(voterIdentity.getUserNumber());
				
		possibleTicket
		.filter(ticket -> !voteDao.findByVoteIdTicketUserNumber(voterIdentity.getUserNumber()).isPresent())
		.map(ticket -> ticket.vote(candidate))
		.map(voteDao ::  save)
		.orElseThrow(() -> new RuntimeException("esse voto não pode ser computado"));		
	}
}
