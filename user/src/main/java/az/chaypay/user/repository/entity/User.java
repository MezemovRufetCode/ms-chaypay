package az.chaypay.user.repository.entity;

import az.chaypay.shared.entity.BaseEntity;
import az.chaypay.shared.user.UserRole;
import az.chaypay.shared.user.UserStatus;
import az.chaypay.shared.util.NanoIdUtils;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users", schema = "users")
public class User extends BaseEntity {

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @Column(name = "qrcode", unique = true)
    private String qrCode = NanoIdUtils.randomNanoId();

    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.CREATED;

    private String verifier;

    private String salt;
}
