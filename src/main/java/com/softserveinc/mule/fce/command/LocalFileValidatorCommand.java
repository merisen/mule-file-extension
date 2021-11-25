package com.softserveinc.mule.fce.command;

import java.io.File;

import com.softserveinc.mule.fce.icommand.ILocalFileValidatorCommand;

public class LocalFileValidatorCommand implements ILocalFileValidatorCommand {
	private static File file;
	private static String output = "";
	
	@Override
	public String localFileValidateOperation(String localAbsolutePath, String fileName) {
		try {
			file = localAbsolutePath.endsWith("\\") ? new File(localAbsolutePath + fileName) : new File(localAbsolutePath + "\\" + fileName);
			boolean exists = file.exists();
			output = file.isDirectory() ? fileName + " is a directory! Please try again." : "File: " + fileName + " | " + "Exist: " + String.valueOf(exists);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

}
