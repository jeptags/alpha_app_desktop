package com.lue.jeptags.util;

/**
 *
 * @author lue
 */
public class TagImportModel {
 
    private int serialNo;
    private String tagId;
    private String tagType;
    private String jepTagId;
    private String sellerId;

    public TagImportModel() {
    }

    public TagImportModel(int serialNo, String tagId, String tagType, String jepTagId,String sellerId) {
        this.serialNo = serialNo;
        this.tagId = tagId;
        this.tagType = tagType;
        this.jepTagId = jepTagId;
        this.sellerId=sellerId;
    }

    
    
    
    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    public String getJepTagId() {
        return jepTagId;
    }

    public void setJepTagId(String jepTagId) {
        this.jepTagId = jepTagId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
    
    
    
}
