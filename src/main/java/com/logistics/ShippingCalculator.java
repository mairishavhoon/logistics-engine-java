package com.logistics;

public class ShippingCalculator {
    private static final double BASE_RATE_PER_KG = 2.50;
    private final TaxService taxService;

    public ShippingCalculator(TaxService taxService) {
        this.taxService = taxService;
    }

    public double calculateShippingCost(Parcel parcel, String destinationCountry) {
        if (parcel == null) {
            throw new IllegalArgumentException("Parcel cannot be null");
        }
        if (destinationCountry == null || destinationCountry.isBlank()) {
            throw new IllegalArgumentException("Destination country cannot be empty");
        }

        // Base cost based on weight
        double baseCost = parcel.getWeightKg() * BASE_RATE_PER_KG;

        // Fetch tax rate from external service
        double taxRate = taxService.getTaxRate(destinationCountry);

        // Total cost = base cost + tax
        return baseCost + (baseCost * taxRate);
    }
}