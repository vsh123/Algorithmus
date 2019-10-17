package kakao;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ZipTest {

    @Test
    void name() {
        Zip zip = new Zip();

        assertThat(zip.solution("abcabcdede")).isEqualTo(8);
    }
}