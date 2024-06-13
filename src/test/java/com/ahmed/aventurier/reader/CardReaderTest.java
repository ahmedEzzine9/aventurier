package com.ahmed.aventurier.reader;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.ahmed.aventurier.main.model.Card;
import com.ahmed.aventurier.main.reader.CardReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardReaderTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void testReadCardFromFile() throws IOException {
        // Arrange
        File testFile = tempFolder.newFile("testCard.txt");
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("#  #\n");
            writer.write("## #\n");
            writer.write("####\n");
        }

        CardReader cardReader = new CardReader();

        // Act
        Card card = cardReader.readCardFromFile(testFile.getAbsolutePath());

        // Assert
        assertEquals(3, card.getCardAsList().size());
        assertEquals(Arrays.asList("#", " ", " ", "#"), card.getCardAsList().get(0));
        assertEquals(Arrays.asList("#", "#", " ", "#"), card.getCardAsList().get(1));
        assertEquals(Arrays.asList("#", "#", "#", "#"), card.getCardAsList().get(2));
    }

    @Test
    public void testReadCardFromFileFileNotFound() {
        // Arrange
        CardReader cardReader = new CardReader();
        String invalidFilePath = "invalid/path/to/nonexistentFile.txt";

        // Act
        Card card = cardReader.readCardFromFile(invalidFilePath);

        // Assert
        assertTrue(card.getCardAsList().isEmpty());
    }
}
