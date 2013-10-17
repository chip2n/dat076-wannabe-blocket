package com.wannabeblocket.core.navigation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aram Timofeitchik
 */
public class NavigationNode {
    private List<NavigationNode> _children;
    
    private String _id;
    private String _title;
    private String _url;
    
    public NavigationNode(String title, String url) {
        this(title, url, "");
    }
    
    public NavigationNode(String title, String url, String id){
        this._title = title == null ? "" : title;
        this._url = url == null ? "javascript:void(0);" : url;
        this._id = id == null ? "" : id;
        this._children = new ArrayList<>();
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
    
    @Override
    public String toString(){
        return this.toString(0);
    }    
    
    public String toString(int level){   
        String html = "<a" + (_id.isEmpty() ? "" : " id='" + _id + "'") + 
                " class=\"node-level" + level + "\" href=\"" + this._url + "\">" + this._title + "</a>";
        
        for(NavigationNode node : _children){
            html += node.toString(level + 1);
        }
        
        return html;
    }    
}
