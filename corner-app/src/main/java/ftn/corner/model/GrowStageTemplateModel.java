package ftn.corner.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GrowStageTemplateModel {

	@Id
	@GeneratedValue
	private Long id;

	@Column()
	private PlantTypes plantType;

	@Column()
	private int minDays;

	@Column()
	private int maxDays;

	@Column()
	private GrowStages growStage;


	
	
}
