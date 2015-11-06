package com.icarus.tutorial.jface.tableviewer;

import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import com.icarus.tutorial.jface.model.Article;
import com.icarus.tutorial.jface.provider.AbstractTableContentLabelProvider;
 
public class ArticleTableCLProvider extends AbstractTableContentLabelProvider {
 
   private Image image;
 
   public ArticleTableCLProvider() {
       LocalResourceManager jfaceRsManager = new LocalResourceManager(
               JFaceResources.getResources(),
               Display.getCurrent().getShells()[0]);
 
       ImageDescriptor imageDescriptor = ImageDescriptor.createFromFile(
               ArticleTableCLProvider.class,
               "/com/icarus/tutorial/jface/image/check.png");
       image = jfaceRsManager.createImage(imageDescriptor);
   }
 
   @Override
   public String getColumnText(Object element, int columnIndex) {
       Article article = (Article) element;
       switch (columnIndex) {
 
       case 0:// 0 - Ứng với cột đầu tiên.
           return article.getTitle();
 
       case 1:// 1 - Ứng với cột thứ 2
           return article.getAuthor();
       default:
           return null;
       }
   }
 
   @Override
   public Image getColumnImage(Object element, int columnIndex) {
       Article article = (Article) element;
       switch (columnIndex) {
 
       case 0:// 0 - Ứng với cột đầu tiên.
           if (article.isPublished()) {
               return image;
           }
       default:
           return null;
       }
   }
 
   // input tại đây có được từ viewer.setInput(...)
   @Override
   public Object[] getElements(Object input) {
       List<Article> list = (List<Article>) input;
       return list.toArray();
   }
 
}