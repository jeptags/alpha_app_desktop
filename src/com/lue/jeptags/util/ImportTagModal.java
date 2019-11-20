package com.lue.jeptags.util;

/**
 *
 * @author Kundan
 */
public class ImportTagModal {
    
    private String tag_type;
    private String tag_id;
    private String jeptag_id;
    private String seller_id;

    public ImportTagModal(String tag_type, String tag_id, String jeptag_id, String seller_id) {
        this.tag_type = tag_type;
        this.tag_id = tag_id;
        this.jeptag_id = jeptag_id;
        this.seller_id = seller_id;
    }

    
    
    public String getTag_type() {
        return tag_type;
    }

    public void setTag_type(String tag_type) {
        this.tag_type = tag_type;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public String getJeptag_id() {
        return jeptag_id;
    }

    public void setJeptag_id(String jeptag_id) {
        this.jeptag_id = jeptag_id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }
    
    
}
