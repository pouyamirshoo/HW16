package repository.reportCard;

import base.repository.BaseRepositoryImpl;
import conncetion.SessionFactorySingleton;
import jakarta.persistence.NoResultException;
import model.ReportCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ReportCardRepositoryImpl extends BaseRepositoryImpl<ReportCard,Long> implements ReportCardRepository {
    public ReportCardRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<ReportCard> getEntityClass() {
        return ReportCard.class;
    }

    @Override
    public List<ReportCard> reportCards(Long id) throws NoResultException {
        Session session = SessionFactorySingleton.getInstance().openSession();
        Query<ReportCard> query = session.createQuery(" FROM ReportCard a WHERE a.lessonId =:id",
                ReportCard.class);
        query.setParameter("id",id);
        List<ReportCard> reportCards = query.list();
        session.close();
        return reportCards;
    }

    @Override
    public List<ReportCard> reportCardsStudent(Long id) throws NoResultException {
        Session session = SessionFactorySingleton.getInstance().openSession();
        Query<ReportCard> query = session.createQuery(" FROM ReportCard a WHERE a.studentId =:id",
                ReportCard.class);
        query.setParameter("id",id);
        List<ReportCard> reportCards = query.list();
        session.close();
        return reportCards;
    }
}
