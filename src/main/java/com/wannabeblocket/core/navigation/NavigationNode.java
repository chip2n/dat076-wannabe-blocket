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
public class NavigationNode {
    private List<NavigationNode> _children;
    
    private String _title;
    private String _url;
    
    public NavigationNode(String title, String url){
        this._title = title == null ? "" : title;
        this._url = url == null ? "javascript:void(0);" : url;
        this._children = new ArrayList<NavigationNode>();
    }
    
    public String getTitle(){
        return _title;
    }
    
    public String getUrl(){
        return _url;
    }
    
    public List<NavigationNode> getChildren(){
        return _children;
    }
    
    public String getHtml(){
        String html = "";
        
        for(NavigationNode node : _children){
            html += "<a class=\"subnode\" href=\"" + node.getUrl() + "\">" + node.getTitle() + "</a>";
        }
        
        return html;
    }    
}
