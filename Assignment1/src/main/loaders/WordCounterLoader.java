package main.loaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class WordCounterLoader extends ClassLoader {
    public static final String pathToDir = "out/production/assignment1/main/";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try{
            byte[] b = fetchClassFromFS(name);
            return defineClass(name, b, 0, b.length);
        }
        catch (IOException e){
            return super.findClass(name);
        }
    }

    private byte[] fetchClassFromFS(String name) throws IOException {
        File classFile = new File(pathToDir + name.replaceAll(".", "/") + ".class");
        InputStream is = new FileInputStream(classFile);

        long length = classFile.length();

        if (length > Integer.MAX_VALUE) {
            throw new IOException("File is too large");
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }
        if (is.read(bytes) != bytes.length) {
            throw new IOException("Could not completely read file " + pathToDir);
        }

        is.close();
        return bytes;
    }
}
