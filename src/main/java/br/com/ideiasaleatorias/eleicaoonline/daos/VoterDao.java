package br.com.ideiasaleatorias.eleicaoonline.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ideiasaleatorias.eleicaoonline.models.Voter;

@Repository
public interface VoterDao extends CrudRepository<Voter, Integer>{

	List<Voter> findAllByEllectionId(Integer ellectionId);

	Optional<Voter> findByNumber(String voterNumber);

}
