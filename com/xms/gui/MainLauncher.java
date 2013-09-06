package com.xms.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.mihalis.opal.launcher.Launcher;
import org.mihalis.opal.opalDialog.Dialog;

public class MainLauncher {
	public MainLauncher(String shellTitle) {
		final Display display = new Display();
        final Shell shell = new Shell(display);
        
        shell.setLayout(new GridLayout(1, false));
        shell.setText(shellTitle);
 /*
        final Label title = new Label(shell, SWT.NONE);
        title.setText("Launcher");
        title.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
*/
        final Launcher l = new Launcher(shell, SWT.NONE);
        l.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
        l.addItem("Address Book", "resources/Address.jpg");
		l.addItem("Calendar", "resources/Calendar.jpg");
		l.addItem("Presentation", "resources/Presentation.jpg");
		l.addItem("Spreadsheet", "resources/Spreadsheet.jpg");
		l.addItem("Spreadsheet", "resources/bg.jpg");
		l.addItem("Spreadsheet", "resources/log.jpg");

        l.addSelectionListener(new SelectionAdapter() {

                /**
                 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
                 */
                @Override
                public void widgetSelected(final SelectionEvent e) {
                        Dialog.inform("Selection", "You have selected item #" + l.getSelection());
                }

        });

        final Label under = new Label(shell, SWT.NONE);
        under.setText("Double-click an icon to launch the program");
        under.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));

        shell.setMaximized(true);
        shell.open();

        while (!shell.isDisposed()) {
                if (!display.readAndDispatch()) {
                        display.sleep();
                }
        }
        display.dispose();
	}
}
