package com.qu3dena.lawconnect.backend.cases.application.internal.queryservices;

import com.qu3dena.lawconnect.backend.cases.domain.model.queries.GetCasesByClientIdQuery;
import com.qu3dena.lawconnect.backend.cases.infrastructure.persistence.jpa.repositories.CaseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CaseQueryServiceImplTest {

    @Mock
    CaseRepository repository;
    @InjectMocks
    CaseQueryServiceImpl service;

    @BeforeEach void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("")
    void handleGetByClientId_shouldReturnList() {
        // Arrange
        var clientId = UUID.randomUUID();

        when(repository.findByClientId(clientId))
                .thenReturn(List.of());

        var query = new GetCasesByClientIdQuery(clientId);

        // Act
        var result = service.handle(query);

        // Assert
        assertNotNull(result);
        verify(repository).findByClientId(clientId);
    }
}
