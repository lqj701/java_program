package dynamic_technology.program_logic.chapter24;

import java.io.IOException;

import io.program_logic.chapter13.BinaryFileUtils;

public class MyClassLoader extends ClassLoader {
    private static final String BASE_DIR = "D:/study/java_program/out/production/java_program/";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = name.replaceAll("\\.", "/");
        fileName = BASE_DIR + fileName + ".class";
        try {
            byte[] bytes = BinaryFileUtils.readFileToByteArray(fileName);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException ex) {
            throw new ClassNotFoundException("failed to load class " + name, ex);
        }
    }
}
