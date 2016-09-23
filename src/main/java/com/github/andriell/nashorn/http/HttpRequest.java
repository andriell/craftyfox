package com.github.andriell.nashorn.http;

import org.apache.http.client.methods.RequestBuilder;

import java.net.URI;

/**
 * Created by Rybalko on 23.09.2016.
 */
public class HttpRequest {

    public RequestBuilder create(final String method) {
        return RequestBuilder.create(method);
    }

    public RequestBuilder get() {
        return RequestBuilder.get();
    }

    public RequestBuilder get(final URI uri) {
        return RequestBuilder.get(uri);
    }

    public RequestBuilder get(final String uri) {
        return RequestBuilder.get(uri);
    }

    public RequestBuilder head() {
        return RequestBuilder.head();
    }

    public RequestBuilder head(final URI uri) {
        return RequestBuilder.head(uri);
    }

    public RequestBuilder head(final String uri) {
        return RequestBuilder.head(uri);
    }

    public RequestBuilder patch() {
        return RequestBuilder.patch();
    }

    public RequestBuilder patch(final URI uri) {
        return RequestBuilder.patch(uri);
    }

    public RequestBuilder patch(final String uri) {
        return RequestBuilder.patch(uri);
    }

    public RequestBuilder post() {
        return RequestBuilder.post();
    }

    public RequestBuilder post(final URI uri) {
        return RequestBuilder.post(uri);
    }

    public RequestBuilder post(final String uri) {
        return RequestBuilder.post(uri);
    }

    public RequestBuilder put() {
        return RequestBuilder.put();
    }

    public RequestBuilder put(final URI uri) {
        return RequestBuilder.put(uri);
    }

    public RequestBuilder put(final String uri) {
        return RequestBuilder.put(uri);
    }

    public RequestBuilder delete() {
        return RequestBuilder.delete();
    }

    public RequestBuilder delete(final URI uri) {
        return RequestBuilder.delete(uri);
    }

    public RequestBuilder delete(final String uri) {
        return RequestBuilder.delete(uri);
    }

    public RequestBuilder trace() {
        return RequestBuilder.trace();
    }

    public RequestBuilder trace(final URI uri) {
        return RequestBuilder.trace(uri);
    }

    public RequestBuilder trace(final String uri) {
        return RequestBuilder.trace(uri);
    }

    public RequestBuilder options() {
        return RequestBuilder.options();
    }

    public RequestBuilder options(final URI uri) {
        return RequestBuilder.options(uri);
    }

    public RequestBuilder options(final String uri) {
        return RequestBuilder.options(uri);
    }

    public RequestBuilder copy(final org.apache.http.HttpRequest request) {
        return RequestBuilder.copy(request);
    }
}
