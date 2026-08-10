package com.logistics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class ParcelTest{

    @Test
    @DisplayName("Should create a parcel with valid attributes")
    void shouldCreateParcelSuccessfully(){
        Parcel parcel = new Parcel("DE-100",2.5);

        assertEquals("DE-100", parcel.getTrackingId());
        assertEquals(2.5, parcel.getWeightKg());
    }

    @Test
    @DisplayName("Should throw exception when weight is zero or negative")
    void createExceptionForInvalidWeights(){
        assertThrows(IllegalArgumentException.class, () -> {new Parcel("DE-101",-1.0);

        });
    }
}