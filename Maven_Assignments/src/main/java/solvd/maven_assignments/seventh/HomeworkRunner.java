package solvd.maven_assignments.seventh;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import solvd.maven_assignments.seventh.utilities.MyLogger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.regex.Pattern;

public class HomeworkRunner {
    static final MyLogger LOG = new MyLogger(HomeworkRunner.class.getName());

    public static void main(String[] args) {
        String sample = "El Tatio is a geothermal field with many geysers located in the Andes of northern Chile at 4,320 metres (14,170 ft)"
                + " above sea level. It is the third-largest geyser field in the world and the largest in the Southern Hemisphere. The geothermal"
                + " field has many geysers, hot springs, and associated sinter deposits. The vents are sites of populations of extremophile"
                + " microorganisms such as hyperthermophiles, and have been studied as an analogue for the early Earth and possible past life"
                + " on Mars. El Tatio lies at the western foot of a series of stratovolcanoes, part of the Central Volcanic Zone and the"
                + " Altiplano–Puna volcanic complex, which may be the source of heat for El Tatio. There are no recorded eruptions of the"
                + " Tatio volcanoes. The field is a major tourism destination. It has been prospected for geothermal power production, but"
                + " development ceased after a major incident in 2009 when a drilling well blew out.";

        File sampleFile = new File("testFolder/testing.txt");

        LOG.setupLogger();
        try {
            FileUtils.forceMkdirParent(sampleFile);
            if (sampleFile.createNewFile()) {
                FileUtils.writeStringToFile(sampleFile, sample, StandardCharsets.UTF_8);
            } else {
                LOG.severe("FILE WAS NOT CREATED, PROGRAM WILL FAIL");
            }
            LOG.info("Reading from testing.txt, determining the amount of unique words and writing it in the file:"
                    + System.lineSeparator() + "========================================");

            HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(StringUtils.split(
                    RegExUtils.removeAll(FileUtils.readFileToString(sampleFile, StandardCharsets.UTF_8).toLowerCase(),
                            Pattern.compile("[^a-z ]")))));
            LOG.info("Amount of unique words: " + uniqueWords.size());
            FileUtils.writeStringToFile(sampleFile, Integer.toString(uniqueWords.size()), StandardCharsets.UTF_8, true);

            LOG.info("End of the first task, one of the FileUtils calls confirms the word count is there"
                    + System.lineSeparator() + "========================================");
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Rest in Ripperoni", e);
        }

        LOG.info("Basic String operations with Apache's StringUtils" + System.lineSeparator()
                + "========================================");
        LOG.info("Initial Text: " + sample);
        LOG.info("Abbreviated to 100 characters: " + StringUtils.abbreviate(sample, 100));
        LOG.info("Rotated by 23 characters: " + StringUtils.rotate(sample, 23));
        LOG.info("30 characters, a distance of 16 characters away from the beggining, all in Capital Letters: "
                + StringUtils.capitalize(StringUtils.abbreviate(sample, 16, 30)));
        LOG.info("The last 15 characters, with cases swapped: " + StringUtils.swapCase(StringUtils.right(sample, 15)));
        LOG.info("25 characters from the middle of the sample, without any 'e's: "
                + StringUtils.remove(StringUtils.mid(sample, sample.length() / 2, 0), 'e'));
        LOG.info("End of StringUtils demonstration" + System.lineSeparator()
                + "========================================");
        try {
            LOG.info("File operations with Apache's FileUtils" + System.lineSeparator()
                    + "========================================");
            LOG.info("Turning a massive number into it's equivalent in bytes: "
                    + FileUtils.byteCountToDisplaySize(987654321098765432L));
            LOG.info("Calling this User's main directory path: " + FileUtils.getUserDirectoryPath());
            LOG.info("Checking to see if the 'testFolder' directory is empty or not: "
                    + FileUtils.isEmptyDirectory(new File(sampleFile.getParent())));
            LOG.info("Reading a file's content: " + FileUtils.readFileToString(sampleFile, StandardCharsets.UTF_8));
            LOG.info("File size: " + FileUtils.sizeOf(sampleFile));
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Rest in Ripperoni", e);
        }
        sampleFile.deleteOnExit();
        LOG.info("End of FileUtils demonstration and program" + System.lineSeparator()
                + "========================================");

    }
}
