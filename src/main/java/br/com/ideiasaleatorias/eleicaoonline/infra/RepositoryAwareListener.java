package br.com.ideiasaleatorias.eleicaoonline.infra;

import javax.persistence.EntityListeners;
import javax.persistence.PostLoad;

import org.springframework.data.repository.Repository;

/**
 * O objetivo deste {@link EntityListeners} é atribuir o {@link Repository}
 * específico para uma determinada entidade. O contrato moral é que ela tenha um
 * atributo que implemente a interface {@link Repository} do Spring Data JPA :).
 * O nome do atributo deve ser <b>repository</b>.
 * 
 * Caso a classe queira usar, é só usar a annotation {@link EntityListeners} e
 * apontar para o {@link RepositoryAwareListener}.
 * 
 * Todo carregamento de objeto para o contexto de persistência, seja via findBy
 * ou query, deveria passar por esse método.
 * 
 * @author alberto
 *
 */
public class RepositoryAwareListener {

	@PostLoad
	public void postLoad(Object entity) {
		ApplicationContextHolder.getInstance().getAutowireCapableBeanFactory().autowireBean(entity);

	}
}
