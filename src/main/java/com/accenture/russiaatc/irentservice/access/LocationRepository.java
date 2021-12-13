package com.accenture.russiaatc.irentservice.access;

import com.accenture.russiaatc.irentservice.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository <Location, Long> {
}
