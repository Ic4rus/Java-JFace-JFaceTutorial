package com.icarus.tutorial.jface.tableviewer;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

import java.util.List;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;

import com.icarus.tutorial.jface.model.Article;
import com.icarus.tutorial.jface.model.DataModel;

public class TableViewerDemo {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TableViewerDemo window = new TableViewerDemo();
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
		
		TableViewer tableViewer = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		
		ArticleTableCLProvider provider = new ArticleTableCLProvider();        
		tableViewer.setContentProvider(provider);        
		tableViewer.setLabelProvider(provider);
		
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Article");
		
		TableColumn tblclmnAuthor = new TableColumn(table, SWT.NONE);
		tblclmnAuthor.setWidth(100);
		tblclmnAuthor.setText("Author");
		
		// Sét đặt dữ liệu vào TableViewer.
		List<Article> articleList= DataModel.getArticles();
		tableViewer.setInput(articleList);
	}

}
