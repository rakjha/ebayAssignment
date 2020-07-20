package com.app.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.log4j.Logger;

public class LogDeletion {
	private static final Logger LOG = Logger.getLogger(LogDeletion.class);

	public void deletePrevLogs() throws IOException {
		Properties logFields = new Properties();
		FileInputStream fs = new FileInputStream("src/main/resources/log4j.properties");
		logFields.load(fs);
		File[] listOfFiles = new File(System.getProperty("user.dir") + "//logs/").listFiles();
		int maxBackupsAllowed = Integer.parseInt(logFields.getProperty("log4j.appender.dest1.maxBackupIndex"));
		if (listOfFiles.length >= maxBackupsAllowed) {
			for (int i = 1; i <= listOfFiles.length - maxBackupsAllowed; i++) {
				if (listOfFiles[i].toString().contains("debugpoints")) {
					Files.delete(Paths.get(listOfFiles[i].toString()));
					LOG.debug("deleted file");
				}
			}
		}
	}
}
