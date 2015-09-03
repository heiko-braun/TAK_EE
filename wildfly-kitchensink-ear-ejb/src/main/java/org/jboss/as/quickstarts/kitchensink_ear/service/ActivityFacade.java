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

import org.jboss.as.quickstarts.kitchensink_ear.model.Activity;
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
public class ActivityFacade {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    public void createActivity(Activity activity) {
        log.info("Create " + activity);
        em.persist(activity);
    }

    public void removeActivity(Activity activity) {
        log.info("Remove" + activity);
        em.remove(activity);
    }

    @PostConstruct
    public void init() {
        Collection<Activity> activities = findAllActivities();
        for (Activity activity : activities) {
            log.info(activity.toString());
        }
    }

    public Collection<Activity> findAllActivities() {
        Query query = em.createQuery("SELECT a FROM Activity a");
        return (Collection<Activity>) query.getResultList();
    }

    public Activity findActivity(Long id) {
        return em.find(Activity.class, id);
    }
}
