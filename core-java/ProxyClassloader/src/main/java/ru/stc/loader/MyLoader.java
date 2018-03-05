package ru.stc.loader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class MyLoader extends ClassLoader {
    private static final String LIB_PATH = "C:\\STC\\STC-UN\\lab20170203-full\\target\\lab-2017-02-03-1.0.jar";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            JarFile jarLib = new JarFile(LIB_PATH);
            JarEntry jarEntry = jarLib.getJarEntry(
                    name.replace(".", "/") + ".class");
            InputStream libInputStream = jarLib.getInputStream(jarEntry);
            libInputStream = new FileInputStream("");

            byte[] classBytes = new byte[(int) jarEntry.getSize()];
            if (libInputStream.read(classBytes) != classBytes.length) {
                throw new IOException("No....");
            }

            return defineClass(name, classBytes, 0, classBytes.length);

        } catch (IOException e) {
            throw new ClassNotFoundException(e.getMessage(), e);
        }
    }
}
