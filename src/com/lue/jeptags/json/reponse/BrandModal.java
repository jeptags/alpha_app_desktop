package com.lue.jeptags.json.reponse;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lue
 */
public class BrandModal {
    
    private List<String> brandId=new ArrayList<String>();
    private List<String> brandName=new ArrayList<String>();

    public BrandModal() {
         brandId.add("0");
        brandName.add("---Select----");
    }
    
    

    public List<String> getBrandId() {
        return brandId;
    }

    public void setBrandId(List<String> brandId) {
        this.brandId = brandId;
    }

    public List<String> getBrandName() {
        return brandName;
    }

    public void setBrandName(List<String> brandName) {
        this.brandName = brandName;
    }
    
    
}
