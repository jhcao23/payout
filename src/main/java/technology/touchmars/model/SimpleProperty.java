package technology.touchmars.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class SimpleProperty {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	private Long id;

	@Column(unique = true)
	private String key;

	@XmlAttribute(name = "simple_value")
	private String simpleValue;

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSimpleValue() {
		return simpleValue;
	}

	public void setSimpleValue(String value) {
		this.simpleValue = value;
	}

	@Override
	public String toString() {
		return "SimpleProperty [key=" + key + ", value=" + simpleValue + "]";
	}

}