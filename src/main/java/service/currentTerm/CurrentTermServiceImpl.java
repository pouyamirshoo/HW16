package service.currentTerm;

import base.service.BaseServiceImpl;
import model.Current;
import org.hibernate.SessionFactory;
import repository.currentTerm.CurrentTermRepository;

public class CurrentTermServiceImpl extends BaseServiceImpl<Current, Long, CurrentTermRepository>
        implements CurrentTermService {
    public CurrentTermServiceImpl(CurrentTermRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

}
