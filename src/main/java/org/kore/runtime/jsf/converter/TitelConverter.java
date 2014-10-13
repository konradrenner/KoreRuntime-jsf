/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kore.runtime.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.kore.runtime.person.Titel;

/**
 *
 * @author Konrad Renner
 */
@FacesConverter(value = "CurrencyConverter")
public class TitelConverter implements Converter {

    @Override
    public Titel getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }
        return new Titel(string.trim());
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }
        if (o instanceof Titel) {
            return ((Titel) o).getValue();
        }
        throw new IllegalArgumentException("Given object is not a org.kore.runtime.person.Titel");
    }

}
