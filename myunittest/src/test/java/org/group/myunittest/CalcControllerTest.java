package org.group.myunittest;

import lombok.AllArgsConstructor;
import org.group.myunittest.controller.CalcController;
import org.group.myunittest.service.ICalcInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@AllArgsConstructor
public class CalcControllerTest {

    @Mock
    private ICalcInterface iCalcInterface;

    @Captor
    private ArgumentCaptor<Integer> argumentCaptor;

    private CalcController calcController;

    @BeforeEach
    public void setUp() {
        this.calcController = new CalcController(iCalcInterface);
    }

    @Test
    public void testAdd_PositiveNumbers() {
        // Given
        int a = 5;
        int b = 3;
        int expectedResult = a + b;
        when(iCalcInterface.add(anyInt(), anyInt())).thenReturn(expectedResult);

        // When
        ResponseEntity<Integer> responseEntity = calcController.add(a, b);

        // Then
        assertEquals(expectedResult, responseEntity.getBody());
        verify(iCalcInterface).add(argumentCaptor.capture(), argumentCaptor.capture());
        assertEquals(a, argumentCaptor.getAllValues().get(0).intValue());
        assertEquals(b, argumentCaptor.getAllValues().get(1).intValue());
    }

    @Test
    public void testAdd_Zero() {
        // Given
        int a = 0;
        int b = 0;
        int expectedResult = a + b;
        when(iCalcInterface.add(anyInt(), anyInt())).thenReturn(expectedResult);

        // When
        ResponseEntity<Integer> responseEntity = calcController.add(a, b);

        // Then
        assertEquals(expectedResult, responseEntity.getBody());
        verify(iCalcInterface).add(argumentCaptor.capture(), argumentCaptor.capture());
        assertEquals(a, argumentCaptor.getAllValues().get(0).intValue());
        assertEquals(b, argumentCaptor.getAllValues().get(1).intValue());
    }

    @Test
    public void testAdd_NegativeNumbers() {
        // Given
        int a = -5;
        int b = -3;
        int expectedResult = a + b;
        when(iCalcInterface.add(anyInt(), anyInt())).thenReturn(expectedResult);

        // When
        ResponseEntity<Integer> responseEntity = calcController.add(a, b);

        // Then
        assertEquals(expectedResult, responseEntity.getBody());
        verify(iCalcInterface).add(argumentCaptor.capture(), argumentCaptor.capture());
        assertEquals(a, argumentCaptor.getAllValues().get(0).intValue());
        assertEquals(b, argumentCaptor.getAllValues().get(1).intValue());
    }

    @Test
    public void testAdd_NullResponseEntity() {
        // Given
        int a = 5;
        int b = 3;
        when(iCalcInterface.add(anyInt(), anyInt())).thenReturn(null);

        // When
        ResponseEntity<Integer> responseEntity = calcController.add(a, b);

        // Then
        assertNotNull(responseEntity);
        verify(iCalcInterface).add(argumentCaptor.capture(), argumentCaptor.capture());
        assertEquals(a, argumentCaptor.getAllValues().get(0).intValue());
        assertEquals(b, argumentCaptor.getAllValues().get(1).intValue());
    }
}
