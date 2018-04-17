package br.com.ideiasaleatorias.eleicaoonline.controllers.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VotingBoothForm {

	@NotBlank
	private String ticketCode;
	@NotNull
	private Integer candidateId;
	@NotNull
	private Integer ellectionId;

	public String getTicketCode() {
		return ticketCode;
	}

	public void setTicketCode(String voterNumber) {
		this.ticketCode = voterNumber;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public Integer getEllectionId() {
		return ellectionId;
	}

	public void setEllectionId(Integer ellectionId) {
		this.ellectionId = ellectionId;
	}

}
