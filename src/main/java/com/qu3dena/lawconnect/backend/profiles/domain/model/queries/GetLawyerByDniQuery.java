package com.qu3dena.lawconnect.backend.profiles.domain.model.queries;

/**
 * Query object for retrieving a lawyer by their DNI.
 *
 * @author GonzaloQu3dena
 * @since 1.0
 *
 * @param dni the unique identifier (DNI) of the lawyer to retrieve
 */
public record GetLawyerByDniQuery(String dni) {
}