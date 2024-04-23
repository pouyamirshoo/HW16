package repository.currentTerm;

import base.repository.BaseRepository;
import model.Current;

import java.util.List;

public interface CurrentTermRepository extends BaseRepository<Current, Long> {
    List<Current> findAllCurrentTerms();
}
