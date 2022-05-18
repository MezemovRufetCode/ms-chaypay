module profile {
    requires static lombok;

    requires java.compiler;
    requires java.persistence;
    requires org.mapstruct;

    requires spring.web;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.data.commons;

    opens az.chaypay.profile.controller to spring.core;

    exports az.chaypay.profile.controller to spring.beans;
    exports az.chaypay.profile.service.impl to spring.beans;
    exports az.chaypay.profile.mapper to app, org.mapstruct;

    requires user;
    requires shared;
    requires review;
    requires transaction;
}