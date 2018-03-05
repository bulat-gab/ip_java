package com.company.baseSample.utils;

import java.lang.reflect.Field;

public class ReflectionSetter {
    public static void setFieldValue(Object newValue,
                              Object container,
                              String fieldName,
                              Class containerClass){
        try {
            Field field = containerClass.getDeclaredField(fieldName);

            boolean isAccesible = field.isAccessible();
            if(!isAccesible){
                field.setAccessible(true);
            }

            field.set(container,newValue);

            if(!isAccesible){
                field.setAccessible(false);
            }
        } catch (NoSuchFieldException e) {
            if(containerClass.getSuperclass() != null) {
                setFieldValue(newValue,
                        container,
                        fieldName,
                        containerClass.getSuperclass());
            } else
                e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Object getFieldValue(Object container,
                                       String fieldName,
                                       Class containerClass){
        Object value= null;

        try {
            Field field = containerClass.getDeclaredField(fieldName);

            boolean isAccesible = field.isAccessible();
            if(!isAccesible){
                field.setAccessible(true);
            }

            value = field.get(container);

            if(!isAccesible){
                field.setAccessible(false);
            }
        } catch (NoSuchFieldException e) {
            if(containerClass.getSuperclass() != null) {
                value = getFieldValue(container,
                                      fieldName,
                                      containerClass.getSuperclass());
            } else
                e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return value;
    }
}
