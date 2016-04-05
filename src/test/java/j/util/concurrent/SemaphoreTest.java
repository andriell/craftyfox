package j.util.concurrent;

import org.junit.Test;

import java.util.concurrent.Semaphore;
import static org.junit.Assert.assertEquals;

/**
 * Created by Rybalko on 05.04.2016.
 */
public class SemaphoreTest {
    private final Semaphore semaphore = new Semaphore(3, true);

    public static void main(String[] args) {
        SemaphoreTest test = new SemaphoreTest();
        test.test1();
    }

    @Test
    public void test1() {
        assertEquals(true, semaphore.tryAcquire());
        assertEquals(true, semaphore.tryAcquire());
        assertEquals(true, semaphore.tryAcquire());
        assertEquals(false, semaphore.tryAcquire());
        semaphore.release();
        assertEquals(true, semaphore.tryAcquire());
        assertEquals(false, semaphore.tryAcquire());
    }
}
