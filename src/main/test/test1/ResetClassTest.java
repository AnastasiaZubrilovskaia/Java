package test1;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import ru.zubrilovskaya.different.reflection.DefaultValues;
import ru.zubrilovskaya.different.reflection.ResetClass;
import ru.zubrilovskaya.different.reflection.forTests.AReset;
import ru.zubrilovskaya.different.reflection.forTests.BReset;
import ru.zubrilovskaya.different.reflection.forTests.CReset;

import static org.junit.jupiter.api.Assertions.*;

public class ResetClassTest {
    private final AReset a = new AReset();
    private final BReset b = new BReset();
    private final CReset c = new CReset();

    @BeforeEach
    public void setUp() {
        ResetClass.defaultValues = new DefaultValues.BuilderDefault()
                .setInt(42)
                .setString("hello")
                .setBoolean(true)
                .build();
    }
    @Test
    @DisplayName("аннотаци @Default на уровне класса")
    public void testWithClassAnnotation() {
        ResetClass.reset(a);

        assertEquals(42, a.getX());
        assertEquals("hello", a.getSt());
        assertEquals(42, a.getY());
    }

    @Test
    @DisplayName("аннотация @Default на уровне поля 1")
    public void testWithFieldAnnotation1() {
        ResetClass.reset(b);

        assertEquals("hello", b.st);
    }

    @Test
    @DisplayName("аннотация @Default на уровне поля 2")
    public void testWithFieldAnnotation2() {
        ResetClass.reset(b);

        assertEquals(42, b.y);
    }
    @Test
    @DisplayName("аннотация @Default на уровне поля 3")
    public void testWithFieldAnnotation3() {
        ResetClass.reset(b);

        assertNotEquals(42, b.x);
    }

    @Test
    @DisplayName("без аннотаций 1")
    public void testWithoutAnnotations1() {
        ResetClass.reset(c);

        assertNotEquals(42, c.getX());
    }
    @Test
    @DisplayName("без аннотаций 2")
    public void testWithoutAnnotations2() {
        ResetClass.reset(c);

        assertNotEquals("hello", c.getSt());
    }
    @Test
    @DisplayName("без аннотаций 3")
    public void testWithoutAnnotations3() {
        ResetClass.reset(c);

        assertNotEquals(42, c.getY());
    }
    @Test
    @DisplayName("несколько объектов")
    public void testWithSeveralClasses() {
        ResetClass.reset(a,b);

        assertEquals(42, a.getX());
        assertEquals("hello", a.getSt());
        assertEquals("hello", b.st);
        assertEquals(42, b.y);
    }

}
