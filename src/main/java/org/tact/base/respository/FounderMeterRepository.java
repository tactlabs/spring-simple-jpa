package org.tact.base.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tact.base.jpa.domain.FounderMeter;

public interface FounderMeterRepository extends JpaRepository<FounderMeter, Integer> {

	FounderMeter findByLinkedinLink(String liLink);
	
}
