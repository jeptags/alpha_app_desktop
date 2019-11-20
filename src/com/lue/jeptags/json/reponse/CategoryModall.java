package com.lue.jeptags.json.reponse;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lue
 */
public class CategoryModall {
    
    private List<String> catId1 = new ArrayList<>();
    private List<String> catName = new ArrayList<>();

    public CategoryModall() {
      catName.add("----Select----");
      catId1.add("0");
    }

    
    
    public List<String> getCatId1() {
        return catId1;
    }

    public void setCatId1(List<String> catId1) {
        this.catId1 = catId1;
    }

    public List<String> getCatName() {
        return catName;
    }

    public void setCatName(List<String> catName) {
        this.catName = catName;
    }
    
    
}
