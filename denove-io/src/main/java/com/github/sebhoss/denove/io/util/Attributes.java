package com.github.sebhoss.denove.io.util;

import org.jdom2.Attribute;
import org.jdom2.Element;

/**
 * Utility class for JDOM {@link Attribute}s.
 */
public final class Attributes {

    /**
     * @param element
     *            The relevant element.
     * @param attributeName
     *            The name of the interested attribute
     * @return The value of the elements attribute or an empty String.
     */
    public static String getValue(final Element element, final String attributeName) {
        if (element.getAttribute(attributeName) != null) {
            return element.getAttributeValue(attributeName);
        }

        return ""; //$NON-NLS-1$
    }

}
