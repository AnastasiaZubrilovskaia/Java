package test2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import ru.zubrilovskaya.different.reflection.Entity;


public class EntityTest {

    private Entity y;
    private BEntity b;
    class TestEntity extends Entity{
        private int privateField;
        public int publicField;
        int protectetedField;
    }

    @BeforeEach
    public void setUp() {
         b=new BEntity(12,3,5);
    }

    @Test
    public void classNameTest(){
        TestEntity testEntity = new TestEntity();
        String res = testEntity.toString();
        Assertions.assertTrue(res.startsWith("TestEntity"),  "expected" + res.getClass().getSimpleName() + "actual" + res);
    }

    @Test
    public void fieldAndValuesTest(){
        TestEntity testEntity = new TestEntity();
        String res = testEntity.toString();
        Assertions.assertTrue(res.contains("publicField=0"));

    }


}
