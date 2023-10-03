package dev.lydtech.dispatch.handler;

import dev.lydtech.dispatch.service.DispatchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


class OrderCreatedHandlerTest {

    private OrderCreatedHandler orderCreatedHandler;
    private DispatchService dispatchServiceMock;


    @BeforeEach
    void setUp() {
        dispatchServiceMock = mock(DispatchService.class);
        orderCreatedHandler = new OrderCreatedHandler(dispatchServiceMock);
    }

    @Test
    void listen() {
        orderCreatedHandler.listen("payload");
        verify(dispatchServiceMock, times(1)).process("payload");
    }
}