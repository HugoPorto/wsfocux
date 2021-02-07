package me.medical.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import me.medical.model.UsuarioModel;

@Repository
public class UsuarioCustomRepository{
	
	 private final EntityManager em;

	    public UsuarioCustomRepository(EntityManager em) {
	        this.em = em;
	    }

	    public List<UsuarioModel> find(Integer id, String nomeDoResponsavel) {

	        String query = "select u from usuario u ";
	        String condicao = "where";

	        if(id != null) {
	            query += condicao + " u.id = :id";
	            condicao = " and ";
	        }

	        if(nomeDoResponsavel != null) {
	            query += condicao + " u.nomeDoResponsavel = :nomeDoResponsavel";
	            condicao = " and ";
	        }

	        var q = em.createQuery(query, UsuarioModel.class);

	        if(id != null) {
	            q.setParameter("id", id);
	        }

	        if(nomeDoResponsavel != null) {
	            q.setParameter("nomeDoResponsavel", nomeDoResponsavel);
	        }

	        return q.getResultList();
	    }

	}