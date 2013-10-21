package com.wannabeblocket.ah;

import com.wannabeblocket.model.Bid;
import com.wannabeblocket.model.Listing;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class for turning a Listing object magically into a XML/JSON string
 * of pure love and understanding.
 * 
 * @author Andreas Arvidsson
 */
@XmlRootElement(name = "listing")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ListingProxy {
    private Listing _listing;
    
    protected ListingProxy() { };
    
    public ListingProxy(Listing listing) {
        this._listing = listing;
    }
    
    @XmlElement(name = "id")
    public Long getId() {
        return _listing.getId();
    }
    
    @XmlElement(name = "title")
    public String getTitle() {
        return _listing.getName();
    }
    
    @XmlElement(name = "seller")
    public String getSeller() {
        return _listing.getSeller().getUserName();
    }
    
    @XmlElement(name = "description")
    public String getDescription() {
        return _listing.getDescription();
    }
    
    @XmlElement(name = "end-time")
    public String getEndTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd:HH:mm:ss");
        return dateFormat.format(_listing.getEndingTime());
    }
}
