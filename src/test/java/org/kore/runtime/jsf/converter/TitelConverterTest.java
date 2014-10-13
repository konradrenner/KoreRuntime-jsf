/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kore.runtime.jsf.converter;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.kore.runtime.person.Titel;

/**
 *
 * @author Konrad Renner
 */
public class TitelConverterTest {

    private Titel value;
    private String stringValue;
    private TitelConverter converter;

    @Before
    public void setUp() {
        value = new Titel("TITEL");
        stringValue = "TITEL";
        converter = new TitelConverter();
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
        assertThat(converter.getAsString(null, null, "STRING"), nullValue());
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
