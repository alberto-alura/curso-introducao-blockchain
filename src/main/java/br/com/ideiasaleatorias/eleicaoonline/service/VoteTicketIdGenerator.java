package br.com.ideiasaleatorias.eleicaoonline.service;

import java.util.function.Supplier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.ideiasaleatorias.eleicaoonline.models.VoteTicketId;

@Service
@Transactional
public class VoteTicketIdGenerator implements Supplier<VoteTicketId>{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public VoteTicketId get() {
		VoteTicketId ticketId = new VoteTicketId();
		manager.persist(ticketId);
		return ticketId;
	}

	
}
