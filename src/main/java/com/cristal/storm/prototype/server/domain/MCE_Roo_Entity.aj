// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cristal.storm.prototype.server.domain;

import com.cristal.storm.prototype.server.domain.MCE;
import java.lang.Integer;
import java.lang.Long;
import java.lang.SuppressWarnings;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect MCE_Roo_Entity {
    
    declare @type: MceDto: @Entity;
    
    @PersistenceContext
    transient EntityManager MCE.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long MCE.id;
    
    @Version
    @Column(name = "version")
    private Integer MCE.version;
    
    public Long MCE.getId() {
        return this.id;
    }
    
    public void MCE.setId(Long id) {
        this.id = id;
    }
    
    public Integer MCE.getVersion() {
        return this.version;
    }
    
    public void MCE.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void MCE.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void MCE.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            MCE attached = MCE.findMCE(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void MCE.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void MCE.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public MCE MCE.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        MCE merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager MCE.entityManager() {
        EntityManager em = new MCE().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long MCE.countMCES() {
        return ((Number) entityManager().createQuery("select count(o) from MCE o").getSingleResult()).longValue();
    }
    
    @SuppressWarnings("unchecked")
    public static List<MCE> MCE.findAllMCES() {
        return entityManager().createQuery("select o from MCE o").getResultList();
    }
    
    public static MCE MCE.findMCE(Long id) {
        if (id == null) return null;
        return entityManager().find(MCE.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public static List<MCE> MCE.findMCEEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from MCE o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
