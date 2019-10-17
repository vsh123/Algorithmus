package kakao;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CompileTest {
    @Test
    void name() {
        Compile compile = new Compile();

        assertThat(compile.solution("()))((()")).isEqualTo("()");
    }
}