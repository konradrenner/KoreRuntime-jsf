/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kore.runtime.jsf.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.kore.runtime.person.Birthday;

/**
 * Konvertiert unter Benutzung der default lokale und deren default format
 *
 * @author Konrad Renner
 */
@FacesConverter(value = "BirthdayConverter")
public class BirthdayConverter implements Converter {

    @Override
    public Birthday getAsObject(FacesContext fc, UIComponent uic, String string) {
        return getAsObject(fc, uic, string, DateFormat.getDateInstance());
    }

    public Birthday getAsObject(FacesContext fc, UIComponent uic, String string, DateFormat dateTimeInstance) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }
        try {
            return new Birthday(dateTimeInstance.parse(string.trim()));
        } catch (ParseException ex) {
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        
        return getAsString(fc, uic, o, DateFormat.getDateInstance());
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object o, DateFormat dateTimeInstance) {
        if (o == null) {
            return null;
        }
        if (o instanceof Birthday) {
            Date value = ((Birthday) o).getValue();
            return dateTimeInstance.format(value);
        }
        throw new IllegalArgumentException("org.kore.runtime.person.Birthday");
    }

}
