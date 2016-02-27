package egen.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class Genre {
	
	@Id
	 @GeneratedValue(generator="uuid2")
	 @GenericGenerator(strategy="uuid2", name = "uuid2")
	@Setter private String genreId;
	
	@Column(nullable=false, unique=true)
	@Getter @Setter private String genreName;
	
	
}
