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
public class TreatmentHistory {
	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private Treatment treatment;
	private LocalDateTime treatedAt;

	@ManyToOne
	private Plant plant;

	@Override
	public String toString() {
		return "TreatmentHistory [treatment=" + treatment + ", treatedAt=" + treatedAt + "]";
	}
	
	
	
	
}
