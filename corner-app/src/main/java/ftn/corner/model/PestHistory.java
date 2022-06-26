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
public class PestHistory {
	@Id
	@GeneratedValue
	private Long id;


	@Column
	private LocalDateTime spotedAt;

	@Column
	private LocalDateTime healedAt;

	@OneToOne
	private Pest pest;
}
