package br.com.ideiasaleatorias.eleicaoonline.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class VoteId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5885657950913011772L;
	@ManyToOne
	@NotNull
	private VoteTicket ticket;
	@ManyToOne
	@NotNull
	private Candidate candidate;

	/**
	 * @deprecated
	 */
	public VoteId() {

	}

	public VoteId(@NotNull VoteTicket ticket, @NotNull Candidate candidate) {
		super();
		this.ticket = ticket;
		this.candidate = candidate;
	}

}
