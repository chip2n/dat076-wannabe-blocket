package com.wannabeblocket.core.navigation;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a node in the navigation bean base class.
 */
public class NavigationNode {
    private List<NavigationNode> _children;
    
    private String _id;
    private String _title;
    private String _url;
    
    /**
     * Initializes a new instance of the NavigationNode class.
     * @param title The title of the node.
     * @param url The URL of the node.
     */    
    public NavigationNode(String title, String url) {
        this(title, url, "");
    }
    
    /**
     * Initializes a new instance of the NavigationNode class.
     * @param title The title of the node.
     * @param url The URL of the node.
     * @param id  The id of the node.
     */
    public NavigationNode(String title, String url, String id){
        this._title = title == null ? "" : title;
        this._url = url == null ? "javascript:void(0);" : url;
        this._id = id == null ? "" : id;
        this._children = new ArrayList<>();
    }
    
    /**
     * Returns the title of the node.
     * @return the title of the node.
     */
    public String getTitle(){ return _title; }
    
    /**
     * Returns the URL of the node.
     * @return the URL of the node.
     */
    public String getUrl(){ return _url; }
    
    /**
     * Returns the child nodes. 
     * @return the child nodes.
     */
    public List<NavigationNode> getChildren(){ return _children; }
    
    /**
     * Returns the HTML of the node and it child nodes.
     * @return A String containing the HTML of the node and its child nodes. 
     */    
    @Override
    public String toString(){
        return this.toString(0);
    }    
    
    /**
     * Returns the HTML of the node and it child nodes.
     * @param level The level of the navigation node.
     * @return A String containing the HTML of the node and its child nodes. 
     */
    public String toString(int level){   
        String html = "<a" + (_id.isEmpty() ? "" : " id='" + _id + "'") + 
                " class=\"node-level" + level + "\" href=\"" + this._url + "\">" + this._title + "</a>";
        
        for(NavigationNode node : _children){
            html += node.toString(level + 1);
        }
        
        return html;
    }    
}
