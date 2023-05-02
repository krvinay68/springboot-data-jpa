/**
 * IF WE @Idclass then comment the @Embeddable
 * 
 */

package com.spring.datajpa.compositekey;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class CompositeKeyId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String email;
	
   
}
