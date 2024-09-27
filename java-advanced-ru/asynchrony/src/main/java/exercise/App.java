package exercise;

import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;
import java.nio.file.NoSuchFileException;
import java.util.concurrent.CompletionException;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String filePathString1,
                                    String filePathString2,
                                    String resultFilePathString) throws Exception, NoSuchFileException {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            Path filePath1 = Paths.get(filePathString1).toAbsolutePath().normalize();
            if (!Files.exists(filePath1)) {
                throw new CompletionException(new NoSuchFileException("File " + filePath1 + " does not exist."));
            }

            String content1 = "";
            try {
                content1 = Files.readString(filePath1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return content1;
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            Path filePath2 = Paths.get(filePathString2).toAbsolutePath().normalize();
            if (!Files.exists(filePath2)) {
                throw new CompletionException(new NoSuchFileException("File " + filePath2 + " does not exist."));
            }

            String content2 = "";
            try {
                content2 = Files.readString(filePath2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return content2;
        });

        CompletableFuture<String> futureWriteFile = future1.thenCombine(future2, (file1, file2) -> {
            String twoFilesContent = file1.concat(file2);
            Path resultFilePath = Paths.get(resultFilePathString).toAbsolutePath().normalize();
            Path destFilePath = resultFilePath;

            if (!Files.exists(resultFilePath)) {
                try {
                    destFilePath = Files.createFile(resultFilePath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                Files.write(destFilePath, twoFilesContent.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return twoFilesContent;
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });
        return futureWriteFile;
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        App.unionFiles("src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/result_file.txt");
        // END
    }
}
