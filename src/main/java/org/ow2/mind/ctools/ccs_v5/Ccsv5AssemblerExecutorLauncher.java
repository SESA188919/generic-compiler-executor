package org.ow2.mind.ctools.ccs_v5;

import org.ow2.mind.ctools.AssemblerExecutorLauncher;
import org.ow2.mind.ctools.ccs.CcsAssemblerExecutor;

public class Ccsv5AssemblerExecutorLauncher {
	public static void main(String[] args) {
		AssemblerExecutorLauncher launch = new AssemblerExecutorLauncher();
		launch.executor = new Ccsv5AssemblerExecutor();
		launch.run(args);
	}
}
