/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apiportfolio.apiportfolio.jpa;

import com.apiportfolio.apiportfolio.jpa.exceptions.NonexistentEntityException;
import com.apiportfolio.apiportfolio.model.Skills;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Bruno.Porfidio
 */
public class SkillsJpaController implements Serializable {

    public SkillsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Skills skills) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(skills);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Skills skills) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            skills = em.merge(skills);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = skills.getIdSkills();
                if (findSkills(id) == null) {
                    throw new NonexistentEntityException("The skills with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Skills skills;
            try {
                skills = em.getReference(Skills.class, id);
                skills.getIdSkills();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The skills with id " + id + " no longer exists.", enfe);
            }
            em.remove(skills);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Skills> findSkillsEntities() {
        return findSkillsEntities(true, -1, -1);
    }

    public List<Skills> findSkillsEntities(int maxResults, int firstResult) {
        return findSkillsEntities(false, maxResults, firstResult);
    }

    private List<Skills> findSkillsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Skills.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Skills findSkills(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Skills.class, id);
        } finally {
            em.close();
        }
    }

    public int getSkillsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Skills> rt = cq.from(Skills.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
