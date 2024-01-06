package com.example.express.Repository;

import com.example.express.Entity.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<Emprunt,Long> {
}
