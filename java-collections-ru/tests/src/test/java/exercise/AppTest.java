package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class AppTest {
    List<Integer> list;

    @BeforeEach
    void prepare() {
        this.list = new ArrayList<>();
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
        this.list.add(4);
        this.list.add(5);
    }

    @Test
    void testTake() {
        // BEGIN
        List<Integer> expected1 = new ArrayList<>();
        expected1.add(1);
        expected1.add(2);
        List<Integer> actual1 = App.take(list, 2);
        assertThat(actual1).isEqualTo(expected1);

        List<Integer> expected2 = new ArrayList<>();
        List<Integer> actual2 = App.take(list, 0);
        assertThat(actual2).isEqualTo(expected2);
        // END
    }
}
