package com.qu3dena.lawconnect.backend.iam.interfaces.rest;

import com.qu3dena.lawconnect.backend.iam.domain.model.queries.GetAllUsersQuery;
import com.qu3dena.lawconnect.backend.iam.domain.services.UserQueryService;
import com.qu3dena.lawconnect.backend.iam.interfaces.rest.resources.UserResource;
import com.qu3dena.lawconnect.backend.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for handling user-related endpoints.
 * <p>
 * Provides endpoints for retrieving users available in the system.
 * </p>
 *
 * @author GonzaloQu3dena
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Users", description = "Available User Endpoints")
public class UsersController {

    private final UserQueryService userQueryService;

    /**
     * Constructs a {@code UsersController} with the specified {@link UserQueryService}.
     *
     * @param userQueryService the service handling user queries
     */
    public UsersController(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    /**
     * Retrieves all users available in the system.
     *
     * @return a {@link ResponseEntity} containing a list of {@link UserResource} and HTTP status
     */
    @GetMapping
    @Operation(summary = "Get all users", description = "Get all the users available in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users retrieved successfully."),
            @ApiResponse(responseCode = "401", description = "Unauthorized.")})
    public ResponseEntity<List<UserResource>> getAllUsers() {
        var getAllUsersQuery = new GetAllUsersQuery();
        var users = userQueryService.handle(getAllUsersQuery);

        var userResources = users.stream()
                .map(UserResourceFromEntityAssembler::toResourceFromEntity).toList();

        return ResponseEntity.ok(userResources);
    }
}