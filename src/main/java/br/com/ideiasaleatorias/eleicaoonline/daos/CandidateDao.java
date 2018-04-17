package br.com.ideiasaleatorias.eleicaoonline.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ideiasaleatorias.eleicaoonline.models.Candidate;

@Repository
public interface CandidateDao extends CrudRepository<Candidate, Integer>{

	List<Candidate> findAllByEllectionId(Integer ellectionId);

}
