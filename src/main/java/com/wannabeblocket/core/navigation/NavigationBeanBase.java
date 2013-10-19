package com.wannabeblocket.core.navigation;

import java.util.List;
import java.util.ArrayList;
import com.wannabeblocket.core.BeanBase;

/**
 * Navigation bean base class.
 */
public class NavigationBeanBase extends BeanBase {
    private List<NavigationNode> _children;
    
    /**
     * Initializes a new instance of the NavigationBeanBase class.
     */
    public NavigationBeanBase(){
        _children = new ArrayList<>();
    }
    
    /**
     * Returns the child nodes.
     * @return the child nodes.
     */
    public List<NavigationNode> getChildren(){ return _children; }
    
    /**
     * Returns the HTML of the navigation nodes.
     * @return A String containing the HTML of the navigation nodes.
     */
    @Override
    public String toString(){
        String html = "";
        
        for(NavigationNode node : _children){
            html += "<li>" + node.toString() + "</li>";
        }
        
        return html.isEmpty() ? html : "<ul>" + html + "</ul>";
    }
}
