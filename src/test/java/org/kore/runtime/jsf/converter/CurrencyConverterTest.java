/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kore.runtime.jsf.converter;

import java.util.Currency;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Konrad Renner
 */
public class CurrencyConverterTest {

    private Currency value;
    private String stringValue;
    private CurrencyConverter converter;

    @Before
    public void setUp() {
        value = Currency.getInstance("EUR");
        stringValue = "EUR";
        converter = new CurrencyConverter();
    }

    @Test
    public void testGetAsObject() {
        assertThat(converter.getAsObject(null, null, stringValue), is(value));
    }

    @Test
    public void testGetAsObjectNull() {
        assertThat(converter.getAsObject(null, null, null), nullValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAsObjectWrongType() {
        assertThat(converter.getAsObject(null, null, "STRING"), nullValue());
    }

    @Test
    public void testGetAsString() {
        assertThat(converter.getAsString(null, null, value), is(stringValue));
    }

    @Test
    public void testGetAsStringNull() {
        assertThat(converter.getAsString(null, null, null), nullValue());
    }

}
