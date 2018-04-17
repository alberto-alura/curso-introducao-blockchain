package br.com.ideiasaleatorias.eleicaoonline.service;

import br.com.ideiasaleatorias.eleicaoonline.models.Candidate;
import br.com.ideiasaleatorias.eleicaoonline.models.VoterIdentity;

public interface VoterService {

	/**
	 * 
	 * @param candidate candidato que vai levar o voto
	 * @param voterIdentity
	 * @return
	 */
	void execute(Candidate candidate, VoterIdentity voterIdentity);

}