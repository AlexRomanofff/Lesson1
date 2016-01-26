package Lesson10.Reflections.frame4.Frame5;

import Lesson10.Reflections.Frame5.InitFields;
import Lesson10.Reflections.Frame5.TV;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class InitFieldTest {
    private TV tv;
    private InitFields<TV> initFields;
    private Map<String, Object> params;
    private String fieldName;

    @Before
    public void init() {
        tv = new TV();
        initFields = new InitFields<>();
       params= new HashMap<>();

    }
    @Test
    public void checkHeightWithEmptyMap () throws Exception{
        initFields.setPrivates(tv, params);
        assertEquals(0, tv.getHeight());
    }
    @Test
    public void checkWeightWithEmptyMap () throws Exception{
        initFields.setPrivates(tv, params);
        assertEquals(0, tv.getWidth());
    }
    @Test
    public void checkBrandWithEmptyMap () throws Exception{
        initFields.setPrivates(tv, params);
        assertNull(tv.getBrand());
    }
    @Test(expected = NoSuchFieldException.class)
    public void checkWrongFieldName () throws Exception {
        fieldName = "weidth";
        params.put(fieldName, 100);
        initFields.setPrivates(tv, params);
    }
    @Test
    public void checkSetHeigthField () throws Exception {
        fieldName = "height";
        params.put(fieldName, 100);
        initFields.setPrivates(tv, params);
        assertSame(100, tv.getHeight());
    }
    @Test
    public void checkSetWeigthField () throws Exception {
        fieldName = "width";
        params.put(fieldName, 100);
        initFields.setPrivates(tv, params);
        assertSame(100, tv.getHeight());
    }
    @Test
    public void checkSetBrandField () throws Exception {
        fieldName = "brand";
        params.put(fieldName, "Sony");
        initFields.setPrivates(tv, params);
        assertSame("Sony", tv.getBrand());
    }
}
