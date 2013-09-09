package com.xms.gui;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.mihalis.opal.login.LoginDialog;
import org.mihalis.opal.login.LoginDialogVerifier;

/**
 * 用户界面类--管理员登录界面
 * 

 */
/**
 * @author ChenHao
 *
 */
public class Login {
	public Login(String title) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setMaximized(true);
		
		Button b = new Button(shell, SWT.CENTER);
		b.setSize(200, 100);		
		b.setImage(new Image(null, "resources/bg.jpg"));
				
		shell.setText(title);
		shell.setLayout(new FillLayout());
		shell.layout();
		shell.open();
		
		try {
			startLogin();
			display.dispose();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}

			new MainLauncher("MainLauncher");
		} catch (Exception e) {
			e.printStackTrace();
			display.dispose();
		}

		
	}
	
	private void startLogin() throws Exception {
		final LoginDialogVerifier verifier = new LoginDialogVerifier() {
	        @Override
	        public void authenticate(final String login, final String password) throws Exception {
	                if ("".equals(login)) {
	                        throw new Exception("Please enter a login.");
	                }

	                if ("".equals(password)) {
	                        throw new Exception("Please enter a password.");
	                }

	                if (!login.equalsIgnoreCase("hao")) {
	                        throw new Exception("Login unknown.");
	                }

	                if (!password.equalsIgnoreCase("hao")) {
	                        throw new Exception("Authentication failed, please check your password.");
	                }

	        }
		};
		
		final LoginDialog dialog = new LoginDialog();
		dialog.setVerifier(verifier);
		final boolean result = dialog.open();
		if (result) {
		    System.out.println("Login confirmed : " + dialog.getLogin());
		} else {
			throw new Exception("User canceled !");
		}
	}
}

