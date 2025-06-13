package com.qu3dena.lawconnect.backend.cases.domain.model.events;

import java.util.UUID;

/**
 * Event representing the cancellation of a case.
 *
 * @param caseId the ID of the case that has been canceled
 * @author GonzaloQu3dena
 * @since 1.0
 */
public record CaseCanceledEvent(UUID caseId, UUID clientId) {
}