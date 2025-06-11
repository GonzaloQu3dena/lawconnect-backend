package com.qu3dena.lawconnect.backend.profiles.domain.services;

import com.qu3dena.lawconnect.backend.profiles.domain.model.aggregates.ClientAggregate;
import com.qu3dena.lawconnect.backend.profiles.domain.model.queries.GetClientByDniQuery;

import java.util.Optional;

/**
 * Service interface for handling client-related queries.
 * <p>
 * This service defines the contract for processing queries
 * related to client operations, such as retrieving a client by DNI.
 *
 * @author GonzaloQu3dena
 * @since 1.0
 */
public interface ClientQueryService {

    /**
     * Handles the retrieval of a client by DNI.
     *
     * @param query the query containing the DNI of the client to retrieve
     * @return an {@link Optional} containing the retrieved {@link ClientAggregate}, or empty if no client is found
     */
    Optional<ClientAggregate> handle(GetClientByDniQuery query);
}