package seventh_solvd_assignment;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import seventh_solvd_assignment.utilities.MyLogger;

public class HomeworkRunner {
	static final MyLogger LOG = new MyLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main(String[] args) {
		String sample = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,"
				+ " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum"
				+ " dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		File sampleFile = new File("testFolder/testing.txt");

		LOG.setupLogger();
		try {
			FileUtils.forceMkdirParent(sampleFile);
			sampleFile.createNewFile();
			FileUtils.writeStringToFile(sampleFile, sample, StandardCharsets.UTF_8);

			LOG.info("Reading from testing.txt, determining the amount of unique words and writing it in the file:"
					+ System.lineSeparator() + "========================================");

			HashSet<String> uniqueWords = new HashSet<>(
					Arrays.asList(StringUtils.split(FileUtils.readFileToString(sampleFile, StandardCharsets.UTF_8))));
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
