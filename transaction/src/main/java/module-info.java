module transaction {
    requires static lombok;

    requires java.compiler;
    requires java.persistence;
    requires org.mapstruct;

    requires spring.web;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.data.commons;

    opens az.chaypay.transaction.controller to spring.core;

    exports az.chaypay.transaction.service to profile;
    exports az.chaypay.transaction.controller to spring.beans;
    exports az.chaypay.transaction.service.impl to spring.beans;
    exports az.chaypay.transaction.mapper to app, org.mapstruct;

    opens az.chaypay.transaction.repository.entity to org.hibernate.orm.core, spring.core;

    requires shared;
}