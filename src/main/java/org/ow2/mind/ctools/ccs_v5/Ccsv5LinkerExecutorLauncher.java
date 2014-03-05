package org.ow2.mind.ctools.ccs_v5;

import org.ow2.mind.ctools.LinkerExecutorLauncher;
import org.ow2.mind.ctools.ccs.CcsLinkerExecutor;

public class Ccsv5LinkerExecutorLauncher {
	public static void main(String[] args) {
		LinkerExecutorLauncher launch = new LinkerExecutorLauncher();
		launch.executor = new Ccsv5LinkerExecutor();
		launch.run(args);
	}
}
