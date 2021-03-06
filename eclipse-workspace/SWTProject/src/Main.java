import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.ProgressBar;

public class Main {

	protected Shell shell;
	private Text txtUsername;
	private Text txtPassword;
	private Label infoLbl;
	private ProgressBar progressBar;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(311, 254);
		shell.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 58, 17);
		lblNewLabel.setText("Username");
		
		txtUsername = new Text(shell, SWT.BORDER);
		txtUsername.setBounds(74, 10, 225, 23);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(10, 39, 58, 17);
		lblNewLabel_1.setText("Password");
		
		txtPassword = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		txtPassword.setBounds(74, 38, 225, 23);
		
		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (txtUsername.getText().equals("nguyenhongphat0") && txtPassword.getText().equals("hongphat")) {
					progressBar.setSelection(100);
					progressBar.setBackground(new Color(null, new RGB(200, 200, 200)));
					infoLbl.setText("Welcome user!");
				} else {
					progressBar.setSelection(0);
					progressBar.setBackground(new Color(null, new RGB(12, 12, 12)));
					infoLbl.setText("Invalid username or password");
				}
			}
		});
		btnLogin.setBounds(220, 67, 79, 28);
		btnLogin.setText("Login");
		
		Button btnRegister = new Button(shell, SWT.NONE);
		btnRegister.setBounds(135, 67, 79, 28);
		btnRegister.setText("Register");
		
		progressBar = new ProgressBar(shell, SWT.NONE);
		progressBar.setState(50);
		progressBar.setSelection(50);
		progressBar.setBounds(10, 101, 289, 6);
		
		infoLbl = new Label(shell, SWT.NONE);
		infoLbl.setBounds(10, 113, 289, 17);

	}
}
