package com.qu3dena.lawconnect.backend.profiles.domain.model.queries;

/**
 * Query object for retrieving a client by their DNI.
 *
 * @author GonzaloQu3dena
 * @since 1.0
 *
 * @param dni the unique identifier (DNI) of the client to retrieve
 */
public record GetClientByDniQuery(String dni) {
}