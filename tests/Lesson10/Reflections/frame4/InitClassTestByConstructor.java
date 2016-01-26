package Lesson10.Reflections.frame4;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InitClassTestByConstructor {
    InitConstruktor <TV> initConstruktor;
    Class clas;
    List<Object> params;

    @Before
    public void init () {
         initConstruktor = new InitConstruktor();
         clas = TV.class;
         params = new ArrayList<>();
    }

    @Test
    public void checkLengthArrayClass () {
         params.add(new Object());
         Class []classes = new Class [params.size()];
         assertSame(classes.length, params.size());
    }
    @Test
    public void checkIntegerType () {
        params.add(10);
        Class []classes = new Class [params.size()];
        classes[0] = Integer.TYPE;
        assertEquals("int", classes[0].getName());

    }
    @Test
    public void checkLongType () {
        params.add(10L);
        Class []classes = new Class [params.size()];
        classes[0] = Long.TYPE;
        assertEquals("long", classes[0].getName());

    }
    @Test
    public void checkDoubleType () {
        params.add(10.0);
        Class []classes = new Class [params.size()];
        classes[0] = Double.TYPE;
        assertEquals("double", classes[0].getName());

    }
    @Test
    public void checkReturningType () throws Exception{
        Object newInstance = initConstruktor.initClass(clas, params);
        assertEquals(clas, newInstance.getClass());
    }
    @Test
    public void checkDefaultHeightWithEmptyConstructor () throws Exception {
        TV newInstance = initConstruktor.initClass(clas, params);
        assertSame(0, newInstance.getHeight());
    }
    @Test
    public void checkDefaultWeightWithEmptyConstructor () throws Exception {
        TV newInstance = initConstruktor.initClass(clas, params);
        assertSame(0, newInstance.getWeight());
    }
    @Test
    public void checkDefaultBrandWithEmptyConstructor () throws Exception {
        TV newInstance = initConstruktor.initClass(clas, params);
        assertNull(newInstance.getManufacturer());
    }
    @Test(expected = NoSuchMethodException.class)
     public void checkIleegalDataForConstructor () throws Exception{
        params.add(100L);
        initConstruktor.initClass(clas,params);
    }
    @Test
    public void checkSetHeight () throws Exception {
        int height = 100;
        int weight = 200;
        String manufacturer = "Sony";
        params.add(weight);
        params.add(height);
        params.add(manufacturer);
        TV newInstance = initConstruktor.initClass(clas, params);
        assertSame(height, newInstance.getHeight());
    }
    @Test
    public void checkSetManufacturer () throws Exception {
        int height = 100;
        int weight = 150;
        String manufacturer = "Sony";
        params.add(weight);
        params.add(height);
        params.add(manufacturer);
        TV newInstance = initConstruktor.initClass(clas, params);
        assertEquals(manufacturer, newInstance.getManufacturer());
    }
}
