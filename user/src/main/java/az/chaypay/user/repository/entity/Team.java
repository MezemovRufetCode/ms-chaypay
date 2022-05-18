package az.chaypay.user.repository.entity;

import az.chaypay.shared.entity.BaseEntity;
import az.chaypay.shared.util.NanoIdUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "teams", schema = "users")
public class Team extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String invitationCode = NanoIdUtils.randomNanoId();

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;
}
