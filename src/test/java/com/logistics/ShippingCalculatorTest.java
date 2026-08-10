package com.logistics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class) // Enables Mockito annotations in JUnit 5
class ShippingCalculatorTest {

    @Mock
    private TaxService taxServiceMock; // Creates a fake version of TaxService

    @InjectMocks
    private ShippingCalculator calculator; // Automatically injects taxServiceMock into calculator

    @Test
    void shouldCalculateTotalCostWithTaxForGermany() {
        // 1. Arrange: Tell the mock how to behave
        // When getTaxRate("DE") is called, return 0.19 (19% tax)
        when(taxServiceMock.getTaxRate("DE")).thenReturn(0.19);

        Parcel parcel = new Parcel("TRACK-123", 10.0); // 10 kg parcel

        // 2. Act: Base cost = 10kg * 2.50 = 25.00. Tax (19%) = 4.75. Total = 29.75
        double totalCost = calculator.calculateShippingCost(parcel, "DE");

        // 3. Assert: Check the calculation
        assertEquals(29.75, totalCost, 0.001);

        // 4. Verify: Confirm ShippingCalculator actually called taxServiceMock once
        verify(taxServiceMock, times(1)).getTaxRate("DE");
    }

    // 🌟 NEW: Parameterized Test running multiple tax/weight scenarios at once
    @ParameterizedTest(name = "Weight {0}kg to country {1} with tax {2} should cost {3}")
    @CsvSource({
            "2.0,  DE, 0.19, 5.95",   // 2.0kg * 2.50 = 5.00 + 19% tax = 5.95
            "4.0,  US, 0.07, 10.70",  // 4.0kg * 2.50 = 10.00 + 7% tax = 10.70
            "10.0, FR, 0.20, 30.00"   // 10.0kg * 2.50 = 25.00 + 20% tax = 30.00
    })
    void shouldCalculateCostForMultipleCountries(double weight, String country, double taxRate, double expectedCost) {
        // Arrange
        when(taxServiceMock.getTaxRate(country)).thenReturn(taxRate);
        Parcel parcel = new Parcel("TRACK-MULTI", weight);

        // Act
        double actualCost = calculator.calculateShippingCost(parcel, country);

        // Assert
        assertEquals(expectedCost, actualCost, 0.001);
    }
}
}