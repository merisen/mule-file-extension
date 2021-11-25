package com.softserveinc.mule.fce.icommand;

import java.io.IOException;

public interface IRemoteFileValidatorCommand {
	String remoteFileValidateOperation(String host, int port, String username, String password, 
			String remoteAbsolutePath, String fileName) throws IOException;
}
