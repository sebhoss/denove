package com.github.sebhoss.denove.io.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.jdom2.Attribute;
import org.jdom2.Element;
import org.junit.Test;

/**
 * Tests for {@link Attributes}.
 */
@SuppressWarnings({ "static-method", "nls" })
public class AttributesTest {

    /**
     * Test for {@link Attributes#getValue(Element, String)}.
     * <p>
     * Ensures that the actual attribute value is returned.
     */
    @Test
    public void shouldReturnAttributeValue() {
        // given
        final Element element = mock(Element.class);
        final String attributeName = "test";
        final String attributeValue = "value";

        // when
        when(element.getAttribute(attributeName)).thenReturn(mock(Attribute.class));
        when(element.getAttributeValue(attributeName)).thenReturn(attributeValue);
        final String value = Attributes.getValue(element, attributeName);

        // then
        assertThat(value, equalTo(attributeValue));
    }

}
