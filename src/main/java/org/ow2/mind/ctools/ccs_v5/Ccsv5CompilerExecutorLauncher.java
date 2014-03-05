package org.ow2.mind.ctools.ccs_v5;

import org.ow2.mind.ctools.CompilerExecutorLauncher;
import org.ow2.mind.ctools.ccs.CcsCompilerExecutor;

public class Ccsv5CompilerExecutorLauncher {
	public static void main(String[] args) {
		CompilerExecutorLauncher launch = new CompilerExecutorLauncher();
		launch.executor = new Ccsv5CompilerExecutor();
		launch.run(args);
	}
}
