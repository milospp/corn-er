package ftn.corner.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plant {
	@Id
	@GeneratedValue
	private Long id;


	@Transient
	private GrowStages growStage;

	@Column
	private String name;

	@Column
	private PlantTypes plantType;

	@Column
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate planted;

	@OneToMany(mappedBy = "plant", fetch = FetchType.EAGER)
	private Set<TreatmentHistory> treatments = new HashSet<TreatmentHistory>();


	@Transient
	private Set<TreatmentHistory> treatmentsSugestion = new HashSet<TreatmentHistory>();
	// private List<SymptomsHistory> symptoms;


	@Transient
	private Set<Symptoms> symptoms = new HashSet<Symptoms>();

	@Transient
	private Set<PestAttribute> pestAttributes;


	@OneToMany(mappedBy = "plant", fetch = FetchType.EAGER)
	private Set<SymptomsHistory> symptomsHistory = new HashSet<SymptomsHistory>();

	@OneToMany(mappedBy = "plant", fetch = FetchType.EAGER)
	private Set<DiagnoseHistory> diagnoseHistory = new HashSet<DiagnoseHistory>();



	public Set<PestAttribute> getPestAttributes() {
		return pestAttributes;
	}
	private Diagnoses currentDiagnose;

	@Transient
	private int daysOld;


	public void addTreatments(TreatmentHistory treatment) {
		this.treatments.add(treatment);
	}

	public void addSymptoms(Symptoms symptom) {
		this.symptoms.add(symptom);
	}

	public void addTreatmentsSugestion(TreatmentHistory treatmentsSugestion) {
		this.treatmentsSugestion.add(treatmentsSugestion);
	}

	@Override
	public String toString() {
		return "Plant [growStage=" + growStage + ",\n plantType=" + plantType + ",\n planted=" + planted + ",\n pestAttributes="
				+ pestAttributes + ",\n treatmentsSugestion=" + treatmentsSugestion + ",\n symptoms=" + symptoms
				+ ",\n currentDiagnose=" + currentDiagnose + ",\n daysOld=" + daysOld + "]";
	}

	
	
	
	
	
}
