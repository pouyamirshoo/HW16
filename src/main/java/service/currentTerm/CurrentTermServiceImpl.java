package service.currentTerm;

import base.service.BaseServiceImpl;
import model.Current;
import org.hibernate.SessionFactory;
import repository.currentTerm.CurrentTermRepository;

import java.util.List;

public class CurrentTermServiceImpl extends BaseServiceImpl<Current, Long, CurrentTermRepository>
        implements CurrentTermService {
    public CurrentTermServiceImpl(CurrentTermRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public List<Current> findAllCurrentTerms() {
        return repository.findAllCurrentTerms();
    }
}
