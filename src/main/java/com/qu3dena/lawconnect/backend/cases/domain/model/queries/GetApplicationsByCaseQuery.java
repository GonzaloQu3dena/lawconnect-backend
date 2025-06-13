package com.qu3dena.lawconnect.backend.cases.domain.model.queries;

import java.util.UUID;

/**
 * Query to retrieve applications associated with a specific case.
 *
 * @param caseId the ID of the case for which applications are being retrieved
 * @since 1.0
 * @author GonzaloQu3dena
 */
public record GetApplicationsByCaseQuery(UUID caseId) {
}