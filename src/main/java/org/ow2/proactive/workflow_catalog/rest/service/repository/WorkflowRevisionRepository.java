/*
 * ProActive Parallel Suite(TM):
 * The Open Source library for parallel and distributed
 * Workflows & Scheduling, Orchestration, Cloud Automation
 * and Big Data Analysis on Enterprise Grids & Clouds.
 *
 * Copyright (c) 2007 - 2017 ActiveEon
 * Contact: contact@activeeon.com
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation: version 3 of
 * the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 */
package org.ow2.proactive.workflow_catalog.rest.service.repository;

import org.ow2.proactive.workflow_catalog.rest.entity.WorkflowRevision;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * @author ActiveEon Team
 */
public interface WorkflowRevisionRepository
        extends PagingAndSortingRepository<WorkflowRevision, Long>, QueryDslPredicateExecutor<WorkflowRevision> {

    @Query("SELECT wr FROM WorkflowRevision wr JOIN wr.workflow w WHERE w.id = ?1")
    Page<WorkflowRevision> getRevisions(Long workflowId, Pageable pageable);

    @Query("SELECT wr FROM WorkflowRevision wr WHERE wr.bucketId = ?1 AND wr.workflow.id = ?2 AND wr.revisionId = ?3")
    WorkflowRevision getWorkflowRevision(Long bucketId, Long workflowId, Long revisionId);

}
