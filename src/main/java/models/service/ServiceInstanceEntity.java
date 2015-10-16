package models.service;

import evaluators.JsonPathEvaluator;
import evaluators.JsonPathExpression;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import models.LastOperation;

import java.net.URI;
import java.util.*;

@Data
@ToString(exclude = "evaluator")
public class ServiceInstanceEntity {

    protected String name;
    protected Object credentials;
    protected UUID servicePlanGuid;
    protected UUID spaceGuid;
    protected URI dashboardUrl;
    protected String type;
    protected LastOperation lastOperation;
    protected Set<String> tags;
    protected URI spaceUrl;
    protected URI servicePlanUrl;
    protected URI serviceBindingsUrl;
    protected URI serviceKeysUrl;
    protected URI routesUrl;

    @Getter(value = AccessLevel.PRIVATE, lazy = true)
    private transient final JsonPathEvaluator evaluator = initialize();

    private JsonPathEvaluator initialize() {
        return new JsonPathEvaluator(credentials);
    }

    public <T> Optional<T> findCredentialsScalar(JsonPathExpression... expressions) {
        return getEvaluator().scalar(expressions);
    }

    public <T> List<T> findCredentialsList(JsonPathExpression... expressions) {
        return getEvaluator().list(expressions);
    }
}
