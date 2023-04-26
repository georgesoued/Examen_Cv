package sn.esmt.CV.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.esmt.CV.entities.CvEntity;

@Repository
public interface CvRepository extends JpaRepository<CvEntity, Integer> {
    CvEntity findById(int id);

    CvEntity findByEmailAndAdresse(String email, String adresse);

}
