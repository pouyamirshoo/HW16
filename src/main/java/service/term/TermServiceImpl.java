package service.term;

import base.service.BaseServiceImpl;
import model.Term;
import org.hibernate.SessionFactory;
import repository.term.TermRepository;

public class TermServiceImpl extends BaseServiceImpl<Term,Long, TermRepository> implements TermService {
    public TermServiceImpl(TermRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
