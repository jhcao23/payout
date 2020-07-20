package technology.touchmars.model;

import javax.persistence.*;

@MappedSuperclass
public class HasId {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
