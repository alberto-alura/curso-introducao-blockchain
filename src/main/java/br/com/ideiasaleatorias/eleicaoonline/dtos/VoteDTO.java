package br.com.ideiasaleatorias.eleicaoonline.dtos;

import java.util.UUID;

import org.springframework.util.StringUtils;

import br.com.ideiasaleatorias.eleicaoonline.models.Candidate;
import br.com.ideiasaleatorias.eleicaoonline.models.VoterIdentity;

public class VoteDTO {

	private String candidateNumber;
	private String ellectionName;
	private String address;	
	private String userNumber;

	public VoteDTO(Candidate candidate, VoterIdentity identity) {
		this.candidateNumber = candidate.getNumber();
		this.ellectionName = StringUtils.trimAllWhitespace(candidate.getEllection().getName());
		this.address = UUID.randomUUID().toString();
		this.userNumber = identity.getUserNumber();
	}
	
	public String getUserNumber() {
		return userNumber;
	}
	
	
	public String getAddress() {
		return address;
	}
	
	public String getCandidateNumber() {
		return candidateNumber;
	}
	
	public String getEllectionName() {
		return ellectionName;
	}

}


