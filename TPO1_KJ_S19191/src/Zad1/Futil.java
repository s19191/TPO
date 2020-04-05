package Zad1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Futil {
    static void processDir(String dirName, String resultFileName) {
        try {
            Files.deleteIfExists(Paths.get(resultFileName));
            FileChannel fcout = FileChannel.open(Files.createFile(Paths.get(resultFileName)), StandardOpenOption.WRITE);
            Files.walkFileTree(Paths.get(dirName), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    FileChannel fcin = FileChannel.open(file, StandardOpenOption.READ);
                    ByteBuffer byteBuffer = ByteBuffer.allocate((int)fcin.size());
                    fcin.read(byteBuffer);
                    byteBuffer.flip();
                    CharBuffer charBuffer = Charset.forName("Cp1250").decode(byteBuffer);
                    byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
                    fcout.write(byteBuffer);
                    fcin.close();
                    return FileVisitResult.CONTINUE;
                }
            });
            fcout.close();
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }
}