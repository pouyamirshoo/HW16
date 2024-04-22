package repository.reportCard;

import base.repository.BaseRepository;
import jakarta.persistence.NoResultException;
import model.ReportCard;

import java.util.List;

public interface ReportCardRepository extends BaseRepository<ReportCard,Long> {

    List<ReportCard> reportCards(Long id) throws NoResultException;
    List<ReportCard> reportCardsStudent(Long id) throws NoResultException;

}
