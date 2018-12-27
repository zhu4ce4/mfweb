package com.lqj.DAO;

import com.lqj.entity.Critics;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ctdao")
public interface CriticsDAO extends JpaRepository<Critics, Integer> {
    List<Critics> findByTlid(int tlid,Pageable pageable);
    List<Critics> findByTlid(int tlid);
}
