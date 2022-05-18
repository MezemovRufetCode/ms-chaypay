module review {
    requires static lombok;

    requires java.compiler;
    requires java.persistence;
    requires org.mapstruct;

    requires spring.web;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.data.commons;

    exports az.chaypay.review.mapper to app, org.mapstruct;
    exports az.chaypay.review.service to profile;
    exports az.chaypay.review.service.impl to spring.beans;

    opens az.chaypay.review.repository.entity to org.hibernate.orm.core, spring.core;

    requires shared;
}