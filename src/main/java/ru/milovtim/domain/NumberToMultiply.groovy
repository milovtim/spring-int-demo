package ru.milovtim.domain

import groovy.transform.Canonical

@Canonical
class NumberToMultiply {

    final int value
    int multiplied

    NumberToMultiply(int value) {
        this.value = value
    }

}
