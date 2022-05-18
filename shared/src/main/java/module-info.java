module shared {
    requires static lombok;

    requires java.persistence;
    requires org.hibernate.orm.core;
    requires com.fasterxml.jackson.databind;

    exports az.chaypay.shared.entity;
    exports az.chaypay.shared.common;
    exports az.chaypay.shared.util;

    opens az.chaypay.shared.entity to org.hibernate.orm.core, spring.core;

    exports az.chaypay.shared.user to user, profile, org.hibernate.orm.core, com.fasterxml.jackson.databind;
    exports az.chaypay.shared.user.exception to user;

    exports az.chaypay.shared.transaction to transaction, profile, org.hibernate.orm.core;

    exports az.chaypay.shared.review to review, profile, org.hibernate.orm.core;

    exports az.chaypay.shared.card to card, profile;

    exports az.chaypay.shared.profile to profile, com.fasterxml.jackson.databind;

}