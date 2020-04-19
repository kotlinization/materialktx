package com.github.kotlinizer.materialktx

import kotlinx.html.HTMLTag
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class AttributesString<in R : HTMLTag> : ReadWriteProperty<R, String?> {

    override fun getValue(thisRef: R, property: KProperty<*>): String? {
        return thisRef.attributes[property.name]
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: String?) {
        if (value == null) {
            thisRef.attributes.remove(property.name)
        } else {
            thisRef.attributes[property.name] = value
        }
    }

}
