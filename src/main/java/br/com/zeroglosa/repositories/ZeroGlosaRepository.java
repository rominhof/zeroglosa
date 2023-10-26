package br.com.zeroglosa.repositories;

import br.com.zeroglosa.entities.ZeroGlosa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZeroGlosaRepository extends JpaRepository<ZeroGlosa, Long> {

}
