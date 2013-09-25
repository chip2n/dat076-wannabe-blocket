/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.core.navigation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aram Timofeitchik
 */
public class Navigation {
    private List<NavigationNode> _children;
    
    public Navigation(){
        _children = new ArrayList<NavigationNode>();
    }
    
    public List<NavigationNode> getChildren(){
        return _children;
    }
    
    public String getHtml(){
        String html = "";
        
        for(NavigationNode node : _children){
            html += "<li>" + 
                        "<a class=\"node\" href=\"" + node.getUrl() + "\">" + node.getTitle() + "</a>" +
                        node.getHtml() +
                    "</li>";
        }
        
        return html.isEmpty() ? html : "<ul>" + html + "</ul>";
    }
}
