package lab.phb.amaliyahgian.repo;

import lab.phb.amaliyahgian.entity.DataMahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataMahasiswaRepo extends JpaRepository<DataMahasiswa, String> {
}
