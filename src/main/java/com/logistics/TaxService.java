package com.logistics;

public interface TaxService {
    /**
     * Fetches the tax rate for a given destination country.
     * @param destinationCountry e.g., "DE", "US", "FR"
     * @return tax rate as a decimal (e.g., 0.19 for 19%)
     */
    double getTaxRate(String destinationCountry);
}

/*
* In real life, TaxService might connect to a real web service or external database.
*  By making it an interface, we can test ShippingCalculator without needing
*  a live internet
*  connection or running tax server—Mockito will generate a fake implementation for us!
* */