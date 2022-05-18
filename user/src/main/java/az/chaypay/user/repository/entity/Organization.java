package az.chaypay.user.repository.entity;

import az.chaypay.shared.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "organizations", schema = "users")
public class Organization extends BaseEntity {

    private String name;

    private String industry;
}
