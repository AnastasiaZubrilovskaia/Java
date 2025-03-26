package test2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import ru.zubrilovskaya.different.reflection.Entity;


public class EntityTest {

    private Entity y;
    private BEntity b;
    class TestEntity extends Entity{
        private int privateField;
        public int publicField=12;
        int protectetedField;
    }

    @BeforeEach
    public void setUp() {
         b=new BEntity(12,3,5);
    }

    @Test
    @DisplayName("есть ли имя в начале toString")
    public void classNameTest(){
        TestEntity testEntity = new TestEntity();
        String res = testEntity.toString();
        Assertions.assertTrue(res.startsWith("TestEntity"),  "expected " + res.getClass().getSimpleName() + " actual " + res);
    }

    @Test
    @DisplayName("Наличие поле=значение")
    public void fieldAndValuesTest(){
        TestEntity testEntity = new TestEntity();
        String res = testEntity.toString();
        Assertions.assertTrue(res.contains("publicField=12"),  "expected " + " publicField=12 " + " actual " + testEntity.publicField);
    }
    @Test
    @DisplayName("С модификатором private")
    public void privateFieldTest(){
        TestEntity testEntity = new TestEntity();
        String res = testEntity.toString();
        Assertions.assertTrue(res.contains("privateField"),  "expected " + " privateField=... " + " actual " + "not found");
    }


}
