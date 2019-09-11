package com.tomlettuces.user

import com.tomlettuces.user.delegate.PropertyChangeAware
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {

    private val observer = {
        prop: KProperty<*>, oldValue: Any, newValue: Any ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)

    override fun toString(): String {
        return "Person(name='$name', age=$age, salary=$salary)"
    }


}