package com.michael.webapi.mapper;


public interface IMapper <I,O> {
    public O map(I in);
}
