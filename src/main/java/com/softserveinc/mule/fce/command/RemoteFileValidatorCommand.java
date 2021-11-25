package com.softserveinc.mule.fce.command;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import com.softserveinc.mule.fce.icommand.IRemoteFileValidatorCommand;

public class RemoteFileValidatorCommand implements IRemoteFileValidatorCommand {
	private static FTPClient ftpClient = new FTPClient();
	private static FTPFile remoteFile;
	private static String output = "";
	
	@Override
	public String remoteFileValidateOperation(String host, int port, String username, String password, String remoteAbsolutePath, String fileName) throws IOException {
		ftpClient.connect(host, port);
		ftpClient.login(username, password);
		if (remoteAbsolutePath.endsWith("/")) {
			remoteFile = ftpClient.mlistFile(remoteAbsolutePath + fileName);
		} else {
			remoteFile = ftpClient.mlistFile(remoteAbsolutePath + "/" + fileName);
		}
		if (remoteFile != null) {
			output = "File " + remoteFile.getName() + " exists!";
		} else {
			output = "File " + remoteAbsolutePath + fileName + " does not exists";
		}

		ftpClient.disconnect();
		return output;
	}

}
