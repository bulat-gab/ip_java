package com.company.baseSample.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionPrinter {

    public static void printClass(Class cls){
        System.out.println();
        System.out.println(cls.getName());

        printConstructors(cls);

        printFields(cls);
        printDeclaredFields(cls);

        System.out.println("Printing methods");

        for (Method method:
                cls.getMethods()) {
            System.out.print(method.getName() + " ");
            System.out.print(method.getReturnType().getName() + " ");

            for (Class paramClass:
                    method.getParameterTypes()) {
                System.out.print(paramClass.getCanonicalName() + " ");
            }

            System.out.println();
        }

        System.out.println("Printing declared methods");

        for (Method method:
                cls.getDeclaredMethods()) {
            System.out.print(method.getName() + " ");
            System.out.print(method.getReturnType().getName() + " ");

            for (Class paramClass:
                    method.getParameterTypes()) {
                System.out.print(paramClass.getCanonicalName() + " ");
            }
            System.out.println();
        }
    }

    private static void printDeclaredFields(Class cls) {
        System.out.println("Printing declared fields");

        for (Field field:
                cls.getDeclaredFields()) {
            System.out.print(field.getName() + " ");
            System.out.print(field.getType().getName() + " ");
            System.out.print(field.getModifiers() + " ");
            System.out.println();
        }
    }

    private static void printFields(Class cls) {
        System.out.println("Printing fields");

        for (Field field:
             cls.getFields()) {
            System.out.print(field.getName() + " ");
            System.out.print(field.getType().getName() + " ");
            System.out.print(field.getModifiers() + " ");
            System.out.println();
        }
    }

    private static void printConstructors(Class cls) {
        System.out.println("Printing constructors");

        for (Constructor constructor:
             cls.getConstructors()) {
            System.out.println(constructor.getName());
            System.out.println(constructor.getModifiers());

            for (Class paramClass:
                 constructor.getParameterTypes()) {
                System.out.println(paramClass.getCanonicalName());
            }
        }
    }
}
