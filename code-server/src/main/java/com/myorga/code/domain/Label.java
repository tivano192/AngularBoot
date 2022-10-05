package com.myorga.code.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Label.
 */
@Entity
@Table(name = "label")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Label implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 3)
    @Column(name = "label", nullable = false)
    private String label;

    @ManyToMany(mappedBy = "labels")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "bankAccount", "labels" }, allowSetters = true)
    private Set<Operation> operations = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public Label id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return this.label;
    }

    public Label label(String label) {
        this.setLabel(label);
        return this;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<Operation> getOperations() {
        return this.operations;
    }

    public void setOperations(Set<Operation> operations) {
        if (this.operations != null) {
            this.operations.forEach(i -> i.removeLabel(this));
        }
        if (operations != null) {
            operations.forEach(i -> i.addLabel(this));
        }
        this.operations = operations;
    }

    public Label operations(Set<Operation> operations) {
        this.setOperations(operations);
        return this;
    }

    public Label addOperation(Operation operation) {
        this.operations.add(operation);
        operation.getLabels().add(this);
        return this;
    }

    public Label removeOperation(Operation operation) {
        this.operations.remove(operation);
        operation.getLabels().remove(this);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Label)) {
            return false;
        }
        return id != null && id.equals(((Label) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Label{" +
            "id=" + getId() +
            ", label='" + getLabel() + "'" +
            "}";
    }
}
