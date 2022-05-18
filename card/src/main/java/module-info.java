module card {
    requires static lombok;

    requires java.compiler;
    requires java.persistence;
    requires org.mapstruct;

    requires spring.web;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.data.commons;

    exports az.chaypay.card.service to profile;
    exports az.chaypay.card.controller to spring.core, spring.beans;

    opens az.chaypay.card.repository.entity to org.hibernate.orm.core, spring.core;

    requires shared;
}