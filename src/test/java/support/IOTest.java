package support;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public abstract class IOTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
    }

    /**
     * Mocks console input with [input] and returns the result of executing [supplier].
     */
    protected final <T> T run(String input, Supplier<T> supplier) {
        try {
            command(input);
            return supplier.get();
        } finally {
            System.setOut(standardOut);
            Console.close();
        }
    }

    /**
     * Mocks console input with [input] and check expected exceptions.
     */
    protected final <T> void runException(String input, Supplier<T> supplier) {
        try {
            run(input, supplier);
        } catch (final NoSuchElementException ignore) {
        }
    }

    /**
     * Executes the given [runnable] and returns the captured console output.
     */
    protected final String run(Runnable runnable) {
        try {
            runnable.run();
            return captor.toString().trim();
        } finally {
            System.setOut(standardOut);
        }
    }

    private void command(final String input) {
        final byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}