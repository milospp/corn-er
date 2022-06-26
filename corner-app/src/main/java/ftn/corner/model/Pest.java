package ftn.corner.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pest {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Diagnoses pest;

	@ElementCollection(targetClass = PestAttribute.class)
	@JoinTable(name = "tblPestAttributes", joinColumns = @JoinColumn(name = "pestId"))
	@Column(name = "pest_attributes", nullable = false)
	@Enumerated(EnumType.STRING)
	private Collection<PestAttribute> attributes;

	
}
