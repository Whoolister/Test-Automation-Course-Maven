package seventh_solvd_assignment;

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
		LOG.setupLogger();
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

		LOG.info("File operations with Apache's FileUtils" + System.lineSeparator()
				+ "========================================");

		LOG.info("End of FileUtils demonstration and program" + System.lineSeparator()
				+ "========================================");
		LOG.info("Turning a massive number into it's equivalent in bytes: "
				+ FileUtils.byteCountToDisplaySize(987654321098765432L));
	}
}
