package io.namoosori.travelclub.spring.aggregate;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public abstract class Entity {
	 //abstract로 만들어서 모든 Class는 이것을 상속하도록 만들어야 한다. String id.

	protected String id;

	//
	protected Entity() {
		//
		this.id = UUID.randomUUID().toString();
	}

	protected Entity(String id) {
		//
		this.id = id;
	}
}
