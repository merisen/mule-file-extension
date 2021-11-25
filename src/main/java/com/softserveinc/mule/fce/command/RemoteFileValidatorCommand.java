package com.softserveinc.mule.fce.command;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import com.softserveinc.mule.fce.FCEConfiguration;
import com.softserveinc.mule.fce.icommand.IRemoteFileValidatorCommand;

import org.mule.runtime.extension.api.annotation.param.Config;

public class RemoteFileValidatorCommand implements IRemoteFileValidatorCommand {
	private static final FTPClient ftpClient = new FTPClient();
	private static FTPFile remoteFile;
	private static String path = new String();

	@Override
	public String remoteFileValidateOperation(@Config FCEConfiguration config, boolean isConfig, String host, int port, 
			String username, String password, String remoteAbsolutePath, String fileName) throws IOException {
		if (!isConfig) {
			ftpClient.connect(host, port);
			ftpClient.login(username, password);
			path = remoteAbsolutePath;
		} else {
			ftpClient.connect(config.ftpName, config.ftpPort);
			ftpClient.login(config.ftpUser, config.ftpPassword);
			path = config.ftpWorkingDir;
		}
		
		remoteFile = path.endsWith("/") ? ftpClient.mlistFile(path + fileName) : ftpClient.mlistFile(path + "/" + fileName);
		
		String output = remoteFile != null ? "File " + remoteFile.getName() + " exists!" : "File " + path + fileName + " does not exists!";

		ftpClient.disconnect();
		return output;
	}
}
