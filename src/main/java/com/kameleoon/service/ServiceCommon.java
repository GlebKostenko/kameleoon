package com.kameleoon.service;

import java.sql.SQLException;

public interface ServiceCommon<T> {
    T save(T t) throws SQLException;
}
