module user {
    requires static lombok;

    requires java.compiler;
    requires java.persistence;
    requires org.mapstruct;

    requires spring.web;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.data.commons;

    opens az.chaypay.user.controller to spring.core;

    exports az.chaypay.user.service to profile;
    exports az.chaypay.user.controller to spring.beans;
    exports az.chaypay.user.service.impl to spring.beans;
    exports az.chaypay.user.mapper to app, org.mapstruct;

    opens az.chaypay.user.repository.entity to org.hibernate.orm.core, spring.core;

    requires shared;
}