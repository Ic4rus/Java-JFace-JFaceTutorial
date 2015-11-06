package com.icarus.tutorial.jface.treeviewer;

import java.util.List;

import com.icarus.tutorial.jface.model.AppMenu;
import com.icarus.tutorial.jface.provider.AbstractTreeContentLabelProvider;
 
public class AppMenuTreeCLProvider extends AbstractTreeContentLabelProvider {
 
   @Override
   public String getText(Object element) {
       AppMenu appMenu= (AppMenu) element;
       return appMenu.getMenuTitle();
   }
 
   @Override
   public Object[] getElements(Object inputElement) {
       List<AppMenu> menus = (List<AppMenu>) inputElement;
       return menus.toArray();
   }
 
   @Override
   public Object[] getChildren(Object parentElement) {
        AppMenu menu= (AppMenu) parentElement;
        List<AppMenu> children= menu.getChildren();
        return children== null? null: children.toArray();
   }
 
   @Override
   public boolean hasChildren(Object element) {
        AppMenu menu= (AppMenu) element;
        List<AppMenu> children= menu.getChildren();
        return children!= null&&!children.isEmpty();
   }
 
}
