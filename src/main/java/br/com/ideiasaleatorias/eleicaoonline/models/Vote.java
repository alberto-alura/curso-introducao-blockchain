package br.com.ideiasaleatorias.eleicaoonline.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Vote implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2418694809188044536L;
	@EmbeddedId
	private VoteId voteId;
	@NotNull
	private LocalDateTime instant = LocalDateTime.now();

	/**
	 * @deprecated
	 */
	public Vote() {

	}

	public Vote(@NotNull VoteTicket ticket, @NotNull Candidate candidate) {
		super();
		this.voteId = new VoteId(ticket, candidate);
	}

}
