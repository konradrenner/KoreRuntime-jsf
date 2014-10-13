/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kore.runtime.jsf.converter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.kore.runtime.person.Birthday;

/**
 *
 * @author Konrad Renner
 */
public class BirthdayConverterTest {

    private BirthdayConverter converter;
    private String formatted;
    private Birthday dateObject;

    @Before
    public void setUp() {
        converter = new BirthdayConverter();
        formatted = "01.01.2014";
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2014);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        dateObject = new Birthday(cal.getTime());
    }

    @Test
    public void testGetAsObject() {
        assertThat(converter.getAsObject(null, null, formatted, new SimpleDateFormat("dd.MM.yyyy")), is(dateObject));
    }

    @Test
    public void testGetAsObjectNull() {
        assertThat(converter.getAsObject(null, null, null), nullValue());
    }

    @Test
    public void testGetAsStringNull() {
        assertThat(converter.getAsString(null, null, null), nullValue());
    }

    @Test(expected = IllegalStateException.class)
    public void testGetAsStringWrongType() {
        converter.getAsObject(null, null, "STRING");
    }

    @Test
    public void testGetAsString() {
        assertThat(converter.getAsString(null, null, dateObject, new SimpleDateFormat("dd.MM.yyyy")), is(formatted));
    }

}
