/**
 * IF WE @Idclass then comment the @Embeddable, @EmbeddedId
 * 
 */

package com.spring.datajpa.compositekey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@IdClass(CompositeKeyId.class)
public class CompositeExample {

	
	@EmbeddedId
	CompositeKeyId compositeKeyId;
	//@Id
	//private int id;
   //@Id
   //private String email;
	private String name;
}