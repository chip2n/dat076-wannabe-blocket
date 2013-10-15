package com.wannabeblocket.ah;

import com.wannabeblocket.model.Listing;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
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
    
    @XmlElement(name = "seller")
    public String getSeller() {
        return _listing.getSeller().getUserName();
    }
}
