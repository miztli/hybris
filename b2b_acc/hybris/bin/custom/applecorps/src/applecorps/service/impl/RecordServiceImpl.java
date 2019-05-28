package applecorps.service.impl;

import applecorps.service.RecordsService;

import java.util.HashMap;
import java.util.Map;

public class RecordServiceImpl implements RecordsService {

    @Override
    public Map<String, String> getRecordDetailsByName(int id) {
        Map<String, String> details = new HashMap<>();
        switch (id) {
            case 1:
                details.put("Title", "Yellow Submarine");
                details.put("Artist", "The Bealtes");
                details.put("Year", "1964");
                details.put("Studios", "Apple Corps");

                return details;
            case 2:
                details.put("Title", "Aqualung");
                details.put("Artist", "Jethro Tull");
                details.put("Year", "1970");
                details.put("Studios", "Unknown");

                return details;
            case 3:
                details.put("Title", "Wish you were here");
                details.put("Artist", "Pink Floyd");
                details.put("Year", "1971");
                details.put("Studios", "Unknown");

                return details;
            default:
                details.put("Error", "Unknown artist id");

                return details;
        }
    }
}
