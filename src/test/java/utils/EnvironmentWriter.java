package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public final class EnvironmentWriter {
    private EnvironmentWriter() {
    }

    public static void write(String browser) {
        Path directory = Path.of("target", "allure-results");
        String content = String.join(System.lineSeparator(),
                "os.name=" + System.getProperty("os.name"),
                "os.version=" + System.getProperty("os.version"),
                "jdk.version=" + System.getProperty("java.version"),
                "selenium=4.22.0", "testng=7.10.2", "browser=" + browser,
                "driver.manager=Selenium Manager");
        try {
            Files.createDirectories(directory);
            Files.writeString(directory.resolve("environment.properties"), content, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new IllegalStateException("Не удалось создать environment.properties", exception);
        }
    }
}