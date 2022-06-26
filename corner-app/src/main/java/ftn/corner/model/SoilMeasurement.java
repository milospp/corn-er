package ftn.corner.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoilMeasurement {
	@Id
	@GeneratedValue
	private Long id;


	@ManyToOne
	private Plant plant;

	private LocalDateTime datetime;
	private float ph;

	
	
}
