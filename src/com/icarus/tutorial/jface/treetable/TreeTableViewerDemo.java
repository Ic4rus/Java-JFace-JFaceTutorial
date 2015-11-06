package com.icarus.tutorial.jface.treetable;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.TreeColumn;

import com.icarus.tutorial.jface.model.DataModel;

public class TreeTableViewerDemo {

	protected Shell shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TreeTableViewerDemo window = new TreeTableViewerDemo();
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		TreeViewer treeViewer = new TreeViewer(shell, SWT.BORDER);

		DeptEmpTreeTableCLProvider provider = new DeptEmpTreeTableCLProvider();
		treeViewer.setContentProvider(provider);
		treeViewer.setLabelProvider(provider);

		Tree tree = treeViewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);

		TreeColumn trclmnNewColumn = new TreeColumn(tree, SWT.NONE);
		trclmnNewColumn.setWidth(100);
		trclmnNewColumn.setText("Dept No");

		TreeColumn trclmnDeptName = new TreeColumn(tree, SWT.NONE);
		trclmnDeptName.setWidth(100);
		trclmnDeptName.setText("Dept Name");

		TreeColumn trclmnEmpNo = new TreeColumn(tree, SWT.NONE);
		trclmnEmpNo.setWidth(100);
		trclmnEmpNo.setText("Emp No");

		TreeColumn trclmnFirstName = new TreeColumn(tree, SWT.NONE);
		trclmnFirstName.setWidth(100);
		trclmnFirstName.setText("First Name");

		TreeColumn trclmnLastName = new TreeColumn(tree, SWT.NONE);
		trclmnLastName.setWidth(100);
		trclmnLastName.setText("Last Name");

		treeViewer.setInput(DataModel.getDepartments());
	}

}
