package com.eden.Desenhos.Repository;

import com.eden.Desenhos.Entity.Lists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListsRepository extends JpaRepository<Lists,Long> {
}
