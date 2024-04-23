package service.currentTerm;

import base.service.BaseService;
import model.Current;

import java.util.List;

public interface CurrentTermService extends BaseService<Current, Long> {
    List<Current> findAllCurrentTerms();
}
