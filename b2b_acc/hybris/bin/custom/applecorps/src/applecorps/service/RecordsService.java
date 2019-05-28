package applecorps.service;

import java.util.Map;

public interface RecordsService {

    Map<String, String> getRecordDetailsByName(final int id);
}
