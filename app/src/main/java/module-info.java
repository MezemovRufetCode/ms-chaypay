module app {
    requires java.sql;

    requires spring.core;
    requires spring.boot;
    requires spring.beans;
    requires spring.context;
    requires spring.boot.autoconfigure;

    opens az.chaypay to spring.core;
    opens az.chaypay.config to spring.core;

    exports az.chaypay to spring.beans, spring.context;
    exports az.chaypay.config to spring.beans, spring.context;

    requires profile;
    requires user;
    requires card;
    requires review;
    requires transaction;
}