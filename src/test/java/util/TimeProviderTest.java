package util;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("util")
class TimeProviderTest {

    /*
    *   Le test suivant vérifie que la méthode currentYearValue retourne bien l'année actuelle
     */
    @Test
    void testCurrentYearValue() {
        assertThat(TimeProvider.currentYearValue()).isEqualTo(2024);
    }

}