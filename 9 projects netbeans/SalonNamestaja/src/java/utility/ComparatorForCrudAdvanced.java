
package utility;

import java.util.Comparator;
import model.CrudAdvancedData;

public class ComparatorForCrudAdvanced implements Comparator<CrudAdvancedData> {

    @Override
    public int compare(CrudAdvancedData o1, CrudAdvancedData o2) {
        
        return o1.getMessage().compareTo(o2.getMessage());
    }
    
}
