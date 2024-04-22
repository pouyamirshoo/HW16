package repository.term;

import base.repository.BaseRepositoryImpl;
import model.Term;
import org.hibernate.SessionFactory;

public class TermRepositoryImpl extends BaseRepositoryImpl<Term,Long> implements TermRepository {
    public TermRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Term> getEntityClass() {
        return Term.class;
    }
}
