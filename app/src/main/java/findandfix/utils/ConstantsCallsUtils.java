package findandfix.utils;

import findandfix.model.response.BrandsResponse;

/**
 * Created by DELL on 04/04/2018.
 */

public class ConstantsCallsUtils {

    private static ConstantsCallsUtils constantsCallsUtils;
    private BrandsResponse brandsResponse=null;

    private ConstantsCallsUtils(){}
    public static ConstantsCallsUtils getInstance(){
        if (constantsCallsUtils==null)
            constantsCallsUtils=new ConstantsCallsUtils();
        return constantsCallsUtils;
    }






}
