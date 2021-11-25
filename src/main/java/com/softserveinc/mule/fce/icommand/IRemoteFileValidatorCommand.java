package com.softserveinc.mule.fce.icommand;

import java.io.IOException;

import org.mule.runtime.extension.api.annotation.param.Config;

import com.softserveinc.mule.fce.FCEConfiguration;

public interface IRemoteFileValidatorCommand {
	String remoteFileValidateOperation(@Config FCEConfiguration config, boolean isConfig, String host, int port, 
			String username, String password, String remoteAbsolutePath, String fileName) throws IOException;
}
