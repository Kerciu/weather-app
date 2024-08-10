package test.java.GuiTests;

import main.java.frontend.utility.CountryImageResolver;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CountryResolverTest {
    @Test
    public void testGetCountryImagePathForExistingCountry() {
        assertEquals("assets/images/countries/poland.png", CountryImageResolver.getCountryImagePath("Poland"));
        assertEquals("assets/images/countries/united-states.png", CountryImageResolver.getCountryImagePath("United States"));
        assertEquals("assets/images/countries/germany.png", CountryImageResolver.getCountryImagePath("Germany"));
        assertEquals("assets/images/countries/france.png", CountryImageResolver.getCountryImagePath("France"));
        assertEquals("assets/images/countries/italy.png", CountryImageResolver.getCountryImagePath("Italy"));
    }

    @Test
    public void testGetCountryImagePathForExistingCountryLowerCase() {
        assertEquals("assets/images/countries/japan.png", CountryImageResolver.getCountryImagePath("japan"));
        assertEquals("assets/images/countries/canada.png", CountryImageResolver.getCountryImagePath("canada"));
    }

    @Test
    public void testGetCountryImagePathForNonExistentCountry() {
        assertEquals("assets/images/utils/question-mark.png", CountryImageResolver.getCountryImagePath("Atlantis"));
        assertEquals("assets/images/utils/question-mark.png", CountryImageResolver.getCountryImagePath("Wakanda"));
    }

    @Test
    public void testGetCountryImagePathForEmptyString() {
        assertEquals("assets/images/utils/question-mark.png", CountryImageResolver.getCountryImagePath(""));
    }

    @Test
    public void testGetCountryImagePathForNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            CountryImageResolver.getCountryImagePath(null);
        });
    }
}
