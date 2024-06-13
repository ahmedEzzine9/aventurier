package com.ahmed.aventurier.reader;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.ahmed.aventurier.main.model.Aventurier;
import com.ahmed.aventurier.main.reader.InputReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InputReaderTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void testReadAventurierFromFile() throws IOException {
        // prepare
        File testFile = tempFolder.newFile("testAventurier.txt");
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("5,10\n");
            writer.write("ENOS\n");
        }

        InputReader inputReader = new InputReader();
        // get aventurier
        Aventurier aventurier = inputReader.readAventurierFromFile(testFile.getAbsolutePath());
        // Assert
        assertEquals(5, aventurier.getX());
        assertEquals(10, aventurier.getY());
        assertEquals(Arrays.asList("E", "N", "O", "S"), aventurier.getMoves());
    }

    @Test
    public void testReadAventurierFromFile_FileNotFound() {
        // prepare
        InputReader inputReader = new InputReader();
        String invalidFilePath = "invalid/path/File.txt";
        // get aventurier
        Aventurier aventurier = inputReader.readAventurierFromFile(invalidFilePath);
        // Assert
        assertEquals(0, aventurier.getX());
        assertEquals(0, aventurier.getY());
        assertTrue(aventurier.getMoves() == null || aventurier.getMoves().isEmpty());
    }
}
