package test1;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import ru.zubrilovskaya.different.reflection.DefaultValues;
import ru.zubrilovskaya.different.reflection.ResetClass;

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
    @DisplayName("аннотация @Default на уровне поля  String st")
    public void testWithFieldAnnotation1() {
        ResetClass.reset(b);

        assertEquals("hello", b.st);
    }

    @Test
    @DisplayName("аннотация @Default на уровне поля int y")
    public void testWithFieldAnnotation2() {
        ResetClass.reset(b);

        assertEquals(42, b.y);
    }
    @Test
    @DisplayName("отсутствие аннотации @Default на уровне поля int x")
    public void testWithFieldAnnotation3() {
        ResetClass.reset(b);

        assertNotEquals(42, b.x);
    }

    @Test
    @DisplayName("без аннотаций на уровне приватного поля int x")
    public void testWithoutAnnotations1() {
        ResetClass.reset(c);

        assertNotEquals(42, c.getX());
    }
    @Test
    @DisplayName("без аннотаций на уровне приватного поля String st")
    public void testWithoutAnnotations2() {
        ResetClass.reset(c);

        assertNotEquals("hello", c.getSt());
    }
    @Test
    @DisplayName("без аннотаций на уровне приватного поля int y")
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
        assertNotEquals(42, b.x);
    }

}
