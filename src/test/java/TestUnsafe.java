import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestUnsafe {



    @Test
    void testUnsafe() throws NoSuchFieldException, IllegalAccessException {
        long SUPER_SIZE = (long) Integer.MAX_VALUE * 2;
        OffHeapArray array = new OffHeapArray(SUPER_SIZE);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            array.set((long) Integer.MAX_VALUE + i, (byte) 3);
            sum += array.get((long) Integer.MAX_VALUE + i);
        }

        assertEquals(array.size(), SUPER_SIZE);
        assertEquals(sum, 300);
    }




}
