/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.kitchensink_ear.service;

import org.jboss.as.quickstarts.kitchensink_ear.model.Opportunity;
import org.jboss.as.quickstarts.kitchensink_ear.model.Member;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.logging.Logger;

@Stateless
public class OpportunityFacade {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    public void createOpportunity(Opportunity op) {
        log.info("Create " + op);
        em.persist(op);
    }

    public void removeOpportunity(Opportunity op) {
        log.info("Remove" + op);
        em.remove(op);
    }

    public Collection<Opportunity> findAllOpportunities() {
        Query query = em.createQuery("SELECT a FROM Opportunity a");
        return (Collection<Opportunity>) query.getResultList();
    }

    public Opportunity findOpportunity(Long id) {
        return em.find(Opportunity.class, id);
    }
}
