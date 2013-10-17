package com.wannabeblocket.core.navigation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aram Timofeitchik
 */
public class Navigation{
    private List<NavigationNode> _children;
    
    public Navigation(){
        _children = new ArrayList<>();
    }
    
    public List<NavigationNode> getChildren(){
        return _children;
    }
    
    @Override
    public String toString(){
        String html = "";
        
        for(NavigationNode node : _children){
            html += "<li>" + node.toString() + "</li>";
        }
        
        return html.isEmpty() ? html : "<ul>" + html + "</ul>";
    }
}
