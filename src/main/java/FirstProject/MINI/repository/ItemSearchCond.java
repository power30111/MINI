package FirstProject.MINI.repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSearchCond {

    private String itemName;
    private Integer maxPrice;

    public ItemSearchCond(){
    }

    public ItemSearchCond(String itemName, Integer maxPrice) {
        this.itemName = itemName;
        this.maxPrice = maxPrice;
    }
}
